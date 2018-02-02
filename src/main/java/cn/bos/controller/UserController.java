package cn.bos.controller;


import cn.bos.mapper.RoleMapper;
import cn.bos.mapper.UserMapper;
import cn.bos.domain.pojo.TUser;
import cn.bos.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;

    @RequestMapping("/login")
    public String login(HttpServletRequest request,TUser user,String checkcode){
        HttpSession session = request.getSession();
        String key = (String)session.getAttribute("key");
        String password = user.getPassword();
        Subject subject = SecurityUtils.getSubject();
        String username = user.getUsername();
        //构造一个用户名密码令牌
        AuthenticationToken token = new UsernamePasswordToken(username, MD5Utils.md5(password));

        if(key!=null&&key.equals(checkcode))
        {

            try{
                subject.login(token);
            }catch (UnknownAccountException e) {
                //设置错误信息

                return "login";
            }catch (Exception e) {
                //设置错误信息

                return "login";
            }

        }



        return "index";
    }
}
