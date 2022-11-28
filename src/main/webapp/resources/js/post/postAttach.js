/**
 * 첨부파일 관련 js
 */


$(document).ready(function(){
	//detail.jsp가 시작되자마자 category_number값 가져오기
	var product_number=$("input[name='product_number']").val();
	$.getJSON("/filelist",{product_number:product_number},function(filelist){
		console.log(filelist);
		
		var str="";
		$(filelist).each(function(i,file){
			//만약 image결과가 true면
			if(file.image) {
				var filePath=encodeURIComponent(file.uploadPath+"/s_"+file.uuid+"_"+file.fileName);
				str+="<li data-path='"+file.uploadPath+"' data-uuid='"+file.uuid+"' data-fileName='"+file.fileName+"' data-type='"+file.image+"'><div>";
				str+="<img src='/postdisplay?fileName="+filePath+"'>";
				str+="<a href='/postdownload?fileName="+filePath+"'>"+file.fileName+"</a></div></li>";
			}else {//그렇지않으면
				var filePath=encodeURIComponent(obj.uploadPath+"/"+file.uuid+"_"+file.fileName)
				var fileLink = filePath.replace(new RegExp(/\\/g), "/");
				
				str+="<li data-path='"+file.uploadPath+"' data-uuid='"+file.uuid+"' data-fileName='"+file.fileName+"' data-type='"+file.image+"'>"
				str+= "<a href='/postdownload?fileName="+filePath+"'>"+file.fileName+"</a>"
			}
			
			
		})
		$("#uploadResult ul").html(str);
	})
})