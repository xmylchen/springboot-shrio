package cn.ylchen.web.config;

import cn.ylchen.model.ShPermission;
import cn.ylchen.model.ShUser;
import cn.ylchen.service.ShPermissionService;
import cn.ylchen.service.ShRoleService;
import cn.ylchen.service.ShUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRealm.class);
    @Autowired
    private ShUserService userService;
    @Autowired
    private ShPermissionService permissionService;
    @Autowired
    private ShRoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShUser shUser = (ShUser) principals.getPrimaryPrincipal();
        List<ShPermission> sysPermissions = permissionService.selectPermissionByUserId(shUser.getUser_id());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (ShPermission permission : sysPermissions){
            info.addStringPermission(permission.getUrl());
        }
        LOGGER.info("doGetAuthorizationInfo");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        ShUser sysUser = userService.get(token.getUsername());
        if (sysUser == null) {
            return null;
        }
        LOGGER.info("doGetAuthenticationInfo");
        return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword().toCharArray(), ByteSource.Util.bytes(sysUser.getSalt()), getName());
    }
}
