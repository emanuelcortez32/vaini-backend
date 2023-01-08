package ar.com.vaini.vainibackend.repositories;

import ar.com.vaini.vainibackend.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    @Override
    public User save(User user) {
        return user;
    }

    @Override
    public Optional<User> findById(String userId) {
        return Optional.empty();
    }

    @Override
    public Boolean existsByUserName(String userName) {
        return false;
    }
}
