package cn.ylchen.service;

public interface AuthorizeService {
    /** 根据客户端id 查询客户端是否存在 */
    public boolean checkClientId(String clientId);
    /** 添加 auth code */
    public void addAuthCode(String authCode, String username);
    /** 检查客户端安全Key是否正确 */
    public boolean checkClientSecret(String clientSecret);
    /** 检查authCode是否可用 */
    public boolean checkAuthCode(String authCode);
    /** 根据 authCode 获取用户名 */
    public String getUsernameByAuthCode(String authCode);
    /** 添加accessToken */
    public void addAccessToken(String accessToken, String username);
    /** access token 过期时间 */
    public long getExpireIn();
    /** 检查 accessToken 是否可用 */
    public boolean checkAccessToken(String accessToken);
    /** 根据 accessToken 获取用户名 */
    public String getUsernameByAccessToken(String accessToken);
}
