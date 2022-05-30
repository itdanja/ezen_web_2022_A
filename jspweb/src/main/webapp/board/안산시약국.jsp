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
		//JSONArray array2 = new JSONArray( object.get("data").toString() ); // o
		
		// System.out.print( array.toString() );
		// System.out.print( array2.toString() );
	%>
	
	<form action="안산시약국.jsp"> <!-- 주소 검색  -->
		<input type="text" name="keyword" placeholder="주소">
		<input type="submit" value="검색"> 
	</form>
	
	<!-- 카카오 지도 표시 div -->
	<div id="map" style="width:100%;height:350px;"></div>
	
	<table class="table table-hover">
		<tr>
			<th> 약국명 </th>		<th> 대표전화 </th>	<th> 주소 </th>
			<th> 월요일운영 </th>	<th> 화요일운영 </th>	<th> 수요일운영 </th>
			<th> 목요일운영 </th>	<th> 금요일운영 </th>	<th> 토요일운영 </th>
			<th> 일요일운영 </th>	<th> 월요일운영 </th>
		</tr>
	<%
		// JSON 출력
		for( int i = 0 ; i<array.length() ; i++ ){ 
			JSONObject jo = array.getJSONObject(i); // i번째 json객체	
			
			//검색 
			String keyword = request.getParameter("keyword");
			if( keyword != null ){ // 만약에 검색이 있을경우 
				int index =  jo.get("주소").toString().indexOf(keyword);
				if( index == -1 ){ continue; }	// -1 인덱스는 없다는 의미  // for문 , while문 : 1.break : 반복문종료  / 2. continue : 반복문 재실행
			}
	%>
		<tr style="font-size: 8px;" onclick="map()">
			<td> <%=jo.get("약국명") %> </td>		<td> <%=jo.get("대표전화") %> </td>	<td> <%=jo.get("주소") %> </td>
			<td> <%=jo.get("월요일 운영") %> </td>	<td> <%=jo.get("화요일 운영") %> </td>	<td> <%=jo.get("수요일 운영") %> </td>
			<td> <%=jo.get("목요일 운영") %> </td>	<td> <%=jo.get("금요일 운영") %> </td>	<td> <%=jo.get("토요일 운영") %> </td>
			<td> <%=jo.get("일요일 운영") %> </td>	<td> <%=jo.get("공휴일 운영") %> </td>
		</tr>
	<% }%>
	</table>	
	
	</div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b7c0acb1395b016fc6b2661dad73840f"></script>
	<script type="text/javascript" src="/jspweb/js/kakaomap.js"></script>
	<%@include file = "../footer.jsp" %>
	
	
</body>
</html>













