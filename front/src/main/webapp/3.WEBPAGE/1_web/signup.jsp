<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
	
		#contents{ margin: 100px 0px; }
		h3{ text-align: center;}
		li{ list-style-type: none; }/* 글머리 제거 */
		#join{
			width: 600px;
			margin: 0 auto; /* 가운데 정렬 */
			border-top: solid 2px red;
			border-bottom: solid 2px red;
			padding: 30px;
		}
		.cols{ padding: 5px; }
		.cols li{ display: inline-block; }
		.col1{ width: 150px; }
		.col2 input { width: 200px; height: 30px; } 
		.email input , select  { height: 30px; }
		.hello{ vertical-align: top; } /* 텍스트 세로정렬 */
		#button{
			width: 600px;
			margin: 0 auto;
			text-align: right;
		}
		#button input{
			padding: 10px 20px; 
			margin-top: 20px;
		}
	</style>

</head>
<body>

	<%@include file="header.jsp"%><!-- 헤더 -->
	<%@include file="mainimage.jsp"%><!-- 헤더이미지 -->
	
	<div id="contents">
		<h3> 회원 가입 폼 </h3>
		<form> <!-- 폼 양식 -->
			<ul id="join"> <!-- 전체 -->
				<li> <!-- 행 [ tr ] -->	
					<ul class="cols"> 
						<li class="col1"> 아이디 </li> <!-- 열 [ td ] -->
						<li class="col2"> <input type="text"> </li> <!-- 열 [ td ] -->
					</ul>
				</li>
				<li>
					<ul  class="cols">
						<li class="col1"> 비밀번호 </li> 		
						<li class="col2"> <input type="password"> </li>
					</ul>
				</li>
				<li>
					<ul  class="cols">
						<li class="col1"> 비밀번호 확인 </li>
						<li class="col2"> <input type="password">  </li>
					</ul>
				</li>
				<li>
					<ul  class="cols">
						<li class="col1">이름</li>
						<li class="col2"><input type="text"></li>
					</ul>
				</li>
				<li>
					<ul  class="cols">
						<li class="col1"> 이메일	 </li>
						<li class="email"> <input type="text">  @
							<select>
								<option> 직접 입력 </option>
								<option> naver.com </option>
								<option> nate.com </option>
							</select> 
						</li>
					</ul>
				</li>
				<li>
					<ul  class="cols">
						<li class="col1"> 이메일 수신 </li>
						<li >
							<input type="radio" name="reception">비수신
							<input type="radio" name="reception">수신	
						</li>
					</ul>
					 	
					
				</li>
				<li>
					<ul  class="cols">
						<li class="col1"> 가입 경로 </li>
						<li >
							<input type="checkbox"> 친구추천
							<input type="checkbox"> 인터넷검색
							<input type="checkbox"> 기타
						</li>
					</ul>
				</li>
				<li>
					<ul  class="cols">
						<li class="col1 hello"> 인사말 </li>
						<li class="col2"> <textarea rows="6" cols="40"></textarea> </li>
					</ul>
				</li>
			</ul>
			
			<div id="button">
				<input type="submit" value="저장하기">
				<input type="reset" value="취소하기">
			</div>
		</form>
	</div>
	
	<%@include file="footer.jsp" %><!-- 푸터 -->

</body>
</html>