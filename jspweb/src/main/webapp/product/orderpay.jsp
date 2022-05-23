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
							주소 <input id="orderaddress"> <br>
							배송 요청사항 <input id="orderrequest"> <br>
						</form>
					</div>
					
				</div>
				
				<div class="col-sm-4">
					<div class="paybox">
						<div> <!-- 포인트 사용 -->
							* 5000포인트 이상부터 사용가능합니다.
							포인트 : <input> <button>사용</button>
						</div>
						<div> <!-- 결제 정보 -->
							<div>
								총 상품금액 : <span> 29,000원 </span>  <br>
								배송비 : <span> 3,000원 </span>  <br>
								포인트사용 : <span> 0 원 </span> <br>
								총 결제액 : <span> 32,000 원 </span> <br>
							</div>
							
							<div> 결제 수단
								<button> 삼성페이 </button>
								<button> 카드 </button>
								<button> 계좌이체 </button>
								<button> 무통장 </button>
								<button> 핸드폰 </button>
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