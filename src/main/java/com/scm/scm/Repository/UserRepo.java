package com.scm.scm.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.scm.Entities.User;

public interface UserRepo extends JpaRepository<User, String> {

    // extra method for db operations
    // custom query methods
    // custom finder method

    // this method is called as custom finder method
    Optional<User> findByEmail(String email);

}
