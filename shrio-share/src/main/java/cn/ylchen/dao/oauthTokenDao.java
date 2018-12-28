package cn.ylchen.dao;

import cn.ylchen.model.oauthToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface oauthTokenDao {
    /** 添加accessToken */
    public void addAccessToken(oauthToken oauthToken);
    /** 检查 accessToken 是否可用 */
    public boolean checkAccessToken(String accessToken);
    /** 根据 accessToken 获取用户名 */
    public String getUsernameByAccessToken(String accessToken);
}
