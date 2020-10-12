<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<mt:template title="Browser">
    <jsp:attribute name="content">
    <br>
        <h1>Add Pair Browser</h1>

        <table class="table table-hover">
            <thead>
            <tr>
                <td style='font-weight:bold'>Name</td>
                <td style='font-weight:bold'>Points</td>
                <td style='font-weight:bold'>Sex</td>
            </tr>
            </thead>
            <c:forEach items="${players}" var="plr">
                <tr>
                    <td>${plr.getName()}</td>
                    <td>${plr.getPoints()}</td>
                    <td>${plr.getSex()}</td>

                    <td style="width:5%">
						<form:form action="/pairs/add" method="POST">
                            <input type="hidden" name="playerId" value="${plr.getId()}">
                            <input type="hidden" name="players" value="${players.toString()}">
                            <input type="hidden" name="firstPlayerId" value="${firstPlayerId}">
                            <input type="hidden" name="secondPlayerId" value="${secondPlayerId}">
                            <input type="submit" class="btn btn-sm btn-info" value="Add">
                        </form:form>
                    </td>
                </tr>
            </c:forEach>


        </table>

        <br>

        <h4>Registered players to Pair:</h4>
        <table class="table table-hover">
            <thead>
            <tr>
                <td style='font-weight:bold'>Id</td>
            </tr>
            </thead>
            <tr>
                    <td>${firstPlayerId}</td>
                    <td style="width:5%">
						<form:form action="/pairs/delete" method="POST">
                            <input type="hidden" name="playerId" value="${firstPlayerId}">
                            <input type="hidden" name="players" value="${players.toString()}">
                            <input type="hidden" name="firstPlayerId" value="${firstPlayerId}">
                            <input type="hidden" name="secondPlayerId" value="${secondPlayerId}">
                            <input type="submit" class="btn btn-sm btn-danger" value="Delete">
                        </form:form>
                    </td>
            </tr>
            <tr>
                <td>${secondPlayerId}</td>
                <td style="width:5%">
                    <form:form action="/pairs/delete" method="POST">
                        <input type="hidden" name="playerId" value="${secondPlayerId}">
                        <input type="hidden" name="players" value="${players.toString()}">
                        <input type="hidden" name="firstPlayerId" value="${firstPlayerId}">
                        <input type="hidden" name="secondPlayerId" value="${secondPlayerId}">
                        <input type="submit" class="btn btn-sm btn-danger" value="Delete">
                    </form:form>
                </td>

            </tr>


        </table>


        <h4>Continue to create Pair:</h4>
         <form:form action="/pairs" method="POST">
             <input type="hidden" name="firstPlayerId" value="${firstPlayerId}">
             <input type="hidden" name="secondPlayerId" value="${secondPlayerId}">
             <input type="submit" class="btn btn-sm btn-success" value="Create Pair">
         </form:form>

    </jsp:attribute>
</mt:template>
