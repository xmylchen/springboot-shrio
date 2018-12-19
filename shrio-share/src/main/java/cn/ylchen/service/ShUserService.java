package cn.ylchen.service;

import cn.ylchen.model.ShUser;

import java.util.List;
import java.util.Map;

public interface ShUserService {
    ShUser get(String username);

    List<ShUser> getAll();

    List<ShUser> getPaged(Map<String, Object> params);

    int getCount();

    int create(ShUser user);

    int delete(String username);

    int update(ShUser user);
}
