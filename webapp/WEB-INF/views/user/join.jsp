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
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$(function(){
	$("#join-form").submit(function(){
		if($("#img-checkid").is(":visible")==false){
			alert("ID 중복 체크 해야함!");			
			return false;
		}
		if($("#agree-prov").is(":checked")==false){
		$("#agree-check").show();
			return false;
		}
	})
	$("#id").change(function(){   
		$("#img-checkid").hide();
		$("#btn-checkid").show();
	})
	$("#btn-checkid").click(function(){
		var id=$("#id").val(); //email입력 값을 받아옴
		//console.log(email);
		if(id == ""){
			return;
		}
		$.ajax({
			url:"${pageContext.request.contextPath }/user/api/checkid?id="+id,
			type:"get",
			dataType :"json",
			data:"",
			success : function(response){
				if(response.result == "fail"){
					console.log(response.message);
					return;
				}
				//success
				if(response.data == "exist"){
					$("#id-check").show();
					$("#id").val("").focus(); //확인 누른후 email 내용을 지운후 포커스를 그기에 나올수 있도록. 
					return;
				}
				//존재하지 않은 이메일
				$("#img-checkid").show();
				$("#btn-checkid").hide();
				
			}, error : function(jqXHR, status, e){
				console.log(status+":"+e);
			}
			
		});
	});
});
</script>
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
			
			<label class="block-label" for="blog-id">아이디</label>
			<form:input path="id"/> 
			
			<input id="btn-checkid" type="button" value="id 중복체크">
			<p id="id-check" style="display:none;" > 이미 사용되는 아이디입니다.</p>
			<form:errors path="id"/>
			<img id="img-checkid" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">
			
			
			<label id="img-checkid" class="block-label" for="password">패스워드</label>
			<form:password path="password"/>
					<form:errors path="password"/>
			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>
				<p id="agree-check" style="display:none;" > 약관동의는 필수사항입니다.</p>

			<input type="submit" value="가입하기">

		</form:form>
	</div>
</body>
</html>
