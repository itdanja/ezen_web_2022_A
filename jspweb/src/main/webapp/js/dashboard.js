
/*--------------사이드바에서 버튼 클릭시 특정태그의 페이지 넣기---------------- */
function pagechange( page ){
	$("#mainbox").load( page+".jsp");
	// $ : jquery 문법 
	// 특정태그호출 : $("#태그id명")
	//  태그.load( 페이지경로 ) : 해당 태그에 페이지 열기 
}
/* ------------------------------------------------------------------*/

/*--------사이드바 위치 변경를 이용한 사이드바 열기/닫기 애니메이션 이벤트----------- */
$( function(){ 
	var side = $("#sidebar"); /* 태그 반복사용를 위해 변수에 담기 */
	 // side.find('span') /* find( ) : 해당 태그내 특정태그 찾기
	 side.find('span').on( 'click' , function(){
					// .on( 'click' , 함수(){  실행코드  });	// 클릭했을때  함수가 실행 
		side.toggleClass('open');
			// toggleClass : 해당 태그에 클래스 넣기 [ open 클래스 넣기 ]
		if( side.hasClass('open') ){	// 해당 태그의 클래스가 open 이면 
			side.stop(true).animate({left:"0px"}, 200 );
			// side 태그의 애니메이션 효과 : 해당태그의 왼쪽위치를 0px 이동
			// animate( {효과} ,  지속시간 )
		}else{
			side.stop(true).animate( {left:"-200px"} , 200 );
			// side 태그의 클래스 open 아니면 애니메이션 효과 : 해당태그의 왼쪽위치를 -200px 이동 
		}
	}); 
});
/* ------------------------------------------------------------------*/





