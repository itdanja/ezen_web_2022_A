// $ : jquery 문법

// 현재 page 로드 되는 메소드 
// $( function(){}); 

let orderlist ; 

$( function(){
	$.ajax({
		url : "../product/getorder" , 
		success : function( jsonarray ){
			orderlist = jsonarray;
			view();
		}
	});
}); 

function view(){
	
	let html ;
	
	for( let i = 0 ; i<orderlist.length ; i++ ){
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











