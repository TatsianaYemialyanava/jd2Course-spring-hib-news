<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main_index.css" />
<fmt:setLocale value="${sessionScope.twoLettersLanguage}" />
<fmt:setBundle basename="localization.interface" var="interfaceBundle" />

<fmt:message bundle="${interfaceBundle}" key="exceptionPage.message1" var="message1" />
<!--<fmt:message bundle="${interfaceBundle}" key="exceptionPage.message2" var="message2" />
<fmt:message bundle="${interfaceBundle}" key="exceptionPage.message3" var="message3" />-->
<fmt:message bundle="${interfaceBundle}" key="exceptionPage.backToMainPage" var="ex_backToMainPage" />
<fmt:message bundle="${interfaceBundle}" key="index.contacts" var="contacts" />
</head>
<body>
	<div class="header" align="center" style="font-size: 200%">
		<h1>The local news</h1>
	</div>

	<div align="center">
		<h1>
			<c:out value="${message1}" />
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


		<a href="Controller?command=gotoindexpage"> 
			<c:out value="${ex_backToMainPage}" />
		</a>
	</div>

	<div class="footer"
		style="height: 10%; position: absolute; bottom: 0px;">
		<h2>
			<c:out value="${contacts}" />: tatsiana88_88@tut.by
		</h2>
	</div>

</body>
</html>