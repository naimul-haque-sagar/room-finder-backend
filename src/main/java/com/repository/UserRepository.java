package com.repository;

import com.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByUserName(String userName);

    Optional<User> findByUserName(String userName);
}
