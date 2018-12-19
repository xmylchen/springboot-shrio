package cn.ylchen.model;

public class ShUserAndRole {
    private int id;
    private String userId;
    private String roleId;

    public ShUserAndRole(String userId, String roleId){
        super();
        this.userId=userId;
        this.roleId=roleId;
    }
    public ShUserAndRole(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public String getRoleId() {
        return roleId;
    }
}
