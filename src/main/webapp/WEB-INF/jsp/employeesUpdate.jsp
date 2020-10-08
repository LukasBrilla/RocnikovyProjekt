<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<mt:template title="BeachclubApp">
    <jsp:attribute name="content">
<br>
	<h1>Update Employee</h1>
	
	
	
<form action="${pageContext.request.contextPath}/employees/update/${employee.getId()}" method="post">
<<<<<<< HEAD
<span class="label label-default">Name:</span>
<input type=text name="name" value="${employee.getName()}" class="form-control"><br>
<span class="label label-default">Role:</span>
<input type=text name="role" value="${employee.getRole().getName()}" class="form-control"><br>
<input type=submit class="btn btn-sm btn-success" value="Update">
=======
    <span class="label label-default">Name:</span>
    <input type=text name="name" value="${employee.getName()}" class="form-control"><br>
    <span class="label label-default">Role:</span>
    <input type=text name="role" value="${employee.getRole().getName()}" class="form-control"><br>
    <input type=submit class="btn btn-sm btn-success">
>>>>>>> c575fde0b83483251280b1d7e3d5ec3892abab2e
</form>

    </jsp:attribute>
</mt:template>
