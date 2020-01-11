package com.smart.springboot4.controller;

import com.smart.springboot4.mapper.UserMapper;
import com.smart.springboot4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapperImpl;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapperImpl.findToken(token);
                if(user != null){
                    request.getSession().setAttribute("githubUser",user);
                }
                break;
            }
        }
        return "index";
    }

}
