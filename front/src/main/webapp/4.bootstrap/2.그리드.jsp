<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		*{ border: 1px solid red; background-color: #eeeeee; }
	</style>
</head>
<body>

	<%@include file="1.��ġ.jsp" %>
	<!-- �ڽ��� : container -->
	<!-- �׸��� : �ڽ��ǳ� �� 12���� �и� -->
	<div class="container"> <!-- cotainner �ڽ��� ����  -->
		<div class="row">	<!-- row ���ι�ġ -->
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
			<div class="col-md-1"> .col-md-1 </div>
		</div>
		
		<div class="row"> <!-- row ���ι�ġ -->
			<div class="col-md-8"> .col-md-8</div>
			<div class="col-md-4"> .col-md-4</div>
		</div>
		
		<div class="row">
			<div class="col-md-4"> .col-md-4</div>
			<div class="col-md-4"> .col-md-4</div>
			<div class="col-md-4"> .col-md-4</div>
		</div>
		<div class="row">
			<div class="col-md-6"> .col-md-6</div>
			<div class="col-md-6"> .col-md-6</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-md-8">	<!-- 8 -->
				<div class="row">
					<div class="col-md-4">
						�ܺ� 8 �׸��� ��  4 �׸��� ���
					</div>
					<div class="col-md-8">
						�ܺ� 8 �׸��� ��  8 �׸��� ��� 
					</div>
				</div>
			</div>
			<div class="col-md-4">	<!-- 4 -->
				<div class="row">
					<div class="col-md-6">
						�ܺ� 4 �׸��� �� 6 �׸��� ���
					</div>
					<div class="col-md-6">
						�ܺ� 4 �׸��� �� 6 �׸��� ���
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-md-5"> col-md-5 </div>
			<div class="col-md-5 offset-md-2"> col-md-5 </div>
		</div>
		<div class="row">
			<div class="col-md-4"> col-md-4</div>
			<div class="col-md-7 offset-md-1"> col-md-7</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			 <div class="col-md-5">col-md-5</div>  <!--  5  -->
			 <div class="col-md-8">col-md-8</div> 	<!--  8   :  13�׸��� -->
		</div>
	</div>
	
</body>
</html>









