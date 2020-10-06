<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<mt:template title="BeachclubApp">
    <jsp:attribute name="content">

	<h1>Update Player</h1>.
	
	
	
<form action="${pageContext.request.contextPath}/players/update/${player.getId()}" method="post">
<span class="label label-default">Name :</span>
<input type=text name="name" value="${player.getName()}" class="form-control"><br>
<span class="label label-default">Points :</span>
<input type=text name="points" value="${player.getPoints()}" class="form-control"><br>

<span class="label label-default">Sex :</span>
<input type=text name="sex" value="${player.getSex()}" class="form-control"><br>
<input type=submit class="btn btn-sm btn-success">
</form>

    </jsp:attribute>
</mt:template>
