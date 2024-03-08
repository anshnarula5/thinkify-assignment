package com.cabbooking.repository;

import com.cabbooking.model.User;

import java.util.List;

public interface UserRepository {
    void save(final User user);
    List<User> getAllUsers();

}
