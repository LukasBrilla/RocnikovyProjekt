<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<mt:template title="Browser">
    <jsp:attribute name="content">
    <br>
        <h1>Deployment of your tournament</h1>
        <br>
        <h4>sorted pairs by points:</h4>
        <table class="table table-hover">
            <thead>
            <bold>
            <tr>
               <td style='font-weight:bold'>Team</td>
                <td style='font-weight:bold'>Points Together</td>
            </tr>
            </bold>
            </thead>
            <c:forEach items="${sortedPairs}" var="regPar">
                <tr>
                    <td>${regPar.getFirstPlayer().getName()} / ${regPar.getSecondPlayer().getName()}</td>
                    <td>${regPar.getAllPoints()}</td>
                </tr>
            </c:forEach>
        <br>
        <br>
        <form:form action="/tournament-pairs" method="GET">
           
             <input type="submit" class="btn btn-sm btn-success" value="Create Tournament">
      </form:form>

        

    </jsp:attribute>
</mt:template>