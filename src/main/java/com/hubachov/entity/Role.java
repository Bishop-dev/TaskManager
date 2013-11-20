package com.hubachov.entity;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false, unique = true, updatable = false)
	private long id;
	@Column(name = "role_name", nullable = false, unique = true)
	private String name;

	public Role() {
	}

	public Role(RoleBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

	public static class RoleBuilder {
		private long id;
		private String name;

		public RoleBuilder id(long id) {
			this.id = id;
			return this;
		}

		public RoleBuilder name(String name) {
			this.name = name;
			return this;
		}

		public Role build() {
			return new Role(this);
		}
	}
}
