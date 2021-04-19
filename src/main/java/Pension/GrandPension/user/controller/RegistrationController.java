package Pension.GrandPension.user.controller;

import Pension.GrandPension.user.dto.RegistrationForm;
import Pension.GrandPension.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping
    public String registerForm(){
        return "auth/registration";
    }


    @PostMapping
    public String register(RegistrationForm form){
        userMapper.registerUser(form.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
