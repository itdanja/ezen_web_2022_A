<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/productcart.css" rel="stylesheet">
</head>
<body>
	<%@include file = "../header.jsp" %>
		<div class="container">
		
			<div class="processbox">
				<span> 01 옵션선택 </span> <span> > </span>
				<span> 02 장바구니 </span> <span> > </span>
				<span  id="process_active"> 03 주문결제 </span> <span> > </span>
				<span style="font-size: 1.0vw"> 04 주문완료 </span>
			</div>	
			
			<div class="row">
				<div class="col-sm-8">
					<div> <!--  제품 목록  -->
						<table class="table my-5" id="carttable">
						</table>
					</div>
					
					<div> <!--  받는 사람 정보 -->
						<h5> 받는 사람</h5> 
						<input type="checkbox" id="checkbox"> 회원과 동일 
						<form>
							성명 <input id="ordername"> <br>
							연락처 <input id="orderphone"> <br>
							주소 		
							<br>
								<input type="text" id="sample4_postcode" name="address1" placeholder="우편번호">
								<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
								<input type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소">
								<input type="text" id="sample4_jibunAddress" name="address3" placeholder="지번주소">
								<span id="guide" style="color:#999;display:none"></span>
								<input type="text" id="sample4_detailAddress" name="address4" placeholder="상세주소">
							<br>
							배송 요청사항 <input id="orderrequest"> <br>
						</form>
					</div>
					
				</div>
				
				<div class="col-sm-4">
					<div class="paybox">
						<div> <!-- 포인트 사용 -->
							* 5000포인트 이상부터 사용가능합니다.
							<br>
							보유 포인트 : <span id="mpoint"></span> <br>
							포인트 : <input value="0" id="pointinput"><button onclick="pointbtn()">사용</button>
						</div>
						<div> <!-- 결제 정보 -->
							<div>
								총 상품금액 : <span id="sumprice"></span>  <br>
								배송비 : <span id="deliverypay"></span>  <br>
								포인트사용 : <span id="pointbox"></span> <br>
								총 주문액 : <span id="totalpay"></span> <br>
							</div>
							
							<div> 결제 수단 : <span id ="paymethod"></span>
								<button onclick="paymethod('samsung')"> 삼성페이 </button>
								<button onclick="paymethod('card')"> 카드 </button>
								<button onclick="paymethod('trans')"> 계좌이체 </button>
								<button onclick="paymethod('vbank')"> 무통장 </button>
								<button onclick="paymethod('phone')"> 핸드폰 </button>
							</div>
							<div class="row">
								<div class="col-sm-6">
									<a href="/jspweb/main.jsp">
										<button class="form-control  py-4"> 계속 쇼핑하기 </button>
									</a> 
								</div>
								<div class="col-sm-6">
									<button onclick="payment()" style="background-color: blue; color: white;" class="form-control py-4"> 결제하기 </button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	<!-- iamport.payment.js -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	<script type="text/javascript" src="/jspweb/js/orderpay.js"></script>
	<%@include file = "../footer.jsp" %>
	
	
</body>
</html>