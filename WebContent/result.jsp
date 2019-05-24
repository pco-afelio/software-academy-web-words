<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shuffled Letters</title>
</head>
<body>

<c:set var="enigma" value="${requestScope.enigma}" />

<!-- si alors -->
<c:choose>
	<c:when test="${enigma.resolved}">
		<p><b>Bravo !</b></p>
	</c:when>
	<c:otherwise>
		<p><b>Perdu ! 
		La solution de <c:out value="${enigma.mixedLetters}"/>
		était <c:out value="${enigma.targetWord}"/>
		</b></p>
	</c:otherwise>
</c:choose>

<!-- 
for(Enigma e: list) {

}	
 -->
 
 
<c:set var="list" value="${requestScope.history}" />
<c:set var="size" value="${fn:length(list) - 1}" />
 
 <h4>les <c:out value="${size}"/> anciennes énigmes</h4>
 
<ul>
<c:forEach var="e" items="${list}" varStatus="status">
	<c:if test="${not status.last}">
		<c:set var="color" value="${e.resolved ? 'green' : 'red'}"/>
		<li style="color: ${color}"> 
			<c:out value="${e.mixedLetters} donnent ${e.targetWord}"/> 
		</li>
	</c:if>
</c:forEach>
</ul>

<a href="/words/playlight">rejouer</a>

</body>
</html>
