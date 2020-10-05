<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<mt:template title="BeachclubApp">
    <jsp:attribute name="content">

	<h1>Update Home Player</h1>.
	
	
	
<form action="${pageContext.request.contextPath}/home-players/update/${homePlayer.getId()}" method="post">
<span class="label label-default">Name :</span>
<input type=text name="name" value="${homePlayer.getName()}" class="form-control"><br>
<span class="label label-default">Points :</span>
<input type=text name="role" value="${homePlayer.getPoints()}" class="form-control"><br>

<span class="label label-default">Sex :</span>
<input type=text name="sex" value="${homePlayer.getSex()}" class="form-control"><br>
<span class="label label-default">Phone :</span>
<input type=text name="phone" value="${homePlayer.getPhone()}" class="form-control"><br>
<span class="label label-default">Email :</span>
<input type=text name="email" value="${homePlayer.getEmail()}" class="form-control"><br>
<span class="label label-default">Address : </span>
<input type=text name="address" value="${homePlayer.getAddress()}" class="form-control"><br>
<span class="label label-default">Registration Number : </span>
<input type=text name="RegistrationNumber" value="${homePlayer.getRegistrationNumber()}" class="form-control"><br>
<div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input" value="homePlayer.isRightHanded()">
<label class="custom-control-label" >Right Handed?</label>
</div>
<span class="label label-default">Clothes Size :</span>
<input type=text name="ClothesSize" value="${homePlayer.getClothesSize()}" class="form-control"><br>
<input type=submit class="btn btn-sm btn-success">
</form>

    </jsp:attribute>
</mt:template>
