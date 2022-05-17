<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="dto.Stock"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dto.Product"%>
<%@page import="dao.ProductDao"%>
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
	
	<%
	////////////////////////////////////// java ///////////////////////////////////////////
		int pno =  Integer.parseInt( request.getParameter("pno") ); // 제품번호 요청
		Product p = ProductDao.getProductDao().getproduct(pno); // 제품 호출
		ArrayList<Stock> stocks =  ProductDao.getProductDao().getStock(pno); // 해당 제품의 재고
		
		Set<String> sizelist  = new TreeSet<>(); // 사이즈목록 선언   = 중복제거(set컬렉션) 
		for( Stock s : stocks ){ sizelist.add(s.getSsize() ); } // 사이즈 목록 만들기 
		
		Set<String> colorlist  = new TreeSet<>(); // 칼라목록 선언   = 중복제거(set컬렉션) 
		for( Stock s : stocks ){ colorlist.add(s.getScolor() ); } // 칼라 목록 만들기 
		
		DecimalFormat df = new DecimalFormat("###,###원"); // 천단위 구분 쉼표
		Float price = p.getPprice() - ( p.getPprice()*p.getPdiscount() ) ; 	// 할인된금액 계산 
		Float point = price * 0.01f ; // java 기본타입 : 정수형=int 실수=double	// 포인금액 계산 
	///////////////////////////////////////////////////////////////////////////////////////		
	%>
	<div class="container viewbox">
		<div class="row">
		 <!-------------------  이미지 ------------------------- -->
			<div class="col-md-6">
				<img alt="" src="../admin/productimg/<%=p.getPimg()%>">
			</div>
		<!-------------------- 상품의 정보----------------------------- -->
			<div class="col-md-6">  
				<div class="infobox">
					<h5 class="view_title"> <%=p.getPname() %> </h5>
					<div class="price_box">
						<% if( p.getPdiscount() == 0 ){ %> <!-- 할인이 없을때 -->
							<span class="price_dis"> <%= df.format(p.getPprice() ) %></span>
						<%	}else{ %> <!-- 할인이 있을때  -->
							<span class="price_rat"><%=Math.round( p.getPdiscount()*100 ) +"%" %></span>
							<span class="price_dis"><%=df.format( price ) %></span>
							<span class="price"><%= df.format(p.getPprice() ) %></span>
						<%	} %>
					</div>
					<div class="size_box">
						<span> 
							<% for( String t : sizelist ){  %> <!-- 사이즈 목록 출력 -->
								<%=t +"   "%>
							<% } %>
						 </span>
					</div>
					<input type="hidden" value="<%=pno%>" id="pno">
					<table class="table info_t my-5">
						<tr> <td width="20%"> DELVERY </td> <td> 2,500원 (70,000원 이상 구매시 무료 ) </tr>
						<tr> <td> SAVE </td> <td> <%=df.format( point )%>(1%)</td> </tr>
						<tr>
							<td> COLOR </td>
							<td>  <select id="color_select" class="form-select info_t">
										<option value="">-[필수]옵션 선택-</option>
									<% for( String c  : colorlist ){ %>
										<option value=<%=c %> ><%=c %></option>
									<%} %>
									</select> </td>
						</tr>
						<tr>
							<td> SIZE </td> 
							<td>  <select id="size_select" class="form-select info-t">
										<option value="">-[필수]옵션 선택-</option>
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
	<script src="/jspweb/js/productview.js" type="text/javascript"></script>
	<%@include file = "../footer.jsp" %>

</body>
</html>





