<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main_index.css" />
<style>
input[type=hidden] {
	width: 20%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid brown;
	border-radius: 4px;
}
input[type=submit] {
	border: 2px solid brown;
	padding: 10px;
	border-radius: 25px;
}
</style>

</head>
<body>

	<div class="header" align="center" style="font-size: 200%">
		<h1>The local news</h1>
	</div>
	
	<a href="AdminController?command=localization&language=en&commandRedirect=AdminController%3Fcommand%3Dgo_to_edit_page%26id=${param['id']}"><spring:message code="en.button" /></a><br>
	<a href="AdminController?command=localization&language=ru&commandRedirect=AdminController%3Fcommand%3Dgo_to_edit_page%26id=${param['id']}"><spring:message code="ru.button" /></a><br>
	
	<c:if test="${param.message != 'null'}">
		<div align="center">
			<font color="green"> <c:out value="${param.message}" />
			</font>
		</div>
	</c:if>

	<br />

	<div id="container" align="center" style="position: absolute; left: 150px; right: 150px;">
		<form:form action="AdminController?command=save_new_information" modelAttribute="singleNews" method="POST">
			<form:hidden path="id" />

			<form:textarea path="title" rows="3" cols="100"></form:textarea>

			<br>

			<form:textarea path="brief" rows="6" cols="100"></form:textarea>

			<br>

			<form:textarea path="content" rows="18" cols="100"></form:textarea>
			<br>		

			<input type="submit" value="<spring:message code='editPageNews.button.save' />" class="save" />

		</form:form>

		<form action="Controller" method="get">
			<input type="hidden" name="command" value="go_to_full_news_page" />
			<input type="hidden" name="id" value="${param['id']}" />
			<input type="submit" value="<spring:message code='editPageNews.button.cancel' />" />
		</form>
		<br />

	</div>

	<div class="footer" style="height: 10%; position: absolute; bottom: 0px;">
		<h2>
			<spring:message code="index.contacts" />: tatsiana88_88@tut.by
		</h2>
	</div>
</body>
</html>