package cn.ylchen.service;

import cn.ylchen.model.ShPermission;

import java.util.List;
import java.util.Map;

public interface ShPermissionService {
    ShPermission get(String id);

    List<ShPermission> getAll();

    List<ShPermission> getPaged(Map<String, Object> params);

    int getCount();

    int create(ShPermission user);

    int delete(String username);

    int update(ShPermission user);

    List<String> selectPermissionByUserId(String userId);
}
