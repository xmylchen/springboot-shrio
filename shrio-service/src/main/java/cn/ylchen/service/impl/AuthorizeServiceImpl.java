package cn.ylchen.service.impl;

import cn.ylchen.dao.oauthCodeDao;
import cn.ylchen.dao.oauthTokenDao;
import cn.ylchen.model.oauthCode;
import cn.ylchen.model.oauthToken;
import cn.ylchen.service.AuthorizeService;
import cn.ylchen.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthorizeServiceImpl implements AuthorizeService {
    private Cache cache;

    @Resource
    private ClientService clientService;
    @Resource
    private oauthCodeDao oauthCodeDao;
    @Resource
    private oauthTokenDao oauthTokenDao;


    @Override
    public void addAuthCode(String authCode, String username) {
        oauthCode oauthCode = new oauthCode();
        oauthCode.setCode(authCode);
        oauthCode.setUsername(username);
        oauthCodeDao.addAuthCode(oauthCode);
    }

    @Override
    public void addAccessToken(String accessToken, String username) {
        oauthToken oauthToken = new oauthToken();
        oauthToken.setToken(accessToken);
        oauthToken.setUsername(username);
        oauthTokenDao.addAccessToken(oauthToken);
    }

    @Override
    public String getUsernameByAuthCode(String authCode) {
        return oauthCodeDao.getUsernameByAuthCode(authCode);
    }

    @Override
    public String getUsernameByAccessToken(String accessToken) {
       return oauthTokenDao.getUsernameByAccessToken(accessToken);
    }

    @Override
    public boolean checkAuthCode(String authCode) {
       return oauthCodeDao.checkAuthCode(authCode);
    }

    @Override
    public boolean checkAccessToken(String accessToken) {
        return oauthTokenDao.checkAccessToken(accessToken);
    }

    @Override
    public boolean checkClientId(String clientId) {
        return clientService.findByClientId(clientId) != null;
    }

    @Override
    public boolean checkClientSecret(String clientSecret) {
        return clientService.findByClientSecret(clientSecret) != null;
    }

    @Override
    public long getExpireIn() {
        return 3600L;
    }
}
