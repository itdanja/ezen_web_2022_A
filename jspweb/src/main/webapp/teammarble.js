function 주사위돌리기(){
	alert("주사위 돌립니다.");
	const rand = Math.floor(Math.random() * 6)+1;
	$("#주사위표시").html( rand );
}

function 게임접속( mid ){
	if( mid == 'null' ){
		alert(" 로그인 하고 오세요~ ");
		return;
	}
	alert( mid + " 안녕하세요 ~ ");
	$.ajax({ 
		url : "enter",
		data : { "mid" : mid  },
		success : function( result ){
		}
	});
	
	
}


/* 특정 시간만큼 반복되는 함수 */
$(function() {
	timer = setInterval( function () {
	    $.ajax ({
	        url : "enterlist",
	        cache : false,
	        success : function ( re ) {
		        $("#접속명단").html( re );
	        }
	    });
	    }, 1500);
});