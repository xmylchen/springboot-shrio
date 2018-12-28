package cn.ylchen.shiro.client;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/oauth-client",method = RequestMethod.POST)
public class AccessTokenController {

    @Value("${shiro.client.clientId}")
    private String clientId;

    @Value("${shiro.client.clientSecret}")
    private String clientSecret;

    @Value("${shiro.client.accessTokenUrl}")
    private String accessTokenUrl;

    @Value("${shiro.client.redirectUrl}")
    private String redirectUrl;

    @Value("${shiro.client.responseType}")
    private String response_type;

    //接受客户端返回的code，提交申请access token的请求
    @RequestMapping("/callbackCode")
    public Object toLogin(HttpServletRequest request)throws OAuthProblemException {

        String  code = request.getParameter("code");

        System.out.println("==> 服务端回调，获取的code："+code);

        OAuthClient oAuthClient =new OAuthClient(new URLConnectionClient());

        try {

            OAuthClientRequest accessTokenRequest = OAuthClientRequest
                    .tokenLocation(accessTokenUrl)
                    .setGrantType(GrantType.AUTHORIZATION_CODE)
                    .setClientId(clientId)
                    .setClientSecret(clientSecret)
                    .setCode(code)
                    .setRedirectURI(redirectUrl)
                    .buildQueryMessage();
            System.out.println(accessTokenRequest.getBody());
            //去服务端请求access token，并返回响应
            OAuthAccessTokenResponse oAuthResponse =oAuthClient.accessToken(accessTokenRequest, OAuth.HttpMethod.POST);

            //获取服务端返回过来的access token
            String accessToken = oAuthResponse.getAccessToken();
            //查看access token是否过期
            Long expiresIn =oAuthResponse.getExpiresIn();
            System.out.println("==> 客户端根据 code值 "+code +" 到服务端获取的access_token为："+accessToken+" 过期时间为："+expiresIn);

            System.out.println("==> 拿到access_token然后重定向到 客户端 /oauth-client/getUserInfo服务,传过去accessToken");

            return"redirect:/oauth-client/getUserInfo?accessToken="+accessToken;

        } catch (OAuthSystemException e) {
            e.printStackTrace();
        }
        return null;
    }

}
