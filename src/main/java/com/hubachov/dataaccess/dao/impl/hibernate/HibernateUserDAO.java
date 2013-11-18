package com.hubachov.dataaccess.dao.impl.hibernate;

import com.hubachov.dataaccess.dao.UserDAO;
import com.hubachov.entity.Role;
import com.hubachov.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class HibernateUserDAO implements UserDAO {
	private static final Logger LOG = Logger.getLogger(HibernateUserDAO.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUserByLogin(String login) throws Exception {
		if (login == null) {
			LOG.error("Trying to get user by NULL login");
			throw new NullPointerException();
		}
		List<User> users = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			users = session.createCriteria(User.class).add(Restrictions.eq("login", login)).list();
		} catch (Exception e) {
			LOG.error("Can't find user " + login, e);
			throw new SQLException(e);
		}
		return users.isEmpty() ? null : users.get(0);
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
