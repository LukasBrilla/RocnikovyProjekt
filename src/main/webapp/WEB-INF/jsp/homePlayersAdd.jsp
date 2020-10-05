<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<mt:template title="Add Home Player">
	<jsp:attribute name="content">
 
        <h1>Add New Home Player</h1>

<form action="${pageContext.request.contextPath}/home-players" method="post">
<span class="label label-default">Name :</span>
<input type=text name="name" class="form-control"><br>
<span class="label label-default">Points :</span>
<input type=text name="points" class="form-control"><br>
<span class="label label-default">Sex (Male / Female) :</span>
<input type=text name="sex" class="form-control"><br>
<span class="label label-default">Phone : </span>
<input type=text name="phone" class="form-control"><br>
<span class="label label-default">Email : </span>
<input type=text name="email" class="form-control"><br>
<span class="label label-default">Address : </span>
<input type=text name="address" class="form-control"><br>
<span class="label label-default">Registration Number :</span>
<input type=text name="registrationNumber" class="form-control"><br>

<div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input" id="defaultUnchecked" name="isRightHanded">
<label class="custom-control-label" for="defaultUnchecked">Player is Right Handed</label>
</div>

<span class="label label-default">Clothes size :</span>
<input type=text name="clothesSize" class="form-control"><br>
<input type=submit class="btn btn-sm btn-success" value="Add">
</form>

  </jsp:attribute>
</mt:template>
