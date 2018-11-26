<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%><%@ taglib
	prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>QUIZ APPLICATION</h1>
	</center>
	<div class="jumbotron"
		style="background-color: lavender; border-collapse: collapse">

		<form:form action="showResult" method="post">
			<table id="table" style="text-align: center;">
				<core:forEach var="questionPaper" items="${QuestionList}" begin='3'
					end='5'>
					<br />
					<br />
					<input type="hidden" value="${questionPaper.id}" name="quesnum">
					<pre>
						<core:out value="${questionPaper.id}"></core:out>&nbsp;&nbsp;&nbsp;&nbsp;<core:out
							value="${questionPaper.question_text}"></core:out>
					</pre>
    
       &nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" id="option1"
						name="option${questionPaper.id}" value="${questionPaper.option1}">
					<core:out value="${questionPaper.option1}"></core:out>
					<br />
     
         &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id="option2"
						name="option${questionPaper.id}" value="${questionPaper.option2}">
					<core:out value="${questionPaper.option2}"></core:out>
					<br />
      
        &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id="option3"
						name="option${questionPaper.id}" value="${questionPaper.option3}">
					<core:out value="${questionPaper.option3}"></core:out>
					<br />
       
        &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id="option4"
						name="option${questionPaper.id}" value="${questionPaper.option4}">
					<core:out value="${questionPaper.option4}"></core:out>
					<br />
				</core:forEach>
				<center>
					<input type="submit" class="btn btn-success"
						value="FINISH ATEMPT...">
				</center>
			</table>
		</form:form>
	</div>
</body>
</html>