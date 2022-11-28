/**
 * 
 */

		$(document).ready(function(){
			//파일 보여주는 파트
			(function(){
				var product_number=$("input[name='product_number']").val();
				$.getJSON("/filelist",{product_number:product_number},function(filelist){
					console.log(filelist);
					
					var str="";
					$(filelist).each(function(i,file){
					//image type
					if(file.image){
						var filePath=encodeURIComponent(file.uploadPath+"/s_"+file.uuid+"_"+file.fileName);
						str+="<li data-path='"+file.uploadPath+"' data-uuid='"+file.uuid+"' data-fileName='"+file.fileName+"' data-type='"+file.image+"'><div>";
						str+="<img src='/postdisplay?fileName="+filePath+"'>";
						str+="<span>"+file.fileName+"</span>";
						str+="<button data-file=\'"+ filePath+"\' data-type='image'>삭제</button></div></li>";
					}else{
						//var filePath=encodeURIComponent(obj.uploadPath+"/"+file.uuid+"_"+file.fileName)
						//var fileLink = filePath.replace(new RegExp(/\\/g), "/");
						
						str+="<li data-path='"+file.uploadPath+"' data-uuid='"+file.uuid+"' data-fileName='"+file.fileName+"' data-type='"+file.image+"'>"
						str+= "<a href='/postdownload?fileName="+filePath+"'>"+file.fileName+"</a>"
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
				
				if(oparation === 'modify'){
					console.log("submit clicked");
				}					$("#uploadResult ul li").each(function(i,file){
					var jfile=$(file);
					console.log(jfile.data);
					
					str += "<input type = 'hidden' name = 'svfile["+i+"].fileName' value = '" + jfile.data("filename")+"'>";
					str += "<input type = 'hidden' name = 'svfile["+i+"].uuid' value = '" + jfile.data("uuid") + "'>";
					str += "<input type = 'hidden' name = 'svfile["+i+"].uploadPath' value = '" + jfile.data("path") + "'>";
					str += "<input type = 'hidden' name = 'svfile["+i+"].image' value = '" + jfile.data("type") + "'>";
				});
				formObj.append(str).submit();
			})	
			
		});