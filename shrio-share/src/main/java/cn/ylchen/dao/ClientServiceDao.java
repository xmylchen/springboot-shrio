package cn.ylchen.dao;

import cn.ylchen.model.oauthClient;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientServiceDao {
    public oauthClient findByClientId(String clientId);
    /** 根据clientSecret查询client信息 */
    public oauthClient findByClientSecret(String clientSecret);
}
