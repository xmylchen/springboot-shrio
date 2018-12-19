package cn.ylchen.dao;

import cn.ylchen.model.ShPermission;

import java.util.List;
import java.util.Map;

public interface permissionDao {

    ShPermission get(String id);

    List<ShPermission> getAll();

    List<ShPermission> getPaged(Map<String, Object> params);

    int getCount();

    int create(ShPermission user);

    int delete(String id);

    int update(ShPermission user);
}
