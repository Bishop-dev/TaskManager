package com.hubachov.dataaccess.dao;

import com.hubachov.entity.Task;

import java.util.Set;

public interface TaskDAO {
	public Task createTask(Task task) throws Exception;

	public void deleteTask(Task task) throws Exception;

	public void updateTask(Task task) throws Exception;

	public Set<Task> getAllTasks() throws Exception;

	public Set<Task> getTasksByStudent(int studentId) throws Exception;

	public Set<Task> getTasksByExpert(int expertId) throws Exception;

	public void lockTask(int expertId) throws Exception;

	public void solveTask(Task task) throws Exception;
}
