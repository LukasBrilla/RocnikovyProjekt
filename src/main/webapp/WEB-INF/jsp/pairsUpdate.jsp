<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<mt:template title="BeachclubApp">
    <jsp:attribute name="content">
<br>
	<h1>Update Beach Pair</h1>
	
<form action="${pageContext.request.contextPath}/pairs/update/${pair.getId()}" method="post">
    <span class="label label-default">ID of First Player :</span>
    <input type=text name="firstPlayer" value="${pair.getfirstPlayer()}" class="form-control"><br>
    <span class="label label-default">ID of Second Player :</span>
    <input type=text name="secondPlayer" value="${pair.getsecondPlayer()}" class="form-control"><br>
	<input type=submit class="btn btn-sm btn-success" value="Update">


    </jsp:attribute>
</mt:template>
