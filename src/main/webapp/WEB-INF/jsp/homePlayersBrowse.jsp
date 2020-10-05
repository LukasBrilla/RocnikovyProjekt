<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<mt:template title="Browser">
    <jsp:attribute name="content">
        <h1>Home Players Browser</h1>

        <table class="table table-hover">
            <thead>
            <tr>
                <td>Name</td>
                <td>Points</td>
                <td>Sex</td>
                <td>Phone</td>
                <td>Email</td>
                <td>Address</td>
                <td>Registration Number</td>
                <td>Player is...</td>
                <td>Clothes Size</td>
            </tr>
            </thead>
            <c:forEach items="${homePlayers}" var="homplr">
                <tr>
                    <td>${homplr.getName()}</td>
                    <td>${homplr.getPoints()}</td>
                    <td>${homplr.getPhone()}</td>
                    <td>${homplr.getEmail()}</td>
                    <td>${homplr.getAddress()}</td>
                    <td>${homplr.getRegistrationNumber()}</td>
                    <td>${homplr.isRightHanded()}</td>
                    <td style="width:5%">
						<form:form action="/home-players/${homplr.getId()}" method="POST">
                            <input type="submit" class="btn btn-sm btn-danger" value="Delete">
                        </form:form>
                    </td>
                    <td style="width:5%">
						<form:form action="/home-players/update/${homplr.getId()}" method="GET">
                            <input type="submit" class="btn btn-sm btn-success" value="Update">
                        </form:form>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </jsp:attribute>
</mt:template>