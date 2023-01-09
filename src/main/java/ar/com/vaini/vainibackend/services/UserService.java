package ar.com.vaini.vainibackend.services;

import ar.com.vaini.vainibackend.model.Role;
import ar.com.vaini.vainibackend.model.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    User registerUser(User user, Set<String> roles);
    Optional<User> findByUserName(String username);
}
