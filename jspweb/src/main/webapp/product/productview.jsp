<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!--사용자정의 css 호출-->
	<link rel="stylesheet" href="/jspweb/css/productview.css">
</head>
<body>
	<%@include file = "../header.jsp" %>
	<div class="container viewbox">
		<div class="row">
			<div class="col-md-6"> <!--  이미지  -->
				<img alt="" src="../img/img1.webp">
			</div>
			<div class="col-md-6">  <!-- 상품의 정보 -->
				<div class="infobox">
					<h5 class="view_title"> 에어컨 쿨링 반팔티셔츠 </h5>
					<div class="price_box">
						<span class="price_rat">38%</span>
						<span class="price_dis">29,900원</span>
						<span class="price">48,000원</span>
					</div>
					<div class="size_box">
						<span>[ M , L , XL ]</span>
					</div>
					
					<table class="table info_t my-5">
						<tr>
							<td width="20%"> DELVERY </td> <td> 2,500원 (70,000원 이상 구매시 무료 )
						</tr>
						<tr>
							<td> SAVE </td> <td> 299원(1%)</td>
						</tr>
						<tr>
							<td> COLOR </td>
							<td>  <select class="form-select info_t">
										<option>-[필수]옵션 선택-</option>
									</select> </td>
						</tr>
						<tr>
							<td> SIZE </td> 
							<td>  <select class="form-select info-t">
										<option>-[필수]옵션 선택-</option>
									</select> </td>
						</tr>
					</table>
					<table class="table my-5">
						<tr>
							<td width="60%"> 상품명 </td>
							<td width="25%"> 상품수 </td>
							<td width="15%"> 가격 </td>
						</tr>
						<tr>
							<td> <span>AC 데님 오버핏 셔츠</span>
								<br> 
								<span class="pointbox">- 블루/FREE[95-120] </span>
							</td>
							<td>
								<div class="row g-0"> <!-- g-0 : div간 여백제거 -->
									<div class="col-md-7">
										<input value="1" type="text" 
										class="form-control fc amount_input">
									</div>
									<div class="col-md-4">
										<button class="amount_btn">▲</button>
										<button class="amount_btn">▼</button>
									</div>
									<div class="col-md-1">
										<button class="cancel_btn">x</button>
									</div>
								</div>
							</td>
							<td>
								<span class="pricebox">54,900원</span>
								<br> 
								<span class="pointbox">(적)549원 </span>
							</td>
						</tr>
					</table>
					<div class="row my-5">
						<div class="col-md-6"> 총 상품금액  </div>
						<div class="col-md-6 total_price" > 54,900원(1개)  </div>
					</div>
					<div class="row my-5">
						<div class="col-md-4"><button class="form-control p-4" style="background-color: black; color: white;">바로 구매하기</button></div>
						<div class="col-md-4"><button class="form-control p-4">장바구니 담기</button></div>
						<div class="col-md-4"><button class="form-control p-4">관심상품 등록</button></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file = "../footer.jsp" %>

</body>
</html>





