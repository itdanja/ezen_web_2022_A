<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file = "../header.jsp" %>
	
	<div class="container">
	
	<%
	// * 공공데이터포털 [ web json페이지를 -> java 변환 ]
		// 1. URL 가져오기 [ URL : java.net패키지 ] 
		URL url = new URL( "https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=300&serviceKey=z427Q0DLkQqM0SDOc1Lz8jPzk%2BKj0ng%2Bvz7h3I8CpVs3T90219bWi2o%2BmStIxJW%2B9lwayA%2FsAT6apxsxuvydQg%3D%3D" );
			// 1. URL 클래스 : JAVA에서 HTTP URL 객체화 
		// 2. JAVA 해당 URL 읽기 [ 바이트 스트림 ]
			// 1. BufferedReader : 외부 데이터 읽어올때 사용되는 클래스 
		BufferedReader bf = new BufferedReader( new InputStreamReader( url.openStream() , "UTF-8") );
		// 3. 읽어오기
		String result = bf.readLine();	// 스트림내 존재하는 바이트 모두 읽어오기 
		// 4. 읽어온 스트림을 JSON 변환
		JSONObject object = new JSONObject( result );
		// 5. JSON객체에서 특정 키의 해당하는 데이터 가져오기 
		JSONArray array = (JSONArray)object.get("data"); // o 
		//JSONArray array2 = new JSONArray( object.get("data").toString() );
		
		System.out.print( array.toString() );
		//System.out.print( array2.toString() );
		
	%>
		
	
	
	</div>
	
	<%@include file = "../footer.jsp" %>
</body>
</html>






