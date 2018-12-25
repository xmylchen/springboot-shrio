package cn.ylchen.web.api;

import cn.ylchen.model.ShRole;
import cn.ylchen.model.ShUser;
import cn.ylchen.service.ShRoleService;
import cn.ylchen.service.ShUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/shiro")
public class TestController {
    @Autowired
    private ShUserService userService;
    @Autowired
    private ShRoleService roleService;

    @RequestMapping(value = "test1",method = RequestMethod.GET)
    public List<ShUser> userList(){
        return userService.getAll();
    }
    @RequestMapping(value = "test2",method = RequestMethod.GET)
    public List<ShRole> roleList(){
        return roleService.getAll();
    }

    @RequestMapping(value = "test3",method = RequestMethod.GET)
    public String list(){
        return "this is test from shiro";
    }
}

