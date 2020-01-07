package com.smart.springboot4.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name") String name, Model model, HttpSession session) {
        model.addAttribute("name", name);
        System.out.println("我已经来到greeting");
        return "hello";
    }

}
