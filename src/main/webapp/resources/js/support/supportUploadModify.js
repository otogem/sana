/**
 * 
 */

		$(document).ready(function(){
			//수정 파트 업로드 파일 삭제
			(function(){
				var bno=$("input[name='bno']").val();
				$.getJSON("/spfilelist",{bno:bno},function(spfilelist){
					console.log(spfilelist);
					
					var str="";
					$(spfilelist).each(function(i,file){
					//image type
					if(file.image){
						var filePath=encodeURIComponent(file.uploadPath+"/s_"+file.uuid+"_"+file.fileName);
						str+="<li data-path='"+file.uploadPath+"' data-uuid='"+file.uuid+"' data-fileName='"+file.fileName+"' data-type='"+file.image+"'><div>";
						str+="<img src='/supportdisplay?fileName="+filePath+"'>";
						str+="<span>"+file.fileName+"</span>";
						str+="<button data-file=\'"+ filePath+"\' data-type='image'>삭제</button></div></li>";
					}else{
						//var filePath=encodeURIComponent(obj.uploadPath+"/"+file.uuid+"_"+file.fileName)
						//var fileLink = filePath.replace(new RegExp(/\\/g), "/");
						
						str+="<li data-path='"+file.uploadPath+"' data-uuid='"+file.uuid+"' data-fileName='"+file.fileName+"' data-type='"+file.image+"'>"
						str+= "<a href='/supportdownload?fileName="+filePath+"'>"+file.fileName+"</a>"
						str+="<span>"+file.fileName+"</span>";
						str+="<button data-file=\'"+ filePath+"\' data-type='image'>삭제</button></div></li>";
					}
				});
				$("#uploadResult ul").html(str);
			}); // end getJson
			})();
			
			var formObj = $("form");
			$('#uploadBtn').on("click", function(e){
				e.preventDefault();
				var operation = $(this).data("oper");
				console.log(operation);
				
				if(oparation === 'supportmodify'){
					console.log("submit clicked");
				}					$("#uploadResult ul li").each(function(i,file){
					var jfile=$(file);
					console.log(jfile.data);
					
					str += "<input type = 'hidden' name = 'supportfile["+i+"].fileName' value = '" + jfile.data("filename")+"'>";
					str += "<input type = 'hidden' name = 'supportfile["+i+"].uuid' value = '" + jfile.data("uuid") + "'>";
					str += "<input type = 'hidden' name = 'supportfile["+i+"].uploadPath' value = '" + jfile.data("path") + "'>";
					str += "<input type = 'hidden' name = 'supportfile["+i+"].image' value = '" + jfile.data("type") + "'>";
				});
				formObj.append(str).submit();
			})	
			
		});