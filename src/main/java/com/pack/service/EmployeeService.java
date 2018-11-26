package com.pack.service;

import java.util.List;

import com.pack.model.Employee;
import com.pack.model.Question;

public interface EmployeeService {
	@SuppressWarnings("rawtypes")
	public List allEmployees();
	public Employee getEmployee(int empId);
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	List<Question> allQuestions();
	public List<Question> getRightAnswerByQuestionId(int questionid);
}
