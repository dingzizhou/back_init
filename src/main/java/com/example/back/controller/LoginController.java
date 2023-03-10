package com.example.back.controller;

import com.example.back.model.dto.CurrentUser;
import com.example.back.model.dto.front2backDTO.LoginFormDTO;
import com.example.back.service.UserService;
import com.example.back.util.ResultUtil;
import com.example.back.util.ThreadLocalUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultUtil login(@Valid LoginFormDTO loginFormDTO){
        return userService.login(loginFormDTO);
    }

    @GetMapping("/test")
    public String test(){
        CurrentUser currentUser = new ObjectMapper().convertValue(ThreadLocalUtil.get("currentUser"), CurrentUser.class);
        return currentUser.toString();
    }

}
