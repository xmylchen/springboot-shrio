package cn.ylchen.service.impl;

import cn.ylchen.dao.permissionDao;
import cn.ylchen.model.ShPermission;
import cn.ylchen.service.ShPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service(value = "ShPermissionService")
public class ShPermissionServiceImpl implements ShPermissionService {

    @Resource
    private permissionDao permissionDao;


    @Override
    public ShPermission get(String id) {
        return permissionDao.get(id);
    }

    @Override
    public List<ShPermission> getAll() {
        return permissionDao.getAll();
    }

    @Override
    public List<ShPermission> getPaged(Map<String, Object> params) {
        return getPaged(params);
    }

    @Override
    public int getCount() {
        return permissionDao.getCount();
    }

    @Override
    public int create(ShPermission user) {
        return permissionDao.create(user);
    }

    @Override
    public int delete(String username) {
        return permissionDao.delete(username);
    }

    @Override
    public int update(ShPermission user) {
        return permissionDao.update(user);
    }

    @Override
    public List<ShPermission> selectPermissionByUserId(String userId) {
        return permissionDao.selectPermissionByUserId(userId);
    }
}
