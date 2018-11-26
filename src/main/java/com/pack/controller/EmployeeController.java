package com.pack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pack.model.Employee;
import com.pack.model.Question;
import com.pack.service.EmployeeService;
import com.pack.validator.EmployeeValidator;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EmployeeValidator validator;

	@RequestMapping(value = "Login")
	public ModelAndView LoginEmployee(@ModelAttribute("employee") Employee employee) throws IOException {

		return new ModelAndView("EmployeeForm");
	}

	@RequestMapping(value = "showResult")
	public ModelAndView showResult(HttpServletRequest request, HttpSession session) {
		List<Question> QuestionList = employeeService.allQuestions();
		int size = QuestionList.size();
		int rightAnswer = (int) session.getAttribute("rightAnswer");
		System.out.println(rightAnswer);
		

		for (int i = size / 2; i <= size; i++) {
			String selectedOption = request.getParameter("option" + i);
			System.out.println("SELECTED OPTION IS:" + selectedOption);
			List<Question> list = employeeService.getRightAnswerByQuestionId(i);
			if (list.get(0).getRight_answer().equals(selectedOption)) {
				rightAnswer++;
			}
			

		}
		session.setAttribute("totalQuestions", size);
		session.setAttribute("rightAnswer", rightAnswer);
		System.out.println(rightAnswer);
		session.setAttribute("wrongAnswer", (size) - rightAnswer);
		return new ModelAndView("result");

	}

	@RequestMapping(value = "showRest")
	public ModelAndView resultpage(HttpServletRequest request, HttpSession session) {
		List<Question> QuestionList = employeeService.allQuestions();
		int size = QuestionList.size();
		/*
		 * int firstPage = (int) session.getAttribute("rightAnswer");
		 * System.out.println(firstPage);
		 */
		int questionid = Integer.parseInt(request.getParameter("quesnum"));

		int rightAnswer = 0;
		for (int i = questionid ; i <= size/2; i++) {
			String selectedOption = request.getParameter("option" + i);
			System.out.println("SELECTED OPTION IS:" + selectedOption);
			List<Question> list = employeeService.getRightAnswerByQuestionId(i);
			if (list.get(0).getRight_answer().equals(selectedOption)) {
				rightAnswer++;
			}
			
		}
		session.setAttribute("rightAnswer", rightAnswer);
		System.out.println(rightAnswer);
		return new ModelAndView("ResultPage2", "QuestionList", QuestionList);

	}

	@RequestMapping(value = "pdf")
	public ModelAndView pdfDocument(HttpServletRequest request, HttpSession session, Model model) throws IOException {

		List<Question> QuestionList = employeeService.allQuestions();

		return new ModelAndView("UserSummary", "QuestionList", QuestionList);
	}

	@RequestMapping(value = "saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingresult)
			throws IOException {
		validator.validate(employee,bindingresult);
		if (bindingresult.hasErrors()) {
			return new ModelAndView("EmployeeForm");
		} else {
			List<Question> QuestionList = employeeService.allQuestions();

			return new ModelAndView("success", "QuestionList", QuestionList);
		}

	}
}
