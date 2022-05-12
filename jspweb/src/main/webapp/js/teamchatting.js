


$(function(){
    $('#uploadBtn').on('click', function(){
        uploadFile();
    });
});
 
function uploadFile(){
    var form = $('#uploadForm');
    var formData = new FormData(form);
    $.ajax({
        url : 'filesend',
        type : 'POST',
        data : formData,
        contentType : false,
        processData : false,
        success : function( result ){ 
			$("#file").val("");
		}  
    });
}


function send(){
	let nicname = $("#nicname").val();
	let content = $("#content").val();
	let ip = $("#ip").html();
	$.ajax({ 
		url : "send",
		data : { "nicname" : nicname , "content" : content , "ip" : ip  },
		success : function( result ){
			$("#nicname").val("");
			$("#content").val("");
		}
	});
}

/* 특정 시간만큼 반복되는 함수 */
$(function() {
	timer = setInterval( function () {
	    $.ajax ({
	        url : "receive",
	        cache : false,
	        success : function ( result ) {
		        var co =  result.split(",");
		        var contents = "";
		        for( var i = 0 ; i<co.length-1 ; i++ ){
					
					let ip = $("#ip").html();
					
					if(  co[i].split("^")[0] != "x"){
						contents += 
						'<img class="img" alt="" src="/jspweb/board/upload/'+co[i].split("^")[0]+'">'
					}
					
					if( co[i].split("^")[3]!="x" && co[i].split("^")[2] == ip ){
						contents += 
					 '<div class="box"  style="text-align: right;">'+
						'<div class="nicname">'+co[i].split("^")[3]+'</div>'+
						'<span class="date">'+co[i].split("^")[1].split(" ")[1]+'</span>'+
						'<span class="content">'+co[i].split("^")[4]+'</span>'+
						
					'</div>'
					}else if( co[i].split("^")[3]!="x" ) {
						contents += 
					 '<div class="box">'+
						'<div class="nicname">'+co[i].split("^")[3]+'</div>'+
						'<span class="content">'+co[i].split("^")[4]+'</span>'+
						'<span class="date">'+co[i].split("^")[1].split(" ")[1]+'</span>'+
					'</div>'
					}
				}
				$("#contentlist").html( contents );
    			$('#contentlist').scrollTop($('#contentlist')[0].scrollHeight);
	        }
	    });
	    }, 1500);
});










