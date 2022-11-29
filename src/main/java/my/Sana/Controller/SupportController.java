package my.Sana.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import my.Sana.Model.SupportPageSubVO;
import my.Sana.Model.SupportPageVO;
import my.Sana.Service.SupportService;

@Controller
public class SupportController {
	
	@Autowired
	SupportService ss;
	
	//각페이지별 category_number 각페이지별로 부여 이동
	@RequestMapping(value = "/user/support", method = RequestMethod.GET)
	public String writepage(Model model,SupportPageVO spa) {
		String path="";
		if(spa.getSupport_number()==1) {// 만약에 category_number가 1이면
			// 공지사항(post/notice)
			model.addAttribute("list",ss.list(spa));
			path="support/supportmain"; // category1
		}else if(spa.getSupport_number()==2) {	// 만약에 category_number가 2이면
			model.addAttribute("list",ss.list(spa));
			path="postgoods/category2";// category2
		}else if(spa.getSupport_number()==3) {	// 만약에 category_number가 3이면
			model.addAttribute("list",ss.list(spa));
			path="postgoods/category3";// category3
		}else if(spa.getSupport_number()==4) {	// 만약에 category_number가 4이면
			model.addAttribute("list",ss.list(spa));
			path="postgoods/category4";// category4
		}else {// 그렇지 않으면
			model.addAttribute("list",ss.list(spa));
			path="/";// 홈
		}
		//model.addAttribute("list",ss.list(category_number,ppa));
		int total=ss.total(spa);
		model.addAttribute("list",ss.list(spa));
		model.addAttribute("paging",new SupportPageSubVO(spa,total));
		return path;
	}
}
