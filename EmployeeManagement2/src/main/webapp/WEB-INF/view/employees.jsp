<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add an Employee
</h1>

<c:url var="addAction" value="/employees/employee/add" ></c:url>

<form:form action="${addAction}" modelAttribute="employeex">
<table>
	<c:if test="${!empty employeex.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="EMail"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="department">
				<spring:message text="Department"/>
			</form:label>
		</td>
		<td>
			<form:input path="department" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="salary">
				<spring:message text="Salary"/>
			</form:label>
		</td>
		<td>
			<form:input path="salary" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty employeex.name}">
				<input type="submit"
					value="<spring:message text="Edit Employee"/>" />
			</c:if>
			<c:if test="${empty employeex.name}">
				<input type="submit"
					value="<spring:message text="Add Employee"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Employees List</h3>
<!--<c:if test="${!empty listemployees}">-->
	<table class="tg">
	<tr>
		<th width="80">Employee ID</th>
		<th width="120">Employee Name</th>
		<th width="120">Employee Department</th>
		<th width="120">Employee eMail</th>
		<th width="120">Employee Salary</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listemployees}" var="employee">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.name}</td>
			<td>${employee.department}</td>
			<td>${employee.email}</td>
			<td>${employee.salary}</td>
			<td><a href="<c:url value='/employees/edit/${employee.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/employees/remove/${employee.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
<!--</c:if>-->
</body>
</html>
