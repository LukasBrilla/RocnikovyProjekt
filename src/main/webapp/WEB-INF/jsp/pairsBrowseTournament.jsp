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
                <td style='font-weight:bold'>Team</td>
                <td style='font-weight:bold'>Points Together</td>
                            </tr>
            </thead>
            <c:forEach items="${pairs}" var="par">
                <tr>
                    <td>${par.getFirstPlayer().getName()} / ${par.getSecondPlayer().getName()}</td>
                    <td>${par.getAllPoints()}</td>
                    
                    <td style="width:5%">
						<form:form action="/pairs/tournament/add" method="POST">
                            <input type="hidden" name="pairId" value="${par.getId()}">
                            <input type="hidden" name="pairs" value="${pairs.toString()}">
                            <input type="hidden" name="registeredPairs" value="${registeredPairs.toString()}">
                            <input type="submit" class="btn btn-sm btn-info" value="Add">
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
 		
        </table>

        <br>

        <h4>Registered teams:</h4>
        <table class="table table-hover">
            <thead>
            <tr>
                <td style='font-weight:bold'>Team</td>
                <td style='font-weight:bold'>Points Together</td>
            </tr>
            </thead>
            <c:forEach items="${registeredPairs}" var="regPar">
                <tr>
                    <td>${regPar.getFirstPlayer().getName()} / ${regPar.getSecondPlayer().getName()}</td>
                    <td>${regPar.getAllPoints()}</td>

                    <td style="width:5%">
						<form:form action="/pairs/tournament/delete" method="POST">
                            <input type="hidden" name="pairId" value="${regPar.getId()}">
                            <input type="hidden" name="pairs" value="${pairs.toString()}">
                            <input type="hidden" name="registeredPairs" value="${registeredPairs.toString()}">
                            <input type="submit" class="btn btn-sm btn-danger" value="Delete">
                        </form:form>
                    </td>
                </tr>
            </c:forEach>

        </table>

        <h4>If you added all wanted teams, continue to create tournament:</h4>
         <form:form action="/pairs/tournament" method="GET">
             <input type="hidden" name="registeredPairs" value="${registeredPairs.toString()}">
             <input type="submit" class="btn btn-sm btn-success" value="Create Tournament">
         </form:form>

    </jsp:attribute>
</mt:template>
