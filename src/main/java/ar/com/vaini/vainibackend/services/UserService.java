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
public class UserService implements IUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserById(String userId) {
        return userRepository.findById(userId);
    }

    public User registerUser(User user, Set<Role> roles) {

        if (userRepository.existsByUserName(user.getUsername())) return null;

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roles);
        return user;
    }
}
