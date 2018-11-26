package com.pack.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pack.model.Employee;
import com.pack.model.Question;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveEmployee(Employee employee) {

		sessionFactory.getCurrentSession().save(employee);
	}

	@Override
	public List<Question> allQuestions() {
		@SuppressWarnings("unchecked")
		List<Question> list=sessionFactory.getCurrentSession().createQuery("from Question").list();
		return list;
	}

	@Override
	public Employee getEmployee(int empId) {
		
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empId);
	}

	@Override
	public void updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().delete(employee);
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List allEmployees() {
		
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getRightAnswerByQuestionId(int questionid) {
	
		return sessionFactory.getCurrentSession().createQuery("from Question where id=:id").setParameter("id", questionid).list();
	}

}
