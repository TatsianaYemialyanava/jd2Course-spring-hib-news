<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main_index.css" />
<style>
input {
	width: 20%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid brown;
	border-radius: 4px;
}

input[type=submit] {
	width: 10%;
	border: 2px solid brown;
	padding: 10px;
	border-radius: 15px;
}
</style>
<fmt:setLocale value="${sessionScope.twoLettersLanguage}" />
<fmt:setBundle basename="localization.interface" var="interfaceBundle" />

<fmt:message bundle="${interfaceBundle}" key="local.locbutton.name.ru" var="ru_button" />
<fmt:message bundle="${interfaceBundle}" key="local.locbutton.name.en" var="en_button" />
<fmt:message bundle="${interfaceBundle}" key="registration.name" var="name" />
<fmt:message bundle="${interfaceBundle}" key="registration.surname" var="surname" />
<fmt:message bundle="${interfaceBundle}" key="registration.email" var="email" />
<fmt:message bundle="${interfaceBundle}" key="registration.login" var="regLogin" />
<fmt:message bundle="${interfaceBundle}" key="registration.login.information" var="regLoginInfo" />
<fmt:message bundle="${interfaceBundle}" key="registration.password" var="regPassword" />
<fmt:message bundle="${interfaceBundle}" key="registration.password.information" var="regPasswordInfo" />
<fmt:message bundle="${interfaceBundle}" key="registration.button.save"	var="regSave" />
<fmt:message bundle="${interfaceBundle}" key="fullNews.button.backToMainPage" var="backToMainPage" />
<fmt:message bundle="${interfaceBundle}" key="index.contacts" var="contacts" />
</head>
<body>
	<div class="header" align="center" style="font-size: 200%">
		<h1>The local news</h1>
	</div>

	<form action="AnonymousController" method="post">
		<input type="hidden" name="command" value="localization" /> 
		<input type="hidden" name="language" value="ru" /> 
		<input type="hidden" name="commandRedirect" value="command=registration" /> 
		<input type="submit" value="${ru_button}" /> <br />
	</form>

	<form action="AnonymousController" method="post">
		<input type="hidden" name="command" value="localization" /> 
		<input type="hidden" name="language" value="en" /> 
		<input type="hidden" name="commandRedirect" value="command=registration" /> 
		<input type="submit" value="${en_button}" /> <br />
	</form>

	<c:if test="${param.message != 'null'}">
		<div align="center">
			<font color="green"> <c:out value="${param.message}" />
			</font>
		</div>
	</c:if>

	<br />
	<div id="container" align="center">

		<form:form action="AnonymousController?command=savenewuser" modelAttribute="user" method="POST">
			<form:hidden path="idUser" />

			<label><c:out value="${name}" />:</label><br>
			<form:input path="name" />

			<br>

			<label><c:out value="${surname}" />:</label><br>
			<form:input path="surname" />

			<br>

			<label><c:out value="${email}" />:</label><br>
			<form:input path="email" />

			<br>

			<label><c:out value="${regLogin}" />:</label><br>
			<form:input path="login" />

			<br>


			<label><c:out value="${regPassword}" />:</label><br>
			<form:input path="password" />
			<br>

			<label></label>
			<input type="submit" value="${regSave}" class="save" />

		</form:form>
	
	<div style=""></div>

	<p>
		<a href="Controller?command=gotoindexpage"> ${backToMainPage} </a>
	</p>
	</div>

	<div class="footer"
		style="height: 10%; position: absolute; bottom: 0px;">
		<h2>
			<c:out value="${contacts}" />
			: tatsiana88_88@tut.by
		</h2>
	</div>

</body>
</html>