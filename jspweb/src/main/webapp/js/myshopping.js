// $ : jquery 문법

// 현재 page 로드 되는 메소드 
// $( function(){}); 

let orderlist ;  // 주문 제품 리스트 

$( function(){ // 문서가 열렸을때 

	$.ajax({ // 비동기로 주문 제품 리스트 가져오기 
		url : "../product/getorder" , 
		success : function( jsonarray ){
			orderlist = jsonarray;
			view();
		}
	});
	
}); 


// 브라우저내 스크롤 사용 이벤트 
	//	$(window).scroll( function(){ alert("스크롤사용"); });

let count = 2; // 처음에 주문개수 출력하는 변수 

// 스크롤 이벤트 
$(window).scroll( function(){ 
	// 만약에 스크롤이 바닥에 닿았을때 계산 
		// $(window).scroll : 브라우저(인터넷창) 스크롤
		// $(window).scrollTop() : 스크롤막대의 상단 위치
		// $(document).height() : 현재 보고 있는 문서내 높이 
		// $(window).height() : 현재 보고 있는 화면 높이 
	if( $(window).scrollTop() == $(document).height() - $(window).height()  ){
		// 현재 스크롤의 상단 위치  ==  현재 보고 있는 문서내 높이   -  현재 보고 있는 화면 높이 
		count++; // 스크롤 바닥에 닿을때 마다 출력하는 주문개수를 증가
		view(); // 새로고침
	}
});

// 제품리스트를 출력하는 메소드 
function view(){
	let html ;
	for( let i = 0 ; i<count ; i++ ){	// count 개수만큼 제품 수 출력 
		html += 
			'<div class="row"> '+
				'<div class="col-sm-3">'+
					'<span> '+orderlist[i]["orderno"]+' </span>'+
					'<span> '+orderlist[i]["orderdate"]+' </span>'+
				'</div>'+
				'<div class="col-sm-9"> '+
					'<div class="row"> '+
						'<div class="col-sm-8">'+
							'<span> <img width="100%" alt="" src="/jspweb/admin/productimg/'+orderlist[i]["pimg"]+'"></span>'+
							'<span> '+orderlist[i]["pname"]+' </span>'+
							'<span> '+orderlist[i]["scolor"]+'/'+orderlist[i]["ssize"]+'</span>'+
						'</div>'+
						'<div class="col-sm-4">'+
							'<button> 배송조회 </button>'+
							'<button> 교환 , 반품 신청 </button>'+
							'<button> 리뷰 작성하기 </button>'+
						'</div>'+
					'</div>'+
				'</div>'+
			'</div>';
	}
	$("#orderbox").html(html);
}











