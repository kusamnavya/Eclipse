package com.pack.dao;

import java.util.List;

import com.pack.model.Employee;

public interface EmployeeDao {
 @SuppressWarnings("rawtypes")
public List allEmployees();
 public Employee getEmployee(int empId);
	public void saveEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	@SuppressWarnings("rawtypes")
	public List allQuestions();
	@SuppressWarnings("rawtypes")
	public List getRightAnswerByQuestionId(int questionid);
}
