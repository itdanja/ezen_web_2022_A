<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 제품 목록 페이지 </h3>
	
	<table class="table table-hover">
		<tr>
			<th width="5%">제품번호</th>	<th width="5%">대표이미지</th> 		<th width="5%">제품명</th> 		<th width="5%">가격</th>
			<th width="5%">할인율</th>	<th width="5%">판매금액</th>		<th width="5%" >제품상태</th> 		<th width="5%">카테고리</th>
			<th width="5%"> 색상 </th>	<th width="5%"> 사이즈 </th>		<th width="5%" >재고수량 </th> 	<th width="5%">수정일</th>
			<th width="5%"> 비고 </th>
		</tr>
		<%
			ArrayList<Product> products = ProductDao.getProductDao().getproductlist();
			for( Product p : products  ){
		%>
			<tr>
				<th><%=p.getPno() %></th>		<th><img width="100%" src="/jspweb/admin/productimg/<%=p.getPimg()%>"></th> 	
				<th><%=p.getPname() %></th> 	<th><%=p.getPprice()%></th>
				<th><%=p.getPdiscount() %></th>	<th><%=p.getPprice()*p.getPdiscount() %></th>		
				<th><%=p.getPactive() %></th> 	<th><%=p.getCno() %></th>
				<th> 색상 </th>				<th> 사이즈 </th>		
				<th>재고수량 </th> 			<th>수정일</th>
				<th> 
					<button onclick="#" class="">제품 삭제</button> 
					<button onclick="#" class="">제품 수정</button> 
					<button onclick="#" class="">상태 변경</button> 
					<button onclick="#" class="">재고 변경</button> 
				</th>
			</tr>
		<%
			}
		%>
		
	</table>

</body>
</html>



