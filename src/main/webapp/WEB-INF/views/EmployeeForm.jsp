
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QUIZ PAGE</title>
</head>
<body>
	<div align="center">
		<h1>LOGIN PAGE</h1>
		<div class="jumbotron">
			<form:form action="saveEmployee" method="post"
				modelAttribute="employee">

				<table style="border-collapse: separate; border-spacing: 0 1em;">
					<form:hidden path="id" />
					<tr>
						<td>Name:</td>
						<td><form:input path="name" />
							<form:errors path="name"></form:errors></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><form:input path="password" />
							<form:errors path="password"></form:errors></td>
					</tr>


					<tr>
						<td colspan="2" align="center"><input type="submit"
							class="btn btn-success" value="Save"></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>