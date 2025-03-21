package com.mytests.spring.springsecurityconstants;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
class TestController {

    @RequestMapping("/test0")
    public String test0(ModelMap model) {
        model.addAttribute("test0_attr1", "test0_attr1");
        return "test0";
    }
    @RequestMapping("/test1")
    public String test1(ModelMap model) {
        model.addAttribute("test1_attr1", "test1_attr1");
        return "test1";
    }

    @RequestMapping("/test2")
    public String test2(ModelMap model) {
        model.addAttribute("test2_attr1", "test2_attr1");
        return "test2";
    }

    @RequestMapping("/test3")
    public String test3(ModelMap model) {
        model.addAttribute("test3_attr1", "test3_attr1");
        return "test3";
    }

    @RequestMapping("/test4")
    public String test4(ModelMap model) {
        model.addAttribute("test4_attr1", "test4_attr1");
        return "test4";
    }

    @RequestMapping("/test5")
    public String test5(ModelMap model) {
        model.addAttribute("test5_attr1", "test5_attr1");
        return "test5";
    }

}
