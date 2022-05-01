<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		/* �⺻�� ���� */
		*{ margin: 0; padding: 0; 
			box-sizing: border-box; font-family: "����" }
		li{ list-style-type: none;}
		header { position: relative; height: 70px; }
		header .logo{ position: absolute; top:25px; left: 20px;}
		header .logo span{ color: blue; font-weight: bold; }
		header .menu{ display:none; position: absolute; top:25px; right: 20px; }
		
		a{ text-decoration: none; color: black;}
		
		/* �޴� ���� */
		header .menu_btn{ width: 20px; position: absolute; top: 20px; right: 20px; }
		header .menu_btn li{ border-bottom: solid 2px black; padding: 3px 0px; }
		
		/* �׸��� */
		[class*="col_"] {  float: left; }		/* �⺻ �� ����Ʈ�� css */
		.col_s_1 { width: 8.33%; }   .col_s_2 {  width: 16.66%;  }.col_s_3 { width: 25%; }     
		.col_s_4 {  width: 33.33%;  }.col_s_5 { width: 41.66%; }  .col_s_6 {  width: 50%;  }
		.col_s_7 { width: 58.33%; }  .col_s_8 {  width: 66.66%;  }.col_s_9 { width: 75%; }     
		.col_s_10 {  width: 83.33%;  } .col_s_11 { width: 91.66%; } .col_s_12 { width: 100%; }
		
		@media only screen and (min-width: 770px) {  /* �׺� CSS */
		   
		    .col_m_1 { width: 8.33%; }   .col_m_2 { width: 16.66%; }.col_m_3 { width: 25%; }     
		    .col_m_4 { width: 33.33%;  } .col_m_5 { width: 41.66%; }  .col_m_6 { width: 50%; }
		    .col_m_7 { width: 58.33%; }  .col_m_8 { width: 66.66%; }.col_m_9 { width: 75%; }     
		    .col_m_10 { width: 83.33%; } .col_m_11 { width: 91.66%; } .col_m_12 { width: 100%; }
		    
		    .box { max-width: 1200px; margin: 0 auto; position: relative;}
		
		}
		@media only screen and (min-width: 1200px) {  /* ����ũ�� CSS */
		   
		    .col_1 { width: 8.33%; }   .col_2 { width: 16.66%; } .col_3 { width: 25%; }     
		    .col_4 { width: 33.33%; }	.col_5 { width: 41.66%; }  .col_6 { width: 50%; }
		    .col_7 { width: 58.33%; }  .col_8 { width: 66.66%; } .col_9 { width: 75%; }     
		    .col_10 { width: 83.33%; } .col_11 { width: 91.66%; } .col_12 { width: 100%; }
		    .box {max-width: 1200px; margin: 0 auto;position: relative;}
		    
		    header .menu_btn { display: none; } 
		    header .menu { display: block; } 
		    header .menu li { display: inline; margin: 5px 0 0 50px;
		}
		   
		}
	</style>	

</head>
<body>
	<header>
		<div class="box">
			<h1 class="logo"> <a href="index.jsp"><span>THE</span> ��Ʃ���</a> </h1>
			<ul class="menu">
				<li><a href="#"> ��Ʃ��� �Ұ� </a>  </li>
				<li><a href="#">  ��Ʃ��� ����  </a> </li>
				<li><a href="#">  ��α�  </a> </li>
				<li><a href="#">  ���� ������  </a> </li>
				<li><a href="#">  ���ô� ��  </a> </li>
			</ul>
			
			<!-- �޴� �����  -->
			<ul class="menu_btn">
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
	</header>
</body>
</html>
















