<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<mt:template title="Browser">
    <jsp:attribute name="content">
    <br>
        <h1>Beach Pairs Browser - Tournament</h1>
        <h4>Choose pairs which would play on your tournament.</h4>

        <table class="table table-hover">
            <thead>
            <tr>
                <td>First Player</td>
                <td>Second Player</td>
                <td>Points Together</td>
                            </tr>
            </thead>
            <c:forEach items="${pairs}" var="par">
                <tr>
                    <td>${par.getFirstPlayer()}</td>
                    <td>${par.getSecondPlayer()}</td>
                    <td>${par.getAllPoints()}</td>
                    
                    <td style="width:5%">
						<form:form action= method="GET">
                            <input type="button" class="btn btn-sm btn-success" value="Add">
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
 		
        </table>
         <form:form action="/pairs/tournament" method="GET">
         <input type="submit" class="btn btn-sm btn-success" value="Submit">
         </form:form>

    </jsp:attribute>
</mt:template>
