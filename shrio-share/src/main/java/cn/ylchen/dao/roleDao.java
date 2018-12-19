package cn.ylchen.dao;

import cn.ylchen.model.ShRole;
import cn.ylchen.model.ShRoleAndPermission;
import cn.ylchen.model.ShUser;
import cn.ylchen.model.ShUserAndRole;

import java.util.List;
import java.util.Map;

public interface roleDao {
    ShRole get(String id);

    List<ShRole> getAll();

    List<ShRole> getPaged(Map<String, Object> params);

    int getCount();

    int create(ShRole user);

    int delete(String id);

    int update(ShRole user);

    int createUserAndRole(ShUserAndRole userAndRole);

    int deleteUserAndRole(String id);

    int updateUserAndRole(ShUserAndRole userAndRole);

    ShUserAndRole getUserAndRole(String id);

    List<ShUserAndRole> getUserAndRoleByRoleId(String roleId);

    List<ShUserAndRole> getUserAndRoleByUserId(String userId);

    int createRoleAndPermission(ShRoleAndPermission roleAndPermission);

    int deleteRoleAndPermission(String id);

    int updateRoleAndPermission(ShRoleAndPermission roleAndPermission);

    ShRoleAndPermission getRoleAndPerimission(String id);

    List<ShRoleAndPermission> getRoleAndPerimissionByRoleId(String roleId);

    List<ShRoleAndPermission> getRoleAndPerimissionByPermissionId(String permissionId);
}
