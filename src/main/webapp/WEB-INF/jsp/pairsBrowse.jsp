<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<mt:template title="Browser">
    <jsp:attribute name="content">
    <br>
        <h1>Beach Pairs Browser</h1>

        <table class="table table-hover">
            <thead>
            <tr>
                <td style='font-weight:bold'>First Player</td>
                <td style='font-weight:bold'>Second Player</td>
                <td style='font-weight:bold'>Points Together</td>
                            </tr>
            </thead>
            <c:forEach items="${pairs}" var="par">
                <tr>
                    <td>${par.getFirstPlayer().getName()}</td>
                    <td>${par.getSecondPlayer().getName()}</td>
                     <td>${par.getAllPoints()}</td>
                    <td style="width:5%">
						<form:form action="/pairs/${par.getId()}" method="POST">
                            <input type="submit" class="btn btn-sm btn-danger" value="Delete">
                        </form:form>
                    </td>
                    
                </tr>
            </c:forEach>

        </table>

    </jsp:attribute>
</mt:template>
