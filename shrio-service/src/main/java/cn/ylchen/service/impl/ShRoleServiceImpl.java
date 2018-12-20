package cn.ylchen.service.impl;

import cn.ylchen.dao.roleDao;
import cn.ylchen.model.ShRole;
import cn.ylchen.service.ShRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ShRoleServiceImpl implements ShRoleService {

    @Resource
    private roleDao roleDao;

    @Override
    public ShRole get(String username) {
        return roleDao.get(username);
    }

    @Override
    public List<ShRole> getAll() {
        return roleDao.getAll();
    }

    @Override
    public List<ShRole> getPaged(Map<String, Object> params) {
        return roleDao.getPaged(params);
    }

    @Override
    public int getCount() {
        return roleDao.getCount();
    }

    @Override
    public int create(ShRole user) {
        return roleDao.create(user);
    }

    @Override
    public int delete(String username) {
        return roleDao.delete(username);
    }

    @Override
    public int update(ShRole user) {
        return roleDao.update(user);
    }
}
