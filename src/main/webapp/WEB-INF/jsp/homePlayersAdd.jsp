<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<mt:template title="Add Home Player">
	<jsp:attribute name="content">
 <br>
        <h1>Add New Home Player</h1>

<form action="${pageContext.request.contextPath}/home-players" method="post">
    <span class="label label-default">Name :</span>
    <input type=text name="name" class="form-control"><br>
    <span class="label label-default">Points :</span>
    <input type=number name="points" class="form-control"><br>
    <span class="label label-default">Sex :</span>
    <select name="sex" id="sex" class="form-control">
        <option value="" disabled selected hidden>Choose sex</option>
        <option value="Male">Male</option>
        <option value="Female">Female</option>
    </select><br>
    <span class="label label-default">Phone : </span>
    <input type=text name="phone" class="form-control"><br>
    <span class="label label-default">Email : </span>
    <input type=email name="email" class="form-control"><br>
    <span class="label label-default">Address : </span>
    <input type=text name="address" class="form-control"><br>
    <span class="label label-default">Registration Number :</span>
    <input type=text name="registrationNumber" class="form-control"><br>

    <span class="label label-default">Handed :</span>
    <select name="handed" id="handed" class="form-control">
        <option value="" disabled selected hidden>Choose handed</option>
        <option value="Right">Right</option>
        <option value="Left">Left</option>
    </select><br>

    <span class="label label-default">Clothes size :</span>
    <input type=text name="clothesSize" class="form-control"><br>
    <input type=submit class="btn btn-sm btn-success" value="Add">
</form>

  </jsp:attribute>
</mt:template>
