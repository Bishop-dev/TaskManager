package com.hubachov.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;
	@Column(name = "user_login")
	private String login;
	@Column(name = "user_password")
	private String password;
	@Column(name = "user_firstname")
	private String firstName;
	@Column(name = "user_lastname")
	private String lastName;
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_registration")
	private Date registration;
	@Column(name = "user_birthday")
	private Date birthday;
	@Column(name = "user_lastlogin")
	private Date lastLogin;
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	public User() {
	}

	public User(UserBuilder builder) {
		this.id = builder.id;
		this.login = builder.login;
		this.password = builder.password;
		this.email = builder.email;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.registration = builder.registration;
		this.birthday = builder.birthday;
		this.lastLogin = builder.lastLogin;
		this.role = builder.role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistration() {
		return registration;
	}

	public void setRegistration(Date registration) {
		this.registration = registration;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", registration=" + registration +
				", role=" + role +
				'}';
	}

	public static class UserBuilder {
		private long id;
		private String login;
		private String password;
		private String firstName;
		private String lastName;
		private String email;
		private Date registration;
		private Date birthday;
		private Date lastLogin;
		private Role role;

		public UserBuilder id(long id) {
			this.id = id;
			return this;
		}

		public UserBuilder login(String login) {
			this.login = login;
			return this;
		}

		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}

		public UserBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder registration(Date registration) {
			this.registration = registration;
			return this;
		}

		public UserBuilder birthday(Date birthday) {
			this.birthday = birthday;
			return this;
		}

		public UserBuilder lastLogin(Date lastLogin) {
			this.lastLogin = lastLogin;
			return this;
		}

		public UserBuilder role(Role role) {
			this.role = role;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}
