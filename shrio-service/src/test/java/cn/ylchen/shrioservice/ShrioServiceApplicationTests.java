package cn.ylchen.shrioservice;

import cn.ylchen.model.ShPermission;
import cn.ylchen.model.ShRole;
import cn.ylchen.model.ShUser;
import cn.ylchen.service.ShPermissionService;
import cn.ylchen.service.ShRoleService;
import cn.ylchen.service.ShUserService;
import cn.ylchen.util.HashHelper;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md2Hash;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.provider.MD5;

import javax.annotation.Resource;

import java.util.List;

import static org.assertj.core.util.DateUtil.now;

@RunWith(SpringRunner.class)
@SpringBootTest()
@ComponentScan
public class ShrioServiceApplicationTests {

    @Autowired
    private ShUserService userService;
    @Autowired
    private ShPermissionService permissionService;
    @Autowired
    private ShRoleService roleService;

    @Test
    public void createTest(){
        ShUser user = new ShUser();
        user.setCreateTime(now());
        user.setUsername("admin");
        String random=new SecureRandomNumberGenerator().nextBytes().toHex();
        user.setSalt(random);
        String result = new Md5Hash("123456",random,3).toString();
        user.setPassword(result);
        user.setUser_id(HashHelper.generateId());
        userService.create(user);
    }

    @Test
    public void permissTest(){
        ShPermission permission = new ShPermission();
        permission.setPermission_id(HashHelper.generateId());
        permission.setName("role_dfd");
        permission.setStatus(1);
        List<String> te = permissionService.selectPermissionByUserId("8cdc1d0b43394329b601dab75ade79a2");
        System.out.println(te);
    }

    @Test
    public void roleTest(){
        ShRole role = new ShRole();
        role.setRole_id(HashHelper.generateId());
        role.setName("test1");
        role.setStatus(1);
        roleService.create(role);
    }

    @Test
    public void contextLoads() {
    }

}

