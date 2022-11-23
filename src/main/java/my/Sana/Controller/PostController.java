package my.Sana.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String write(int bgno,Model model) {
		System.out.println(bgno);
		model.addAttribute("bgno", bgno);
		return "postgoods/write";
	}
	
	//각페이지별 bgno 각페이지별로 부여 이동
	//확장을 가능성을 남겨두기위해 50번까진 카테고리 한테 그이후를 백엔드쪽페이지로 넘김
	@RequestMapping(value = "/goods/category", method = RequestMethod.GET)
	public String writepage(Model model,PostPageVO ppa) {
		String path="";
		if(ppa.getBgno()==1) {// 만약에 bgno가 1이면
			// 공지사항(post/notice)
			model.addAttribute("list",ps.list(ppa));
			path="postgoods/category1"; // category1
		}else if(ppa.getBgno()==2) {	// 만약에 bgno가 2이면
			model.addAttribute("list",ps.list(ppa));
			path="postgoods/category2";// category2
		}else if(ppa.getBgno()==3) {	// 만약에 bgno가 3이면
			model.addAttribute("list",ps.list(ppa));
			path="postgoods/category3";// category3
		}else if(ppa.getBgno()==4) {	// 만약에 bgno가 4이면
			model.addAttribute("list",ps.list(ppa));
			path="postgoods/category4";// category4
		}else if(ppa.getBgno()==5) {	// 만약에 bgno가 5이면
			model.addAttribute("list",ps.list(ppa));
			path="postgoods/category5";// category5
		}else if(ppa.getBgno()==6) {	// 만약에 bgno가 6이면
			model.addAttribute("list",ps.list(ppa));
			path="postgoods/category6";// category6
		}else if(ppa.getBgno()==7) {	// 만약에 bgno가 7이면
			model.addAttribute("list",ps.list(ppa));
			path="postgoods/category";// category
		}else {// 그렇지 않으면
			model.addAttribute("list",ps.list(ppa));
			path="/";// 홈
		}
		//model.addAttribute("list",ss.list(bgno,ppa));
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
	if(post.getBgno()==1) {// 만약에 bgno가 1이면
		writepath="redirect:/goods/category?bgno=1"; //test catecori 1
	}else if(post.getBgno()==2) {	// 만약에 bgno가 2이면
		writepath="redirect:/goods/category?bgno=2";// test catecori 2
	}else if(post.getBgno()==3){ 	// 만약에 bgno가 3이면
		writepath="redirect:/goods/category?bgno=3";// test catecori 3
	}else if(post.getBgno()==4) {	// 만약에 bgno가 4이면
		writepath="redirect:/goods/category?bgno=4";// test catecori 4
	}else if(post.getBgno()==5) {	// 만약에 bgno가 5이면
		writepath="redirect:/goods/category?bgno=5";// test catecori 5
	}else if(post.getBgno()==6) {	// 만약에 bgno가 6이면 
		writepath="redirect:/goods/category?bgno=6";// test catecori 6
	}else if(post.getBgno()==7) {	// 만약에 bgno가 7이면
		writepath="redirect:/goods/bkind?bgno=7";// test 고객센터
	}else{
		writepath="redirect:/";
	}
		ps.write(post);
		
		return writepath;
	}
	
	@RequestMapping(value="/goods/detail", method = RequestMethod.GET)
	public String detail(PostVO post,Model model) {
		System.out.println(post);
		model.addAttribute("detail",ps.detail(post));
		return "/postgoods/detail";
	}
	
	/* 게시글 삭제 */
	@RequestMapping(value="/service/remove",method = RequestMethod.POST)
	public String remove(int bno,PostVO post,RedirectAttributes rttr) {
		String removepath="";
//		ArrayList<ServiceFileListVO> filelist = ps.filelist(bno);
		System.out.println(bno+"번 게시글 삭제");
		if(ps.remove(bno)) {
			//deleteFiles(filelist);
			rttr.addFlashAttribute("result", "success");
		}
		//비즈니스 영역 연결한 후 PostService 에 있는 write메소드
		if(post.getBgno()==1) {// 만약에 bgno가 1이면
					// 공지사항(service/notice)
					removepath="redirect:/goods/category?bgno=1";
			}else if(post.getBgno()==2) {	// 만약에 bgno가 2이면
					removepath="redirect:/goods/category?bgno=2";
			}else if(post.getBgno()==3){// 그렇지 않으면
					removepath="redirect:/goods/category?bgno=3";
			}else if(post.getBgno()==4){// 그렇지 않으면
					removepath="redirect:/goods/category?bgno=4";
			}else if(post.getBgno()==5){// 그렇지 않으면
					removepath="redirect:/goods/category?bgno=5";
			}else if(post.getBgno()==6){// 그렇지 않으면
					removepath="redirect:/goods/category?bgno=6";
			}
		
		return removepath;
	}
}
