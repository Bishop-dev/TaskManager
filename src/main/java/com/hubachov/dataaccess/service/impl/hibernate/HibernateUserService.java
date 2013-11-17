package com.hubachov.dataaccess.service.impl.hibernate;

import com.hubachov.dataaccess.dao.UserDAO;
import com.hubachov.dataaccess.service.UserService;
import com.hubachov.entity.Role;
import com.hubachov.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class HibernateUserService implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public User getUserByLogin(String login) throws Exception {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public User createUser(User user) throws Exception {
		return userDAO.createUser(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void deleteUser(User user) throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Set<User> getAllUsers() throws Exception {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Set<User> getUsersByRole(Role role) throws Exception {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void getUserById(int id) throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean checkLogin(String login) throws Exception {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
