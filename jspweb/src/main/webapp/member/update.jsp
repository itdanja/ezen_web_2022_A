<%@page import="dao.MemberDao"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<%@include file = "../header.jsp" %>
	
	<%
		// 1. 세션에 저장된 회원ID 호출
		String mid = (String)session.getAttribute("login");
		// 2. 회원정보 가져오기
		Member member = MemberDao.getmemberDao().getmember(mid);
	%>
	
	<div class="container"> <!-- 박스권 -->
		<div class="row"> <!-- 가로배치 -->
			<div class="col-md-3"> <!-- 사이드바 -->
				<%@include file ="infosidebar.jsp" %>
			</div>	
			<div class="col-md-9"> <!-- 본문 -->
				<%
					if( request.getParameter("result") != null  && request.getParameter("result").equals("1") ){
				%>
					<div> 회원정보가 수정 되었습니다.!!! </div>
				<%
					}else if( request.getParameter("result") != null  && request.getParameter("result").equals("2")  ){
				%>	
					<div> 회원정보가 실패!! 관리자에게문의 </div>
				<% 	
					}else if( request.getParameter("result") != null  && request.getParameter("result").equals("3")  ){
				%>
					<div> 회원정보가 실패!! 기존 비밀번호가 다릅니다. </div>
				<%
					}
				%>
				<h3>회원수정</h3>
				<form action="../update" method="post"> <!-- update 서블릿 파일로 post 전송 -->
					<input type="hidden" name="mno" value="<%=member.getMno()%>" > <!-- 수정할 대상[pk] -->
					아이디 : <%=member.getMid() %> <br>
					비밀번호 : <button type="button" onclick="passwordchange()"> 비밀번호 변경 </button> <br>
					
						<div id="passwordbox" style="display: none;">
							기존 비밀번호 : <input type="password" name="oldpassword"><br>
							새온 비밀번호 : <input type="password" name="newpassword">	
						</div>
						
					이름 : <input type="text" name="mname" value="<%=member.getMname()%>"> <br>
					연락처 : <input type="text" name="mphone" value="<%=member.getMphone()%>"> <br>
					이메일 : 
					<input type="text" name="memail" value="<%=member.getMemail().split("@")[0]%>"> @
					<input type="text" name="memailaddress" value="<%=member.getMemail().split("@")[1]%>">
					<select id="emailselect" >
						<option value=""> 직접입력 </option>
						<option value="naver.com"> naver.com </option>
						<option value="nate.com"> nate.com </option>
						<option value="daum.com"> daum.com </option>
					</select>
					<br>
					배송주소 : 
				<input type="text" name="address1" value="<%=member.getMaddress().split("_")[0] %>" id="sample4_postcode" name="address1" placeholder="우편번호">
				<input type="button"  onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text"  name="address2"  value="<%=member.getMaddress().split("_")[1] %>" id="sample4_roadAddress" name="address2" placeholder="도로명주소">
				<input type="text"  name="address3" value="<%=member.getMaddress().split("_")[2] %>" id="sample4_jibunAddress" name="address3" placeholder="지번주소">
				<span id="guide" style="color:#999;display:none"></span>
				<input type="text"  name="address4" value="<%=member.getMaddress().split("_")[3] %>" id="sample4_detailAddress" name="address4" placeholder="상세주소">
				<br>
					<input type="submit" value="변경적용">
					<a href="/jspweb/member/update.jsp"><button type="button">변경취소</button></a>
				</form>
			</div>
		</div>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="../js/signup.js" type="text/javascript"></script>
	<%@include file = "../footer.jsp" %>

</body>
</html>






