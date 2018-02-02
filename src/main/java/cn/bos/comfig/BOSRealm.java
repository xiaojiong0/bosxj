package cn.bos.comfig;

import cn.bos.mapper.RoleMapper;
import cn.bos.mapper.UserMapper;
import cn.bos.domain.pojo.TUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义realm
 *
 * @author zhaoqx
 */
public class BOSRealm extends AuthorizingRealm {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;

    /**
     * 认证方法
     */
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证方法。。。");
        UsernamePasswordToken toke = (UsernamePasswordToken) token;
        TUser user = new TUser();
        user.setUsername(toke.getUsername());
        TUser user1 = userMapper.selectOne(user);
        if (user1 == null) {
            // 用户名不存在
            return null;
        } else {
            // 用户名存在
            String password = user1.getPassword();// 获得数据库中存储的密码
            // 创建简单认证信息对象
            /***
             * 参数一：签名，程序可以在任意位置获取当前放入的对象
             * 参数二：从数据库中查询出的密码
             * 参数三：当前realm的名称
             */
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user1,
                    password, this.getClass().getSimpleName());
            return info;//返回给安全管理器，由安全管理器负责比对数据库中查询出的密码和页面提交的密码
        }
    }


    /**
     * 授权方法
     */
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        return null;
    }

}
