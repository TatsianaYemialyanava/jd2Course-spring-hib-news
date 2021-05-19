<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
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
	
	<a href="Controller?command=localization&language=en&commandRedirect=Controller%3Fcommand%3Dgotomainpage"><spring:message code="en.button" /></a><br>
	<a href="Controller?command=localization&language=ru&commandRedirect=Controller%3Fcommand%3Dgotomainpage"><spring:message code="ru.button" /></a>
	
	<div align="left">
		<form action="logout" method="POST">
			<a href="#" onclick="this.parentNode.submit()"><spring:message code="main.logout" /></a>
			<sec:csrfInput/>
		</form>
		<br />
		<h1><spring:message code="local.message" /></h1>
		<h1>
			<sec:authentication property="principal.username"/>!
		</h1>
	</div>
		
	<c:if test="${param.message != 'null'}">
		<div align="center">
			<font color="green"> 
			<c:out value="${param.message}" />
			</font>
		</div>
	</c:if>

	<div align="center">

		<table border="2">
			<c:forEach var="n" items="${requestScope.news}">
				<tr>
					<td><font size="16" color="black" align="center"> 
					<c:out value="${n.title}" />
							<div style="font-size: 40%">
								<c:out value="${n.brief}" />
								<br />
								<div align="right">
									<a href="Controller?command=go_to_full_news_page&id=<c:out value="${n.id}"/>">
										<spring:message code="main.fullNews" />
									</a>

								</div>
							</div>
					</font></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="footer" style="height: 10%; position: absolute; bottom: 0px;">
		<h2><spring:message code="index.contacts" />: tatsiana88_88@tut.by</h2>
	</div>
</body>
</html>