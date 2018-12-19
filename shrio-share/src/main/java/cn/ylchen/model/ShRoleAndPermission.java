package cn.ylchen.model;

public class ShRoleAndPermission {
    private int id;
    private String roleId;
    private String permissionId;

    public String getRoleId() {
        return roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }
    public ShRoleAndPermission(){
        super();
    }
    public ShRoleAndPermission(String roleId, String permissionId){
        super();
        this.roleId=roleId;
        this.permissionId=permissionId;
    }
}
