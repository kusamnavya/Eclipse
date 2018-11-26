package com.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.EmployeeDao;
import com.pack.model.Employee;
import com.pack.model.Question;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	 @Autowired
	 EmployeeDao employeeDao;
	@Override
	public void addEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> allQuestions() {
		@SuppressWarnings("rawtypes")
		List list=employeeDao.allQuestions();
		return list;
	}
	@Override
	public Employee getEmployee(int empId) {
		
		return employeeDao.getEmployee(empId);
	}
	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
		
	}
	@Override
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List allEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getRightAnswerByQuestionId(int questionid) {
		@SuppressWarnings("rawtypes")
		List list= employeeDao.getRightAnswerByQuestionId(questionid);
		return list;
	}

}
