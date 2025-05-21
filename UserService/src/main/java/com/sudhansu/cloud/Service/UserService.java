package com.sudhansu.cloud.Service;

import java.util.List;

import com.sudhansu.cloud.Entity.User;

public interface UserService {

	List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
	
}
