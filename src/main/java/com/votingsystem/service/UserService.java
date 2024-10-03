package com.votingsystem.service;



import com.votingsystem.model.User;
import com.votingsystem.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(false); // Initially inactive
        user.setRole("ROLE_USER"); // Default role as user
        userRepository.save(user);
    }

    public void activateUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setActive(true);
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
