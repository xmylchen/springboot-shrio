package cn.ylchen.shrioservice;

import cn.ylchen.model.ShUser;
import cn.ylchen.service.ShUserService;
import cn.ylchen.util.HashHelper;
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

import static org.assertj.core.util.DateUtil.now;

@RunWith(SpringRunner.class)
@SpringBootTest()
@ComponentScan
public class ShrioServiceApplicationTests {

    @Autowired
    private ShUserService userService;

    @Test
    public void createTest(){
        ShUser user = new ShUser();
        user.setCreateTime(now());
        user.setUsername("ylchen");

        userService.delete("ylchen");
    }

    @Test
    public void contextLoads() {
    }

}

