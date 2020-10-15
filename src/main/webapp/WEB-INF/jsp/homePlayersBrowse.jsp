<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<mt:template title="Browser">
    <jsp:attribute name="content">
    <br>
        <h1>Home Players Browser</h1>

        <table class="table table-hover">
            <thead>
            <tr>
                <td style='font-weight:bold'>Name</td>
                <td style='font-weight:bold'>Points</td>
                <td style='font-weight:bold'>Sex</td>
                <td style='font-weight:bold'>Phone</td>
                <td style='font-weight:bold'>Email</td>
                <td style='font-weight:bold'>Address</td>
                <td style='font-weight:bold'>Registration Number</td>
                <td style='font-weight:bold'>Handed</td>
                <td style='font-weight:bold'>Clothes Size</td>
            </tr>
            </thead>
            <c:forEach items="${homePlayers}" var="homplr">
                <tr>
                    <td>${homplr.getName()}</td>
                    <td>${homplr.getPoints()}</td>
                    <td>${homplr.getSex()}</td>
                    <td>${homplr.getPhone()}</td>
                    <td>${homplr.getEmail()}</td>
                    <td>${homplr.getAddress()}</td>
                    <td>${homplr.getRegistrationNumber()}</td>
                    <td>${homplr.getHanded()}</td>
                    <td>${homplr.getClothesSize()}</td>
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
