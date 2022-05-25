<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<link href="/jspweb/css/myshopping.css" rel="stylesheet">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<%@include file = "../header.jsp" %>
	<div class="container"> <!-- 박스권 -->
		<div class="row"> <!-- 가로배치 -->
			<div class="col-md-3"> <!-- 사이드바 -->
				<%@include file ="infosidebar.jsp" %>
			</div>	
			<div class="col-md-9"> <!-- 본문 -->
				<h3>주문현황</h3>
				<div id="orderbox">
					
				</div>
			</div>
		</div>
	</div>
	
	<!-- 취소 Modal -->
	<div class="modal fade" id="cancelmodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel"> 주문 취소 </h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      
	       	<h5> 주문 취소 요청 사유 </h5>
	       	<textarea id="cancelconfirm" rows="" cols="" class="form-control"></textarea>
	       	
	      </div>
	      <div class="modal-footer">
	        <button id="modalcolse" type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	        <button onclick="cancel()" type="button" class="btn btn-primary"> 주문 취소 요청</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	
	
	
	
	
	<script src="/jspweb/js/myshopping.js" type="text/javascript"></script>
	<%@include file = "../footer.jsp" %>

</body>
</html>






