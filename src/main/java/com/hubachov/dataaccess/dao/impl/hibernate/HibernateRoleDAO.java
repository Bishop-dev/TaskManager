package com.hubachov.dataaccess.dao.impl.hibernate;

import com.hubachov.dataaccess.dao.RoleDAO;
import com.hubachov.entity.Role;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class HibernateRoleDAO implements RoleDAO {
	private static final Logger LOG = Logger.getLogger(HibernateRoleDAO.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role createRole(Role role) throws Exception {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void deleteRole(Role role) throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void updateRole(Role role) throws Exception {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Set<Role> getAllRoles() throws Exception {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Role getRoleByName(String name) throws Exception {
		if (name == null) {
			LOG.error("Trying to get role by NULL name");
			throw new NullPointerException();
		}
		List<Role> roles = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			roles = session.createCriteria(Role.class).add(Restrictions.eq("name", name)).list();
		} catch (Exception e) {
			LOG.error("Can't get role " + name, e);
			throw new SQLException(e);
		}
		return roles.isEmpty() ? null : roles.get(0);
	}
}
