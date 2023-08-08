package com.pradeeppadmakumar.fullstack.eventfeedbackservice.controller;

import com.pradeeppadmakumar.fullstack.eventfeedbackservice.dto.LoginResponseDTO;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.dto.RegistrationDTO;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.ApplicationUser;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body) {
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody RegistrationDTO body) {
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}
