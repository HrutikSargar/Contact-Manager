package com.scm.scm.Implementation;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.scm.Entities.User;
import com.scm.scm.Repository.UserRepo;
import com.scm.scm.services.UserService;

import com.scm.scm.Helper.*;
import java.util.*;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepo userRepo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        // user id : have to generate
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);

        // calling jpa method
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUser(String userId) {
        return userRepo.findById(userId);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user2 = userRepo.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException());
        // update user2 from user
        user2.setEmail(user.getEmail());
        user2.setName(user.getName());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVarified(user.isEmailVarified());
        user2.setPhoneVarified(user.isPhoneVarified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());
        user2.setContacts(user.getContacts());

        // calling jpa method
        User user3 = userRepo.save(user2);

        // return updated user
        return Optional.ofNullable(user3);

    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException());
        userRepo.delete(user);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user = userRepo.findById(userId).orElse(null);
        return user != null ? true : false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user = userRepo.findByEmail(email).orElse(null);
        return user != null ? true : false;
    }

    @Override
    public List<User> getAllUSers() {
        List<User> list = userRepo.findAll();
        return list;
    }

}
