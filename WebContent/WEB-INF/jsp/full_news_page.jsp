<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main_index.css" />
	
	<fmt:setLocale value="${sessionScope.twoLettersLanguage}" />
	<fmt:setBundle basename="localization.interface" var="interfaceBundle" />

	<fmt:message bundle="${interfaceBundle}" key="local.message" var="message" />
	<fmt:message bundle="${interfaceBundle}" key="local.locbutton.name.ru" var="ru_button" />
	<fmt:message bundle="${interfaceBundle}" key="local.locbutton.name.en" var="en_button" />
	<fmt:message bundle="${interfaceBundle}" key="fullNews.button.backToMainPage" var="backToMainPage" />
	<fmt:message bundle="${interfaceBundle}" key="fullNews.button.edit" var="edit" />
	<fmt:message bundle="${interfaceBundle}" key="fullNews.button.delete" var="delete" />
	<fmt:message bundle="${interfaceBundle}" key="main.logout" var="logout" />
	<fmt:message bundle="${interfaceBundle}" key="index.contacts" var="contacts" />
</head>
<body>
	<div class="header" align="center" style="font-size: 200%">
  		<h1>The local news</h1>
	</div>
	
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="localization" /> 
		<input type="hidden" name="language" value="ru" />
		<input type="hidden" name="commandRedirect" value="command=go_to_full_news_page&id=${param['id']}" />
		<input type="submit" value="${ru_button}" />
		<br />
	</form>

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="localization" /> 
		<input type="hidden" name="language" value="en" />
		<input type="hidden" name="commandRedirect" value="command=go_to_full_news_page&id=${param['id']}" />
		<input type="submit" value="${en_button}" />
		<br />
	</form>

	<div align="left">
		<form action="logout" method="POST">
			<a href="#" onclick="this.parentNode.submit()">Logout</a>
			<sec:csrfInput/>
		</form>
		<br />
		<h1><c:out value="${message}" /></h1>
		<h1>
			<c:out value="${name}" />
			!
		</h1>
	</div>
	
	<c:if test="${param.message != 'null'}">
		<div align="center">			
      		<font  color="green" >	
        	<c:out value="${param.message}" />
    		</font>
		</div>
	</c:if>	
   
    <br/>
	
	<div align="center" style="position:absolute; left:150px; right:150px;">
		<c:set var="n" value='${requestScope["singleNews"]}' />
		<font size="16" color="black" align="center"> 
		<c:out value="${n.title}" />
				<div style="font-size: 40%">
				<c:out value="${n.content}" />
				<hr />
				<div align="right">
					<c:out value="${n.date}" />
				</div>
			</div>
		</font>
		
		<div align="center">
			<table>
				<tr>			
					<td>
						<form action="Controller" method="get">
      					<input type="hidden" name="command" value="gotomainpage" />
						<button><c:out value="${backToMainPage}" /></button>
						</form>
					</td>
					
     				<c:if test = "${sessionScope.role eq \"admin\"}">
						<td>
							<form action="Controller" method="get">
      						<input type="hidden" name="command" value="go_to_edit_page" />
      						<input type="hidden" name="id" value="${param['id']}">
							<button><c:out value="${edit}" /></button>
							</form>
						</td>
						<td>
							<form action="Controller" method="get">
      						<input type="hidden" name="command" value="delete_news" />
      						<input type="hidden" name="id" value="${param['id']}">
							<button><c:out value="${delete}" /></button>
							</form>
						</td>
					</c:if>
				</tr>
			</table>
		</div>
	</div>
	
	<div class="footer" style="height:10%; position:absolute; bottom:0px;">
  		<h2><c:out value="${contacts}" />: tatsiana88_88@tut.by</h2>
	</div>
</body>
</html>