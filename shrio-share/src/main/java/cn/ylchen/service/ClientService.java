package cn.ylchen.service;

import cn.ylchen.model.oauthClient;

public interface ClientService {
    /** 根据clientId查询Client信息 */
    public oauthClient findByClientId(String clientId);
    /** 根据clientSecret查询client信息 */
    public oauthClient findByClientSecret(String clientSecret);
}
