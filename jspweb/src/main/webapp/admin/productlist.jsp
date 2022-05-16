<%@page import="java.util.Set"%>
<%@page import="java.util.TreeSet"%>
<%@page import="javax.print.attribute.HashPrintJobAttributeSet"%>
<%@page import="java.util.HashSet"%>
<%@page import="dto.Stock"%>
<%@page import="java.util.Arrays"%>
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
	<table id="producttable" class="table table-hover">
		<tr>
			<th width="5%">제품번호</th>	<th width="5%">대표이미지</th> 		<th width="5%">제품명</th> 		<th width="5%">가격</th>
			<th width="5%">할인율</th>	<th width="5%">판매금액</th>		<th width="5%" >제품상태</th> 		<th width="5%">카테고리</th>
			<th width="5%"> 색상 </th>	<th width="5%"> 사이즈 </th>		<th width="5%" >재고수량 </th> 	<th width="5%">수정일</th>
			<th width="5%"> 비고 </th>
		</tr>
		<%
			ArrayList<Product> products = ProductDao.getProductDao().getproductlist();
			for( Product p : products  ){ // 모든 제품 반복문
				
				////---------    제품별 칼라 / 사이즈 중복제거 set 선언
				ArrayList<Stock> stocks = ProductDao.getProductDao().getStock( p.getPno() ); 
					Set<String> colors = new TreeSet<String>();
					Set<String> sizes = new TreeSet<String>();
				for( Stock s : stocks ){
					colors.add( s.getScolor() );
					sizes.add( s.getSsize() );
				}
				//////////////////////////////////////////////////
		%>
			<tr>
				<th><%=p.getPno() %></th>		<th><img width="100%" src="/jspweb/admin/productimg/<%=p.getPimg()%>"></th> 	
				<th><%=p.getPname() %></th> 	<th><%=p.getPprice()%></th>
				<th><%=p.getPdiscount() %></th>	<th><%=p.getPprice()*p.getPdiscount() %></th>		
				<th><%=p.getPactive() %></th> 	<th><%=p.getCno() %></th>
				
				<th> <!-- 색상 선택 [  id값을 제품별 select 식별id = '문자'+제품번호	// select 변경되면 이벤트 발생 -->
					<select id="colorbox<%=p.getPno()%>" onchange="getamount( <%=p.getPno()%> )"> 
					<%	for( String c : colors){ // colors 값 호출  %> 
						<option><%=c%></option>
					<% } %>
					</select> 
				</th>				
				
				<th> 	<!--  사이즈 선택 -->
					<select id="sizebox<%=p.getPno()%>" onchange="getamount( <%=p.getPno()%> )"> 
					<% for( String s : sizes ){  // sizes 값 호출   %> 
						<option><%=s%></option> 
					<% } %>
					</select> 
				 </th>	
				 
				<th> <!-- 색상과 사이즈에 따른 재고량 표시  -->
					<% if( !stocks.isEmpty() ){ // 재고리스트가 비어 있지 않으면 %>
						<% if(stocks.get(0).getSamount() == 0 ){ // 재고리스트의 첫번쨰 재고정보가 0이면 %>
						<span id='amountbox<%=p.getPno()%>'> 해당 사이즈색상 <br> 재고없음 </span> 
						<% }else{ %>
						<span id='amountbox<%=p.getPno()%>'> <%=stocks.get(0).getSamount() %></span> 
					<% }%>
					<%}else{ // 재고리스트가 비어 있으면 %>
						<span id='amountbox<%=p.getPno()%>'> 재고없음 </span> 
					<%} %>
				</th> 			
				
				<th>  <!-- 색상과 사이즈에 따른 재고 수정일 표시  -->
				<% if( !stocks.isEmpty() ){ // 재고리스트가 비어 있지 않으면 %>
						<% if(stocks.get(0).getSamount() == 0 ){ // 재고리스트의 첫번쨰 재고정보가 0이면 %>
							<span id="datebox<%=p.getPno()%>"> - </span> 
						<% }else{ %>
							<span id="datebox<%=p.getPno()%>"> <%=stocks.get(0).getUpdatedate() %> </span> 
					<% }%>
					<%}else{ // 재고리스트가 비어 있으면 %>
							<span id="datebox<%=p.getPno()%>"> - </span> 
					<%} %>
					
				</th>
				
				<th> 
					<button class="">제품 삭제</button> 
					<button class="">제품 수정</button> 
					<button onclick="pnomove(<%=p.getPno() %>)" data-bs-toggle="modal" data-bs-target="#activemodal">상태 변경</button> 
					<button onclick="getstock(<%=p.getPno() %>)" data-bs-toggle="modal" data-bs-target="#stockmodal" >재고 변경</button> 
				</th>
			</tr>
		<%
		
			}
		%>
		
	</table>
	
	<!-- 상태변경 부트스트랩 - 모달구역  -->
	<div class="modal" tabindex="-1" id="activemodal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">  <!-- 모달 제목 -->
	        <h5 class="modal-title"> 제품의 상태변경 </h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">  <!-- 모달 내용  -->
	        <p> 변경할 상태를 선택해주세요. </p>
	        <input type="hidden" id="modelinput">
	      </div>
	      <div class="modal-footer"> <!-- 모달 버튼 -->
	      		<button type="button" class="btn btn-primary" onclick="activechange(0)">준비</button>
	      		<button type="button" class="btn btn-primary" onclick="activechange(1)">판매</button>
	      		<button type="button" class="btn btn-primary" onclick="activechange(2)">품절</button>
	      		<button type="button" class="btn btn-primary" onclick="activechange(3)">중단</button>
	        	<button id="modalclosebtn" type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 재고변경 - 모달구역  -->
	<div class="modal" tabindex="-1" id="stockmodal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">  <!-- 모달 제목 -->
	        <h5 class="modal-title"> 제품 재고 변경 </h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">  <!-- 모달 내용  -->
	      	<table class="table" id="stocklistbox">
	      		
	      	</table>
	      	<div id="updatebox" style="display: none;">
	      		재고번호 : <input type="hidden" id="sno"> 
	      		재고수량 : <input type="text" id="samount">
	      	</div>
	      </div>
	      <div class="modal-footer"> <!-- 모달 버튼 -->
	      		<button type="button" class="btn btn-primary" onclick="stockupdate()"> 수정 처리</button>
	        	<button id="modalclosebtn2" type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script src="/jspweb/js/productlist.js" type="text/javascript"></script>

</body>
</html>




















