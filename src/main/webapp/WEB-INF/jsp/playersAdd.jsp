<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<mt:template title="Add Player">
	<jsp:attribute name="content">
 
        <h1>Add New Player</h1>

<form action="${pageContext.request.contextPath}/players" method="post">
<span class="label label-default">Name :</span>
<input type=text name="name" class="form-control"><br>
<span class="label label-default">Points :</span>
<input type=text name="points" class="form-control"><br>
<span class="label label-default">Sex (Male / Female) :</span>
<input type=text name="sex" class="form-control"><br>
<input type=submit class="btn btn-sm btn-success" value="Add">
</form>

  </jsp:attribute>
</mt:template>