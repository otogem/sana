package my.Sana.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import my.Sana.Model.PostFileVO;
import my.Sana.Model.PostPageSubVO;
import my.Sana.Model.PostPageVO;
import my.Sana.Model.PostVO;
import my.Sana.Service.PostService;
 
@Controller
public class PostController {
	
	@Autowired
	PostService ps;
	
	//게시판 글쓰기 페이지(화면)
	@RequestMapping(value = "/goods/write", method = RequestMethod.GET)
	public String write(int category_number,Model model) {
		System.out.println(category_number);
		model.addAttribute("category_number", category_number);
		return "postgoods/write";
	}
	
	//각페이지별 category_number 각페이지별로 부여 이동
	//확장을 가능성을 남겨두기위해 50번까진 카테고리 한테 그이후를 백엔드쪽페이지로 넘김
	@RequestMapping(value = "/goods/category", method = RequestMethod.GET)
	public String writepage(Model model,PostPageVO ppa) {
		String path="";
		if(ppa.getCategory_number()==1) {// 만약에 category_number가 1이면
			// 공지사항(post/notice)
			model.addAttribute("list",ps.list(ppa));
			path="postgoods/category1"; // category1
		}else if(ppa.getCategory_number()==2) {	// 만약에 category_number가 2이면
			model.addAttribute("list",ps.list(ppa));
			path="postgoods/category2";// category2
		}else if(ppa.getCategory_number()==3) {	// 만약에 category_number가 3이면
			model.addAttribute("list",ps.list(ppa));
			path="postgoods/category3";// category3
		}else if(ppa.getCategory_number()==4) {	// 만약에 category_number가 4이면
			model.addAttribute("list",ps.list(ppa));
			path="postgoods/category4";// category4
		}else if(ppa.getCategory_number()==5) {	// 만약에 category_number가 5이면
			model.addAttribute("list",ps.list(ppa));
			path="postgoods/category5";// category5
		}else if(ppa.getCategory_number()==6) {	// 만약에 category_number가 6이면
			model.addAttribute("list",ps.list(ppa));
			path="postgoods/category6";// category6
		}else if(ppa.getCategory_number()==7) {	// 만약에 category_number가 7이면
			model.addAttribute("list",ps.list(ppa));
			path="postgoods/category";// category
		}else {// 그렇지 않으면
			model.addAttribute("list",ps.list(ppa));
			path="/";// 홈
		}
		//model.addAttribute("list",ss.list(category_number,ppa));
		int total=ps.total(ppa);
		model.addAttribute("list",ps.list(ppa));
		model.addAttribute("paging",new PostPageSubVO(ppa,total));
		return path;
	}
	
	//게시판 글쓰기 페이지(insert이루어짐.)
	@RequestMapping(value = "/goods/write", method = RequestMethod.POST)
	public String writePost(PostVO post) {
	String writepath="";
	System.out.println(post);
	//비즈니스 영역 연결한 후 postpost 에 있는 write메소드
	if(post.getCategory_number()==1) {// 만약에 category_number가 1이면
		writepath="redirect:/goods/category?category_number=1"; //test catecori 1
	}else if(post.getCategory_number()==2) {	// 만약에 category_number가 2이면
		writepath="redirect:/goods/category?category_number=2";// test catecori 2
	}else if(post.getCategory_number()==3){ 	// 만약에 category_number가 3이면
		writepath="redirect:/goods/category?category_number=3";// test catecori 3
	}else if(post.getCategory_number()==4) {	// 만약에 category_number가 4이면
		writepath="redirect:/goods/category?category_number=4";// test catecori 4
	}else if(post.getCategory_number()==5) {	// 만약에 category_number가 5이면
		writepath="redirect:/goods/category?category_number=5";// test catecori 5
	}else if(post.getCategory_number()==6) {	// 만약에 category_number가 6이면 
		writepath="redirect:/goods/category?category_number=6";// test catecori 6
	}else if(post.getCategory_number()==7) {	// 만약에 category_number가 7이면
		writepath="redirect:/goods/category?category_number=7";// test 고객센터
	}else{
		writepath="redirect:/";
	}
		ps.write(post);
		
		return writepath;
	}
	
	/*상품 상세페이지*/
	@RequestMapping(value="/goods/detail", method = RequestMethod.GET)
	public String detail(PostVO post,Model model) {
		System.out.println(post);
		model.addAttribute("detail",ps.detail(post));
		return "/postgoods/detail";
	}
	
