package com.hubachov.dataaccess.dao;

import com.hubachov.entity.Role;

import java.util.Set;

public interface RoleDAO {
	public Role createRole(Role role) throws Exception;

	public void deleteRole(Role role) throws Exception;

	public void updateRole(Role role) throws Exception;

	public Set<Role> getAllRoles() throws Exception;

	public Role getRoleByName(String name) throws Exception;
}
