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

import my.Sana.Model.SupportVO;
import my.Sana.Model.SupportFileVO;
import my.Sana.Model.SupportPageSubVO;
import my.Sana.Model.SupportPageVO;
import my.Sana.Service.SupportService;

@Controller
public class SupportController {
	
	@Autowired
	SupportService ss;
	
	//게시판 글쓰기 페이지(화면)
	@RequestMapping(value = "/support/write", method = RequestMethod.GET)
	public String write(int support_number,Model model) {
		System.out.println(support_number);
		model.addAttribute("support_number", support_number);
		return "support/supportwrite";
	}
	
	//각페이지별 support_number 각페이지별로 부여 이동
	@RequestMapping(value = "/support/main", method = RequestMethod.GET)
	public String writepage(Model model,SupportPageVO spa) {
		String path="";
		if(spa.getSupport_number()==1) {// 만약에 support_number가 1이면
			// 공지사항(support/notice)
			model.addAttribute("list",ss.list(spa));
			path="support/supportmain"; // category1
		}else if(spa.getSupport_number()==2) {	// 만약에 support_number가 2이면
			model.addAttribute("list",ss.list(spa));
			path="supportgoods/category2";// category2
		}else if(spa.getSupport_number()==3) {	// 만약에 support_number가 3이면
			model.addAttribute("list",ss.list(spa));
			path="supportgoods/category3";// category3
		}else if(spa.getSupport_number()==4) {	// 만약에 support_number가 4이면
			model.addAttribute("list",ss.list(spa));
			path="supportgoods/category4";// category4
		}else {// 그렇지 않으면
			model.addAttribute("list",ss.list(spa));
			path="/";// 홈
		}
		//model.addAttribute("list",ss.list(support_number,ppa));
		int total=ss.total(spa);
		model.addAttribute("list",ss.list(spa));
		model.addAttribute("paging",new SupportPageSubVO(spa,total));
		return path;
	}
	
	//게시판 글쓰기 페이지(insert이루어짐.)
		@RequestMapping(value = "/support/write", method = RequestMethod.POST)
		public String writesupport(SupportVO support) {
		String writepath="";
		System.out.println("3"+support);
		//비즈니스 영역 연결한 후 supportsupport 에 있는 write메소드
		if(support.getSupport_number()==1) {// 만약에 support_number가 1이면
			writepath="redirect:/support/main?support_number=1"; //test catecori 1
		}else if(support.getSupport_number()==2) {	// 만약에 support_number가 2이면
			writepath="redirect:/goods/category?support_number=2";// test catecori 2
		}else if(support.getSupport_number()==3){ 	// 만약에 support_number가 3이면
			writepath="redirect:/goods/category?support_number=3";// test catecori 3
		}else if(support.getSupport_number()==4) {	// 만약에 support_number가 4이면
			writepath="redirect:/goods/category?support_number=4";// test catecori 4
		}else if(support.getSupport_number()==5) {	// 만약에 support_number가 5이면
			writepath="redirect:/goods/category?support_number=5";// test catecori 5
		}else if(support.getSupport_number()==6) {	// 만약에 support_number가 6이면 
			writepath="redirect:/goods/category?support_number=6";// test catecori 6
		}else if(support.getSupport_number()==7) {	// 만약에 support_number가 7이면
			writepath="redirect:/goods/category?support_number=7";// test 고객센터
		}else{
			writepath="redirect:/";
		}
			ss.write(support);
			
			return writepath;
		}
		
		/*상품 상세페이지*/
		@RequestMapping(value="/support/detail", method = RequestMethod.GET)
		public String detail(SupportVO support,Model model) {
			System.out.println("상세"+support);
			model.addAttribute("detail",ss.detail(support));
			return "/support/supportdetail";
		}
		
