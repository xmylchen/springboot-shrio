package cn.ylchen.service;

import cn.ylchen.model.ShRole;

import java.util.List;
import java.util.Map;

public interface ShRoleService {
    ShRole get(String username);

    List<ShRole> getAll();

    List<ShRole> getPaged(Map<String, Object> params);

    int getCount();

    int create(ShRole user);

    int delete(String username);

    int update(ShRole user);
}
