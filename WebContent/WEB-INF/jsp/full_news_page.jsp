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
	
	<a href="Controller?command=localization&language=en&commandRedirect=Controller%3Fcommand%3Dgo_to_full_news_page%26id=${param['id']}"><spring:message code="en.button" /></a><br>
	<a href="Controller?command=localization&language=ru&commandRedirect=Controller%3Fcommand%3Dgo_to_full_news_page%26id=${param['id']}"><spring:message code="ru.button" /></a><br>

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
						<button><spring:message code="fullNews.button.backToMainPage" /></button>
						</form>
					</td>
					
     				<sec:authorize access="hasRole('admin')">
						<td>
							<form action="AdminController" method="get">
      						<input type="hidden" name="command" value="go_to_edit_page" />
      						<input type="hidden" name="id" value="${param['id']}">
							<button><spring:message code="fullNews.button.edit" /></button>
							</form>
						</td>
						<td>
							<form action="AdminController" method="get">
      						<input type="hidden" name="command" value="delete_news" />
      						<input type="hidden" name="id" value="${param['id']}">
							<button><spring:message code="fullNews.button.delete" /></button>
							</form>
						</td>
					</sec:authorize>
				</tr>
			</table>
		</div>
	</div>
	
	<div class="footer" style="height:10%; position:absolute; bottom:0px;">
  		<h2><spring:message code="index.contacts" />: tatsiana88_88@tut.by</h2>
	</div>
</body>
</html>