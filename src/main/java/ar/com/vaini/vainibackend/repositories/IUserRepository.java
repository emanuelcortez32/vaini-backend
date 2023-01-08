package ar.com.vaini.vainibackend.repositories;

import ar.com.vaini.vainibackend.model.User;

import java.util.Optional;

public interface IUserRepository {

     User save(User user);
    Optional<User> findById(String userId);

    Boolean existsByUserName(String userName);
}
