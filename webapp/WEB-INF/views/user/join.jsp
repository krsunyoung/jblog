<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div class="center-content">
		<h1 class="logo">JBlog</h1>
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		<form:form modelAttribute="userVo" class="join-form" name="joinForm" id="join-form" method="post" 
		action="${pageContext.request.contextPath }/user/join">
			<label class="block-label" for="name">이름</label>
			
			<form:input path="name"/>
			<br>
			<form:errors path="name"/>
			<br>
			<label class="block-label" for="blog-id">아이디</label>
			<form:input path="id"/> 
			<form:errors path="id"/>
			<br>
			<input id="btn-checkid" type="button" value="id 중복체크">
			<img id="img-checkid" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">

			<label class="block-label" for="password">패스워드</label>
			<form:input path="password"/>
			<br>
					<form:errors path="password"/>

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form:form>
	</div>
</body>
</html>
