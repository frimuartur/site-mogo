package com.itproger.services;

import com.itproger.dto.UserDto;
import com.itproger.models.Role;
import com.itproger.models.User;
import com.itproger.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s);
    }

    public User saveUser (UserDto userDto){
        User user = new User();
        user.setEnabled(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setUsername(userDto.getUsername());
        user.setPassword(getPasswordHash(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
        return user;
    }

    public String getPasswordHash (String password){
        return new MessageDigestPasswordEncoder("MD5").encode(password);
    }
}
