package com.mock.flight.repository;

import com.mock.flight.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String userName);

    Boolean existsByUserName (String userName);
}
