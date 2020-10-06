<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<mt:template title="Browser">
    <jsp:attribute name="content">
        <h1>Players Browser</h1>

        <table class="table table-hover">
            <thead>
            <tr>
                <td>Name</td>
                <td>Points</td>
                <td>Sex</td>
            </tr>
            </thead>
            <c:forEach items="${players}" var="plr">
                <tr>
                    <td>${plr.getName()}</td>
                    <td>${plr.getPoints()}</td>
                    <td>${plr.getSex()}</td>
                    <td style="width:5%">
						<form:form action="/players/${plr.getId()}" method="POST">
                            <input type="submit" class="btn btn-sm btn-danger" value="Delete">
                        </form:form>
                    </td>
                    <td style="width:5%">
						<form:form action="/players/update/${plr.getId()}" method="GET">
                            <input type="submit" class="btn btn-sm btn-success" value="Update">
                        </form:form>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </jsp:attribute>
</mt:template>
