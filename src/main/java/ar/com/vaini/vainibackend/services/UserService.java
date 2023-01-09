package ar.com.vaini.vainibackend.services;

import ar.com.vaini.vainibackend.model.Role;
import ar.com.vaini.vainibackend.model.User;

import java.util.Set;

public interface IUserService {
    User registerUser(User user, Set<Role> roles);
}
