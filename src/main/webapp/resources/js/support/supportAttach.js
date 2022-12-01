/**
 * 
 */

$(document).ready(function(){
	//detail.jsp가 시작되자마자 category_number값 가져오기
	var bno=$("input[name='bno']").val();
	$.getJSON("/spfilelist",{bno:bno},function(spfilelist){
		console.log(spfilelist);
		
		var str="";
		$(spfilelist).each(function(i,file){
			//만약 image결과가 true면
			if(file.image) {
				var filePath=encodeURIComponent(file.uploadPath+"/s_"+file.uuid+"_"+file.fileName);
				str+="<li data-path='"+file.uploadPath+"' data-uuid='"+file.uuid+"' data-fileName='"+file.fileName+"' data-type='"+file.image+"'><div>";
				str+="<img src='/supportdisplay?fileName="+filePath+"'>";
				str+="<a href='/supportdownload?fileName="+filePath+"'>"+file.fileName+"</a></div></li>";
			}else {//그렇지않으면
				var filePath=encodeURIComponent(obj.uploadPath+"/"+file.uuid+"_"+file.fileName)
				var fileLink = filePath.replace(new RegExp(/\\/g), "/");
				
				str+="<li data-path='"+file.uploadPath+"' data-uuid='"+file.uuid+"' data-fileName='"+file.fileName+"' data-type='"+file.image+"'>"
				str+= "<a href='/supportdownload?fileName="+filePath+"'>"+file.fileName+"</a>"
			}
			
			
		})
		$("#uploadResult ul").html(str);
	})
})