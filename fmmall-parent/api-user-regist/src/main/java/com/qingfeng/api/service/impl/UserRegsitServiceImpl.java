package com.qingfeng.api.service.impl;

import com.qingfeng.api.service.UserRegsitService;
import com.qingfeng.api.service.feign.UserCheckClient;
import com.qingfeng.api.service.feign.UserSaveClient;
import com.qingfeng.fm.beans.Users;
import com.qingfeng.fm.utils.MD5Utils;
import com.qingfeng.fm.vo.ResStatus;
import com.qingfeng.fm.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/20
 */
@Service
public class UserRegsitServiceImpl implements UserRegsitService {

    @Autowired
    private UserCheckClient userCheckClient;
    @Autowired
    private UserSaveClient userSaveClient;

    @Override
    public ResultVO regist(String name, String pwd) {
        synchronized (this) {
            //1、调用user-save服务 ，查询用户是否已经被注册
            Users user = userCheckClient.check(name);


            //2、如果没有被注册，则进行保存操作
            if (user == null) {
                //使用MD5加密技术对密码进行加密
                String md5Pwd = MD5Utils.md5(pwd);
                user = new Users();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("img/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                //3、调用user-save服务插入数据，并且主键回填
                int i = userSaveClient.save(user);

                if (i > 0) {
                    return new ResultVO(ResStatus.OK, "注册成功！", user);
                } else {
                    return new ResultVO(ResStatus.NO, "注册失败！", null);
                }
            } else if (user.getUsername() == null){
                return new ResultVO(ResStatus.NO, "网络故障，请重试！！！", null);
            }else{
                return new ResultVO(ResStatus.NO, "用户名已被注册，请更换用户名！！！", null);
            }
        }
    }
}
