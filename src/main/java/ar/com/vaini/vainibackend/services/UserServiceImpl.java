package ar.com.vaini.vainibackend.services;

import ar.com.vaini.vainibackend.model.Role;
import ar.com.vaini.vainibackend.model.User;
import ar.com.vaini.vainibackend.repositories.UserRepository;
import ar.com.vaini.vainibackend.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserById(String userId) {
        return userRepository.findById(userId);
    }

    public User registerUser(User user, Set<String> roles) {
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
