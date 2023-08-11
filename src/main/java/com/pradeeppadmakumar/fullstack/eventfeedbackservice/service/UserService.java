package com.pradeeppadmakumar.fullstack.eventfeedbackservice.service;


import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.ApplicationUser;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.Role;
import com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));

    }
}
