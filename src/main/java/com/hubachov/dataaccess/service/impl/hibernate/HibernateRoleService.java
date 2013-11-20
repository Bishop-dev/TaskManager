package com.hubachov.dataaccess.service.impl.hibernate;

import com.hubachov.dataaccess.dao.RoleDAO;
import com.hubachov.dataaccess.service.RoleService;
import com.hubachov.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HibernateRoleService implements RoleService {
	@Autowired
	private RoleDAO roleDAO;

	@Override
	public Role getRoleByName(String name) throws Exception {
		return roleDAO.getRoleByName(name);
	}
}
