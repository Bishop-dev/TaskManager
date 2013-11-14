package com.hubachov.dataaccess.dao.impl.hibernate;

import com.hubachov.dataaccess.dao.UserDAO;
import com.hubachov.entity.Role;
import com.hubachov.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class HibernateUserDAO implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUserByLogin(String login) throws Exception {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public User createUser(User user) throws Exception {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
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
