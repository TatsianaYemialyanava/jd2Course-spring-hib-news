<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, by.htp.les04.bean.News"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/main_index.css"
	type="text/css" rel="stylesheet" />
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
	border-radius: 25px;
}
</style>
<fmt:setLocale value="${sessionScope.twoLettersLanguage}" />
<fmt:setBundle basename="localization.interface" var="interfaceBundle" />

<fmt:message bundle="${interfaceBundle}" key="local.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${interfaceBundle}" key="local.locbutton.name.en"
	var="en_button" />
<fmt:message bundle="${interfaceBundle}" key="index.login" var="login" />
<fmt:message bundle="${interfaceBundle}" key="index.password"
	var="password" />
<fmt:message bundle="${interfaceBundle}" key="index.send" var="send" />
<fmt:message bundle="${interfaceBundle}" key="index.registration"
	var="registration" />
<fmt:message bundle="${interfaceBundle}" key="index.contacts"
	var="contacts" />
</head>
<body>
	<div class="header" align="center" style="font-size: 200%">
		<h1>The local news</h1>
	</div>

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="localization" /> <input
			type="hidden" name="language" value="ru" /> <input type="hidden"
			name="commandRedirect" value="command=gotoindexpage" /> <input
			type="submit" value="${ru_button}" /> <br />
	</form>

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="localization" /> <input
			type="hidden" name="language" value="en" /> <input type="hidden"
			name="commandRedirect" value="command=gotoindexpage" /> <input
			type="submit" value="${en_button}" /> <br />
	</form>

	<c:if test="${param.message != 'null'}">
		<div align="center">
			<font color="green"> 
			<c:out value="${param.message}" />
			</font>
		</div>
	</c:if>

	<br />
	
	<form:form action="Controller?command=logination" modelAttribute="user">
			
		Login: <form:input path="login" />
		
		<br><br>
	
		Password: <form:input path="password" />
		
		<br/><br/>
	
		<input type="submit" value="Submit" />
	
	</form:form>
	
	

	<!--<form style="text-align: center" action="Controller" method="post">
		<input type="hidden" name="command" value="logination" />
		<c:out value="${login}" />
		: <br /> <input type="text" name="login" value="" /> <br />
		<c:out value="${password}" />
		: <br /> <input type="password" name="password" value=""> <br />
		<input type="submit" value="${send}" /> <br />
	</form>
-->
	<br />

	<div align="center">
		<a href="Controller?command=registration"><c:out
				value="${registration}" /></a>

		<table border="2">
			<c:forEach var="n" items="${requestScope.news}">
				<tr>
					<td><font size="16" color="black" align="center"> <c:out
								value="${n.title}" />
							<div style="font-size: 40%">
								<c:out value="${n.brief}" />
							</div>
					</font></td>
				</tr>
			</c:forEach>
		</table>
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