		/* 상품 삭제 */
		@RequestMapping(value="/support/remove",method = RequestMethod.POST)
		public String remove(int bno,SupportVO support,RedirectAttributes rttr) {
			String removepath="";
			ArrayList<SupportFileVO> spfilelist = ss.spfilelist(bno);
			System.out.println(bno+"번 게시글 삭제");
			if(ss.remove(bno)) {
				deleteFiles(spfilelist);
				rttr.addFlashAttribute("result", "success");
			}
			//비즈니스 영역 연결한 후 supportService 에 있는 write메소드
			if(support.getSupport_number()==1) {// 만약에 support_number가 1이면
						removepath="redirect:/support/main?support_number=1";
				}else if(support.getSupport_number()==2) {	// 만약에 support_number가 2이면
						removepath="redirect:/goods/category?support_number=2";
				}else if(support.getSupport_number()==3){	// 만약에 support_number가 3이면
						removepath="redirect:/goods/category?support_number=3";
				}else if(support.getSupport_number()==4){	// 만약에 support_number가 4이면
						removepath="redirect:/goods/category?support_number=4";
				}else if(support.getSupport_number()==5){	// 만약에 support_number가 5이면
						removepath="redirect:/goods/category?support_number=5";
				}else if(support.getSupport_number()==6){	// 만약에 support_number가 6이면
						removepath="redirect:/goods/category?support_number=6";
				}
			
			return removepath;
		}
		
		//게시글 삭제 실행시 첨부파일 여부에 따른 첨부파일 삭제 
		private void deleteFiles(ArrayList<SupportFileVO> spfilelist) {
			if(spfilelist == null || spfilelist.size() == 0) {return;}
			System.out.println("파일 분류실행");	
			spfilelist.forEach(supportfile -> {
				try {
					Path file = Paths.get("D:\\spupload\\"+supportfile.getUploadPath()+
							"\\"+supportfile.getUuid()+"_"+supportfile.getFileName());
					Files.deleteIfExists(file);
					if(Files.probeContentType(file).startsWith("image")) {
						Path thumbNail = Paths.get("D:\\spupload\\"+supportfile.getUploadPath()+
								"\\s_"+supportfile.getUuid()+"_"+supportfile.getFileName());
						Files.delete(thumbNail);
					}	
				}catch(Exception e) {
					System.out.println("delete file error:"+e.getMessage());
				}
			});
		}
		
		//상품 수정 받기
		@RequestMapping(value = "/support/modify", method = RequestMethod.GET)
		public String getmodify(SupportVO support,Model model) {
			System.out.println("상품 상세 페이지");
			 System.out.println("상품수정"+support);
			model.addAttribute("detail",ss.detail(support));
			return "/support/supportmodify";
		}
		
		/* 상품 수정 보내기*/
	    @RequestMapping(value = "/support/modify", method =  RequestMethod.POST )
	    public String supportmodify(SupportVO support,RedirectAttributes rttr) {		
	    System.out.println("상품수정보내기"+support);
		String modipath="";
		if(support.getSupport_number()==1) {// 만약에 support_number가 1이면
			modipath="redirect:/support/main?support_number=1";
		}else if(support.getSupport_number()==2) {	// 만약에 support_number가 2이면
			modipath="redirect:/goods/category?support_number=2";
		}else if(support.getSupport_number()==3){		// 만약에 support_number가 3이면
			modipath="redirect:/goods/category?support_number=3";
		}else if(support.getSupport_number()==4) {	// 만약에 support_number가 4이면
			modipath="redirect:/goods/category?support_number=4";
		}else if(support.getSupport_number()==5) {	// 만약에 support_number가 5이면
			modipath="redirect:/goods/category?support_number=5";
		}else if(support.getSupport_number()==6) {	// 만약에 support_number가 6이면
			modipath="redirect:/goods/category?support_number=6";
		}else if(support.getSupport_number()==7) {	// 만약에 support_number가 7이면
			modipath="redirect:/goods/category?support_number=7";
		}else{
			modipath="redirect:/";
		}
		
	       ss.modify(support);
	       rttr.addAttribute("detail",support.getBno());
	       return modipath;
	    }
	    
		//1:1게시물의 첨부파일 데이터 ajax로 전송
		@RequestMapping(value="/spfilelist",method=RequestMethod.GET)
		public ResponseEntity<ArrayList<SupportFileVO>>spfilelist(int bno){
			
			return new ResponseEntity<>(ss.spfilelist(bno),HttpStatus.OK);
		}
}
