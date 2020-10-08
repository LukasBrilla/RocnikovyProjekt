<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<mt:template title="Browser">
    <jsp:attribute name="content">
    <br>
        <h1>Employees Browser</h1>

        <table class="table table-hover">
            <thead>
            <tr>
                <td>Name</td>
                <td>Role</td>
            </tr>
            </thead>
            <c:forEach items="${employees}" var="emp">
                <tr>
                    <td>${emp.getName()}</td>
                    <td>${emp.getRole().getName()}</td>
                    <td style="width:5%">
						<form:form action="/employees/${emp.getId()}" method="POST">
                            <input type="submit" class="btn btn-sm btn-danger" value="Delete">
                        </form:form>
                    </td>
                    <td style="width:5%">
						<form:form action="/employees/update/${emp.getId()}" method="GET">
                            <input type="submit" class="btn btn-sm btn-success" value="Update">
                        </form:form>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </jsp:attribute>
</mt:template>
