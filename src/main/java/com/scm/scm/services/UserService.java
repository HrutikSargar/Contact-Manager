package com.scm.scm.services;

import java.util.*;

import com.scm.scm.Entities.User;

public interface UserService {

    User saveUser(User user);

    Optional<User> getUser(String userId);

    Optional<User> updateUser(User user);

    void deleteUser(String userId);

    boolean isUserExist(String userId);

    boolean isUserExistByEmail(String email);

    List<User> getAllUSers();

}