	/* 상품 삭제 */
	@RequestMapping(value="/goods/remove",method = RequestMethod.POST)
	public String remove(int product_number,PostVO post,RedirectAttributes rttr) {
		String removepath="";
		ArrayList<PostFileVO> filelist = ps.filelist(product_number);
		System.out.println(product_number+"번 게시글 삭제");
		if(ps.remove(product_number)) {
			deleteFiles(filelist);
			rttr.addFlashAttribute("result", "success");
		}
		//비즈니스 영역 연결한 후 PostService 에 있는 write메소드
		if(post.getCategory_number()==1) {// 만약에 bgno가 1이면
					// 공지사항(service/notice)
					removepath="redirect:/goods/category?category_number=1";
			}else if(post.getCategory_number()==2) {	// 만약에 bgno가 2이면
					removepath="redirect:/goods/category?category_number=2";
			}else if(post.getCategory_number()==3){// 그렇지 않으면
					removepath="redirect:/goods/category?category_number=3";
			}else if(post.getCategory_number()==4){// 그렇지 않으면
					removepath="redirect:/goods/category?category_number=4";
			}else if(post.getCategory_number()==5){// 그렇지 않으면
					removepath="redirect:/goods/category?category_number=5";
			}else if(post.getCategory_number()==6){// 그렇지 않으면
					removepath="redirect:/goods/category?category_number=6";
			}
		
		return removepath;
	}
	
	//게시글 삭제 실행시 첨부파일 여부에 따른 첨부파일 삭제 
	private void deleteFiles(ArrayList<PostFileVO> filelist) {
		if(filelist == null || filelist.size() == 0) {return;}
		System.out.println("파일 분류실행");	
		filelist.forEach(postfile -> {
			try {
				Path file = Paths.get("D:\\upload\\"+postfile.getUploadPath()+
						"\\"+postfile.getUuid()+"_"+postfile.getFileName());
				Files.deleteIfExists(file);
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumbNail = Paths.get("D:\\upload\\"+postfile.getUploadPath()+
							"\\s_"+postfile.getUuid()+"_"+postfile.getFileName());
					Files.delete(thumbNail);
				}	
			}catch(Exception e) {
				System.out.println("delete file error:"+e.getMessage());
			}
		});
	}
	
	//상품 수정 받기
	@RequestMapping(value = "/goods/modify", method = RequestMethod.GET)
	public String getmodify(PostVO post,Model model) {
		System.out.println("상품 상세 페이지");
		 System.out.println( post);
		model.addAttribute("detail",ps.detail(post));
		return "/postgoods/modify";
	}
	
	/* 상품 수정 보내기*/
    @RequestMapping(value = "/goods/modify", method =  RequestMethod.POST )
    public String postmodify(PostVO post,RedirectAttributes rttr) {		
    System.out.println(post);
	String modipath="";
	if(post.getCategory_number()==1) {// 만약에 bgno가 1이면
		modipath="redirect:/goods/category?category_number=1";
	}else if(post.getCategory_number()==2) {	// 만약에 Category_number가 2이면
		modipath="redirect:/goods/category?category_number=2";
	}else if(post.getCategory_number()==3){		// 만약에 Category_number가 3이면
		modipath="redirect:/goods/category?category_number=3";
	}else if(post.getCategory_number()==4) {	// 만약에 Category_number가 4이면
		modipath="redirect:/goods/category?category_number=4";
	}else if(post.getCategory_number()==5) {	// 만약에 Category_number가 5이면
		modipath="redirect:/goods/category?category_number=5";
	}else if(post.getCategory_number()==6) {	// 만약에 Category_number가 6이면
		modipath="redirect:/goods/category?category_number=6";
	}else if(post.getCategory_number()==7) {	// 만약에 Category_number가 7이면
		modipath="redirect:/goods/category?category_number=7";
	}else{
		modipath="redirect:/";
	}
	
       ps.modify(post);
       rttr.addAttribute("detail",post.getProduct_number());
       return modipath;
    }
    
	//1:1게시물의 첨부파일 데이터 ajax로 전송
	@RequestMapping(value="/filelist",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<PostFileVO>>filelist(int product_number){
		
		return new ResponseEntity<>(ps.filelist(product_number),HttpStatus.OK);
	}
}
