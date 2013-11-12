package com.hubachov.dataaccess.dao;

import com.hubachov.entity.Role;
import com.hubachov.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserDAO {
	public User createUser(User user) throws Exception;

	public void updateUser(User user) throws Exception;

	public void deleteUser(User user) throws Exception;

	public Set<User> getAllUsers() throws Exception;

	public Set<User> getUsersByRole(Role role) throws Exception;

	public void getUserById(int id) throws Exception;

	public boolean checkLogin(String login) throws Exception;
}
