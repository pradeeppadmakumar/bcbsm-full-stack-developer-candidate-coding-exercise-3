package com.pradeeppadmakumar.fullstack.eventfeedbackservice.service;

import com.pradeeppadmakumar.fullstack.eventfeedbackservice.dto.LoginResponseDTO;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.ApplicationUser;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Role;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.RoleRepository;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@AllArgsConstructor
@Slf4j
public class AuthenticationService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public ApplicationUser registerUser(String username, String password, String name, String email) {
        log.info("Creating user with username: {}", username);
        String encodedPassword = passwordEncoder.encode(password);

        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        try{
            return userRepository.save(new ApplicationUser(0L, username, encodedPassword, name, email, roles));
        }
        catch(Exception e) {
            log.info("Error while user with username: {}", username);
            throw new RuntimeException("Unable to register!!! try with a different username");
        }
    }

    public LoginResponseDTO loginUser(String username, String password) {
        log.info("validating credentials for username: {}", username);
        try{
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            String token = tokenService.generateJwt(auth);

            return new LoginResponseDTO(userRepository.findByUsername(username).get(), token);
        }
        catch (Exception e) {
            log.info("unable to validate username: {}", username);
            return new LoginResponseDTO(null, "");
        }
    }

}
