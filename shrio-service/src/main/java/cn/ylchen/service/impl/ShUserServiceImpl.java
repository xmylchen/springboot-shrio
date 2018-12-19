package cn.ylchen.service.impl;

import cn.ylchen.dao.userDao;
import cn.ylchen.model.ShUser;
import cn.ylchen.service.ShUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service(value = "ShUserService")
public class ShUserServiceImpl implements ShUserService {

    @Resource
    private userDao userDao;

    @Override
    public ShUser get(String username) {
        return userDao.get(username);
    }

    @Override
    public List<ShUser> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<ShUser> getPaged(Map<String, Object> params) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public int create(ShUser user) {
        return userDao.create(user);
    }

    @Override
    public int delete(String username) {
        return userDao.delete(username);
    }

    @Override
    public int update(ShUser user) {
        return userDao.update(user);
    }
}
