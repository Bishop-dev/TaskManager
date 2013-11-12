package com.hubachov.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id", nullable = false, unique = true, updatable = false)
	private int id;
	@Column(name = "task_title", nullable = false, length = 100)
	private String title;
	@Column(name = "task_text", nullable = false)
	private String text;
	@Column(name = "task_created", nullable = false)
	private Date created;
	@Column(name = "task_deadline", nullable = false)
	private Date deadline;
	@Column(name = "task_resolved")
	private Date resolved;
	@Column(name = "task_estimated")
	private Date estimated;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Tasks_Experts", joinColumns = {
			@JoinColumn(name = "task_id", nullable = false, updatable = true)
	}, inverseJoinColumns = {@JoinColumn(name = "expert_id", nullable = false, updatable = true)})
	private Set<User> experts;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Tasks_Students", joinColumns = {
			@JoinColumn(name = "task_id", nullable = false, updatable = true)},
			inverseJoinColumns = {@JoinColumn(name = "strudent_id", nullable = false, updatable = true)})
	private Set<User> students;
	@Column(name = "task_expert", unique = false, updatable = true, nullable = false)
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER, mappedBy = "User", cascade = CascadeType.ALL)
	private User currentExpert;
	@Column(name = "task_student", unique = false, updatable = true, nullable = false)
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER, mappedBy = "User", cascade = CascadeType.ALL)
	private User currentStudent;

	public Task() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getResolved() {
		return resolved;
	}

	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}

	public Date getEstimated() {
		return estimated;
	}

	public void setEstimated(Date estimated) {
		this.estimated = estimated;
	}

	public Set<User> getExperts() {
		return experts;
	}

	public void setExperts(Set<User> experts) {
		this.experts = experts;
	}

	public Set<User> getStudents() {
		return students;
	}

	public void setStudents(Set<User> students) {
		this.students = students;
	}

	public User getCurrentExpert() {
		return currentExpert;
	}

	public void setCurrentExpert(User currentExpert) {
		this.currentExpert = currentExpert;
	}

	public User getCurrentStudent() {
		return currentStudent;
	}

	public void setCurrentStudent(User currentStudent) {
		this.currentStudent = currentStudent;
	}

	@Override
	public String toString() {
		return "Task{" +
				"id=" + id +
				", title='" + title + '\'' +
				", text='" + text + '\'' +
				", created=" + created +
				", deadline=" + deadline +
				", resolved=" + resolved +
				", estimated=" + estimated +
				", expert=" + experts +
				", students=" + students +
				'}';
	}
}
