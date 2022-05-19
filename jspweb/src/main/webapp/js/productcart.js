$( function(){  
	$.ajax({
		url : 'getcart' ,
		success : function( jsonarray ){
			
			// js : json 객체내 key값 이용한 value 추출 
				// 객체명[key] -> value 호출 
				// jsonarray[i][key] -> json배열내 i번째 객체의 key 값 호출 
			let tr = "";
			for( let i = 0 ; i<jsonarray.length; i++ ){
				tr += 
				'<tr>'+
					'<td width="5%"><img width="100%" alt="" src="../admin/productimg/'+jsonarray[i]['pimg']+'"></td>'+
					'<td> '+jsonarray[i]['pname']+' <br>'+jsonarray[i]['scolor']+'/'+jsonarray[i]['ssize']+'</td>'+
					'<td> '+jsonarray[i]['totalprice']+'  </td>'+
					'<td> <button>X</button> </td>'+
				'</tr>'
			}
			$("#carttable").html( tr );
		}
	});
});