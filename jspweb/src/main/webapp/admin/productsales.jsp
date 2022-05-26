<%@page import="dto.Ordertail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style type="text/css">
		#chartdiv1 , #chartdiv2{
		  width: 100%;
		  height: 500px;
		}
	</style>

</head>
<body>
	<h3> 매출 관리 </h3>
	
	<div class="containter">
		<div> <!-- 일 매출 차트  -->
			<div id="chartdiv1"></div>
		</div>
		<div class="row">
			<div class="col-sm-6"> <!-- 일 매출 막태 차트  -->
				
				<%
					ArrayList<Ordertail> list = 
					ProductDao.getProductDao().getordertail();
					
				%>
				
				<table class="table table-hover">
					<tr>
						<th> 주문상세번호 </th>
						<th> 주문수량 </th>
						<th> 주문가격 </th>
						<th> 주문번호 </th>
						<th> 재고번호 </th>
					</tr>	
					<%
						for( Ordertail ordertail : list ){
					%>	
						<tr onclick="getchart(<%=ordertail.getSno()%>)">
							<td> <%=ordertail.getOrderdetailno() %> </td>
							<td> <%=ordertail.getSamount() %> </td>
							<td> <%=ordertail.getTotalprice() %> </td>
							<td> <%=ordertail.getOrderno() %> </td>
							<td> <%=ordertail.getSno() %> </td>
						</tr>	
					<% 	
						}
					%>
				</table>
				
			</div>
			<div class="col-sm-6"> <!-- 카테고리별 도넛차트  -->
				<div id="chartdiv2"></div>
			</div>
			<div> <!-- 제품별 판매추이 선차트  -->
				<div id="chartdiv3"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/jspweb/js/productsales.js"></script>

</body>
</html>









