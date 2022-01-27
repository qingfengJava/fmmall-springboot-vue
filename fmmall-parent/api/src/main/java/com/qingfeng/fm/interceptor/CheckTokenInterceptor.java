package com.qingfeng.fm.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * 定义一个拦截器
 *
 * 在配置类中添加拦截器，定义我们要拦截的路径。
 * 拦截之后。满足条件返回true，继续安装路径执行。
 * 若不满足条件，返回false，执行结束。
 *
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/11/21
 */
@Component
public class CheckTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //放行OPTIONS请求
        String method = request.getMethod();
        if ("OPTIONS".equalsIgnoreCase(method)){
            return true;
        }

        String token = request.getHeader("token");

        if (token == null){
            //未登录，状态码是20001
            ResultVO resultVO = new ResultVO(ResStatus.LOGIN_FAIL_NOT, "请先登录！", null);
            //提示先登录
            doResponse(response,resultVO);
        }else{
            //通过redis验证token
            String userInfo = stringRedisTemplate.boundValueOps(token).get();
            if (userInfo == null){
                //未登录，状态码是20001
                ResultVO resultVO = new ResultVO(ResStatus.LOGIN_FAIL_NOT, "请先登录！", null);
                //提示先登录
                doResponse(response,resultVO);
            }else{
                //验证通过
                stringRedisTemplate.boundValueOps(token).expire(30, TimeUnit.MINUTES);
            }

           /** try {
                //验证token
                JwtParser parser = Jwts.parser();
                //解析token的SingingKey必须和生成token时设置的密码一致
                parser.setSigningKey("QIANfeng6666");
                //如果token正确（密码正确，有效期内），则正常运行，否则抛出异常
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                return true;
            } catch(ExpiredJwtException e){
                //登录过期，状态码20002
                ResultVO resultVO = new ResultVO(ResStatus.LOGIN_FAIL_OVERDUE, "登录过期，请重新登录！", null);
                doResponse(response,resultVO);
            } catch(UnsupportedJwtException e){
                ResultVO resultVO = new ResultVO(ResStatus.NO, "token不合法，请自重！", null);
                doResponse(response,resultVO);
            } catch (Exception e) {
                ResultVO resultVO = new ResultVO(ResStatus.LOGIN_FAIL_NOT, "请先登录！", null);
                doResponse(response,resultVO);
            }*/
        }
        return false;
    }

    private void doResponse(HttpServletResponse response,ResultVO resultVO) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String s = new ObjectMapper().writeValueAsString(resultVO);
        out.print(s);
        out.flush();
        out.close();
    }
}
