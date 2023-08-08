package com.pradeeppadmakumar.fullstack.eventfeedbackservice.service;


import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.ApplicationUser;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Role;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("In the user details service");

        /*if(!username.equals("Pradeep")) throw  new UsernameNotFoundException("Not Pradeep");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1L, "USER"));


        return new ApplicationUser(1L, "Pradeep", encoder.encode("password"), roles);*/

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));

    }
}
