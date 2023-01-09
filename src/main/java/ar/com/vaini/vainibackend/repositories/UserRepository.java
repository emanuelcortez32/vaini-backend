package ar.com.vaini.vainibackend.repositories;

import ar.com.vaini.vainibackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IUserRepository extends MongoRepository<User, String> {

     User save(User user);
    Optional<User> findById(String userId);

    Boolean existsByUserName(String userName);
}
