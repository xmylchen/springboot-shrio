package cn.ylchen.dao;

import cn.ylchen.model.oauthCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface oauthCodeDao {
    /** 添加 auth code */
    public void addAuthCode(oauthCode oauthCode);
    /** 检查authCode是否可用 */
    public boolean checkAuthCode(String authCode);
    /** 根据 authCode 获取用户名 */
    public String getUsernameByAuthCode(String authCode);

}
