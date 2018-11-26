<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESULT PAGE</title>
</head>
<body>
	<a href="pdf">view result in pdf</a>
	<center>
		<h1>RESULT</h1>
	</center>
	<div class=jumbotron>
		<center>
			<h4>
				<span class="alert alert-info">TOTAL NUMBER OF QUESTIONS ARE
					: <core:out value="${totalQuestions}"></core:out>
				</span>
			</h4>
			<br>
			<br>
			<h4>
				<span class="alert alert-success">CORRECT QUESTIONS ARE :<core:out
						value="${rightAnswer}"></core:out></span>
			</h4>
			<br>
			<br>
			<h4>
				<span class="alert alert-danger">WRONG QUESTION ARE:<core:out
						value="${wrongAnswer}"></core:out></span>
			</h4>
		</center>
	</div>
</body>
</html>