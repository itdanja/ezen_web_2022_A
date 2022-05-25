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
			<div class="col-sm-6"> <!-- 일 매출 테이블  -->
				주문확정 리스트
			</div>
			<div class="col-sm-6"> <!-- 카테고리별 차트  -->
				<div id="chartdiv2"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/jspweb/js/productsales.js"></script>

</body>
</html>