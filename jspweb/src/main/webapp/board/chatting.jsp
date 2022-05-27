<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	 <!-- css --><link href="/jspweb/css/chatting.css" rel="stylesheet">

</head>
<body>
	
	<%@include file = "../header.jsp" %>
	
	<div class="container my-5"> <!-- 박스권 -->
	
		<div class="col-sm-6 offset-3 chattingbox"> <!-- 채팅 관련 구역  -->
		
			<div class="row"> <!-- 하위 태그 가로배치 -->
				<div class="col-sm-4">		<!-- 접속자 목록 표시 구역  -->
					<h5 class="enter_title"> 접속자 목록 </h5>
					
					<div id="enterlist">  
						<!-- 접속된 정보 표시 -->
					</div>
					
				</div>
				
				<div class="col-sm-8">		<!-- 채팅창 구역  -->
					<div id="contentbox" class="contentbox" >	
						<!-- 메시지 표시 구역 -->	
					</div>
					<%
						String mid = (String)session.getAttribute("login");
					%>
					
					<input type="hidden" value="<%=mid%>" id="mid">
					
					<div class="row g-0"> <!--  입력 상자 혹은 전송 버튼 -->
						<div class="col-sm-10"> <!--  입력창 -->
							<textarea id="incontent" rows="3" cols="" class="form-control" onkeyup="enterkey('<%=mid%>')"></textarea>
						</div>
						<div class="col-sm-2"> <!--  전송 버튼 -->
							<button class="form-control sendbtn" onclick="sendbtn('<%=mid%>')">전송</button>
						</div>
					</div>
					
					<div class="btnbox">
						<span>이모티콘</span>		
						<span>첨부파일</span>	
					</div>
					
				</div>
			</div>
			
		</div>
		
	</div>
	
	<!-- js --><script type="text/javascript" src="/jspweb/js/chatting.js"></script>
	<%@include file = "../footer.jsp" %>
	
	<!-- 
			
						<div class="secontent my-3">	 보낼때 메시지 구역
							<span class="date"> 오전 10:07 </span>
							<span class="content"> 안녕하세요 </span>
						</div>
						
						<div class="alarm">				알람 메시지 구역
							<span> 강호동 님이 입장 하셨습니다. </span>
						</div>
						
						
						<div class="row g-0 my-3">    받을때 구역  g-0 : div간 여백제거 
							<div class="col-sm-1 mx-2">
								<img alt="" src="../img/프로필2.png" class="rounded-circle" width="100%" >
							</div>
							
							<div class="col-sm-9">
								<div class="recontent">	  받을때 메시지 구역
									<div class="member_name"> 강호동 </div>
									<span class="content"> 안녕하세요 </span>
									<span class="date"> 오전 10:07 </span>
								</div>
							</div>
						</div>
	
	
	 -->

</body>
</html>






