package com.pradeeppadmakumar.fullstack.eventfeedbackservice.service;

import com.pradeeppadmakumar.fullstack.eventfeedbackservice.dto.LoginResponseDTO;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.ApplicationUser;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Role;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.RoleRepository;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.UserRepository;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ApplicationUser registerUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);

        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        return userRepository.save(new ApplicationUser(0L, username, encodedPassword, roles));

    }

    public LoginResponseDTO loginUser(String username, String password) {

        try{
            System.out.println("before auth call + " + username);
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            System.out.println("after auth call");

            String token = tokenService.generateJwt(auth);
            System.out.println("after getting token");

            return new LoginResponseDTO(userRepository.findByUsername(username).get(), token);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new LoginResponseDTO(null, "");
        }
    }

}
