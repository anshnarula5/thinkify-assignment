package com.cabbooking.repository;

import com.cabbooking.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final List<User> users = new ArrayList<>();
    @Override
    public void save(final User user) {
        users.add(user);
    }
    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
