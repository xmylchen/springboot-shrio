package cn.ylchen.service.impl;

import cn.ylchen.dao.ClientServiceDao;
import cn.ylchen.model.oauthClient;
import cn.ylchen.service.ClientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClientServiceImpl implements ClientService {
    @Resource
    private ClientServiceDao clientServiceDao;

    @Override
    public oauthClient findByClientId(String clientId) {
        return clientServiceDao.findByClientId(clientId);
    }

    @Override
    public oauthClient findByClientSecret(String clientSecret) {
        return clientServiceDao.findByClientSecret(clientSecret);
    }
}
