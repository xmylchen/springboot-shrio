package cn.ylchen.dao;

import cn.ylchen.model.ShUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface userDao {
    ShUser get(String username);

    List<ShUser> getAll();

    List<ShUser> getPaged(Map<String, Object> params);

    int getCount();

    int create(ShUser user);

    int delete(String username);

    int update(ShUser user);

}
