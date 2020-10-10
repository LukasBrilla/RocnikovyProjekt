<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<mt:template title="Browser">
    <jsp:attribute name="content">
    <br>
        <h1>Tournament</h1>
        <br>
        <br>
        <h4>Hello ! Now you can make your own tournament.</h4>
        <br>
        <h4>Let´s make a tournament of 16 Beach pairs. Now choose which pairs would be at your tournament.</h4>
        
        <br>
        <br>
        <a href="/pairs/browseTournament" class="btn btn-info" role="button">START</a>

        

    </jsp:attribute>
</mt:template>