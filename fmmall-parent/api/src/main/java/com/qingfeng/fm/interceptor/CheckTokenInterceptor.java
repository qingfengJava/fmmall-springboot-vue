package com.qingfeng.fm.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //放行OPTIONS请求
        String method = request.getMethod();
        System.out.println(method);
        if ("OPTIONS".equalsIgnoreCase(method)){
            return true;
        }

        String token = request.getHeader("token");
        System.out.println("--------------"+token);

        if (token == null){
            ResultVO resultVO = new ResultVO(ResStatus.NO, "请先登录！", null);
            //提示先登录
            doResponse(response,resultVO);
        }else{
            try {
                //验证token
                JwtParser parser = Jwts.parser();
                //解析token的SingingKey必须和生成token时设置的密码一致
                parser.setSigningKey("QIANfeng6666");
                //如果token正确（密码正确，有效期内），则正常运行，否则抛出异常
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                return true;
            } catch(ExpiredJwtException e){
                ResultVO resultVO = new ResultVO(ResStatus.NO, "登录过期，请重新登录！", null);
                doResponse(response,resultVO);
            } catch(UnsupportedJwtException e){
                ResultVO resultVO = new ResultVO(ResStatus.NO, "token不合法，请自重！", null);
                doResponse(response,resultVO);
            } catch (Exception e) {
                ResultVO resultVO = new ResultVO(ResStatus.NO, "请先登录！", null);
                doResponse(response,resultVO);
            }
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
