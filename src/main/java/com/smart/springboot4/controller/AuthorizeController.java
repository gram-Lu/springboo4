package com.smart.springboot4.controller;

import com.alibaba.fastjson.JSON;
import com.smart.springboot4.dto.AccessTokenDTO;
import com.smart.springboot4.dto.GithubUser;
import com.smart.springboot4.mapper.UserMapper;
import com.smart.springboot4.model.User;
import com.smart.springboot4.provider.GithubProvider;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @Autowired
    private UserMapper userMapperImpl;
    @Value("${github.client.id}")
    private String clientId;
    @Value("github.redirect.uri")
    private String redirectUri;
    @Value("github.client.secret")
    private String clientSecret;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code, @RequestParam(name="state")String state, HttpServletRequest request)  {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if(githubUser != null){
            //登陆成功，写cookie和session
            request.getSession().setAttribute("githubUser",githubUser);
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName("小匠");
            user.setAccount_id("我的尝试");
            user.setGtmCreate(System.currentTimeMillis());
            user.setGtmModified(user.getGtmCreate());
            userMapperImpl.insert(user);
            System.out.println(githubUser);
            return "redirect:/";
        }else{
            //登陆失败，重新登陆
            return "redirect:/";
        }
    }
}
