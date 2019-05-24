<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shuffled Letters</title>
</head>
<body>

<!-- 
	Enigma enigma = (Enigma) request.getAttribute("generatedEnigma");
	printWriter.write(enigma.getMixedLetters());
 -->

<c:set var="enigma" value="${requestScope.generatedEnigma}" />
<c:out value="${enigma.mixedLetters}" />

<form method="post" action="/words/playlight">
	<input type="text" name="word"/>
	<input type="submit" value="play"/>
</form>

</body>
</html>
