<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%@include file="header.jsp" %>
	<br><br><br><br><br><br><br><br><br><br>
	
	<div class="container">
		<h3 class="text-center titleline"> ���� �� </h3>
		<!-- ��ư -->
		<div class="my-3">
			<a href="boardlist.jsp"><button class="btn btn-outline-info">���</button></a>
			<a href="boardlist.jsp"><button class="btn btn-outline-info">����</button></a> <!-- �ۼ��ڸ� ���� [ ��ȿ���˻� ] -->
			<a href="boardlist.jsp"><button class="btn btn-outline-info">����</button></a> <!-- �ۼ��ڸ� ���� [ ��ȿ���˻� ] -->
			<a href="boardlist.jsp"><button class="btn btn-outline-info">�亯</button></a> <!-- �����ڸ� ���� [ ��ȿ���˻� ] -->
		</div>
		<!-- �ۼ��� �Է��� ���� -->
		<div> <!-- div�ڽ��� : display : block   /  span�ڽ��� : display : inline -->
			<div> <span>�ۼ��� </span> <span> ���缮 </span></div>
			<div> <span>���ǳ�¥ </span> <span> 2022-04-24 10:10 </span></div>
		</div>
		<div>
			<input type="text" value="ȯ�����ּ���~~~" class="form-control" readonly >
		</div>
		<div>
			<textarea rows="20" cols="" class="form-control" readonly style="resize: none;" > �����������Ϥ�������</textarea>
																	<!-- textarea ũ����� -->
		</div>
		
		<div class="row my-4"> <!-- ÷�ε� ������  -->
			<h4> ÷�� ���� </h4>
			<div class="col-md-3"> 
				<img alt="" src="img/item1.gif" width="100%">
			</div>
			<div class="col-md-3"> 
				<img alt="" src="img/item1.gif" width="100%">
			</div>
			<div class="col-md-3"> 
				<img alt="" src="img/item1.gif" width="100%">
			</div>
			<div class="col-md-3"> 
				<img alt="" src="img/item1.gif" width="100%">
			</div>
		</div>
		
		<!-- �����ڰ� �亯�� ���� -->
		<h4> �亯 </h4> 
		<p> �亯�� : 2022-04-23 12:10 </p>
		<div>
			<textarea rows="" cols="" class="form-control inputbackcolor" readonly style="resize: none;"  > ȣȣȣȣȣȣȣȣȣȣȣ </textarea>
		</div>
		
	</div>
	<br><br><br><br><br><br><br><br><br><br>
	<%@include file="footer.jsp" %>
</body>
</html>













