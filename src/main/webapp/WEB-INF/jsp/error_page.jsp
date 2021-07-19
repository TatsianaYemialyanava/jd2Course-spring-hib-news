<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main_index.css" />

</head>
<body>
	<div class="header" align="center" style="font-size: 200%">
		<h1>The local news</h1>
	</div>
	
	<a href="AnonymousController?command=localization&language=en&commandRedirect=AnonymousController%3Fcommand%3Dgo_to_error_page"><spring:message code="en.button" /></a><br>
	<a href="AnonymousController?command=localization&language=ru&commandRedirect=AnonymousController%3Fcommand%3Dgo_to_error_page"><spring:message code="ru.button" /></a><br>
	
	<div align="center">
		<h1>
			
			<spring:message code="exceptionPage.message1" />
			<spring:message code="exceptionPage.message2" />
			
			<br />

			<c:if test="${param.message != 'null'}">
				<div align="center">
					<font color="green"> 
						<c:out value="${param.message}" />
					</font>
				</div>
			</c:if>
			<br />
		</h1>

		<a href="AnonymousController?command=gotoindexpage"> 
			<spring:message code="exceptionPage.backToMainPage" />
		</a>
	</div>

	<div class="footer" style="height: 10%; position: absolute; bottom: 0px;">
		<h2>
			<spring:message code="index.contacts" />: tatsiana88_88@tut.by
		</h2>
	</div>

</body>
</html>