package my.Sana.Controller;


import org.jht.service.memberService;
import org.jsh.Model.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MemberController {
	//로그인 페이지
	@RequestMapping(value="/member/mblogin",method = RequestMethod.GET)
	public String login() {
		return "/member/mblogin";
	}
	//회원가입 페이지
	@RequestMapping(value="/member/mbuser",method = RequestMethod.GET)
	public String user() {
		return "/member/mbuser";
	}
	
//	@Autowired
//	memberService ms;
//	//회원가입
//	@RequestMapping(value = "/member/memberjoin", method = RequestMethod.GET)
//	public String join() {
//		return "member/memberjoin";
//	}
//	
//	@RequestMapping(value = "/member/memberjoin", method = RequestMethod.POST)
//	public String joinpost(MemberVo member) {
//		
//		ms.memberjoin(member);
//		
//		return "redirect:/member/memberlogin";
//	}
//	
//	//로그인
//	@RequestMapping(value = "/member/memberlogin", method = RequestMethod.GET)
//	public String login() {
//		return "member/memberlogin";
//	}
//	//회원리스트
//	@RequestMapping(value = "/member/memberList", method = RequestMethod.GET)
//	public String list(Model model) {
//		model.addAttribute("list",ms.list());
//		//board폴더 안에 있는 boardlist.jsp 실행
//		return "member/memberList";
//	}
//	//회원관리페이지
//	@RequestMapping(value = "/member/memberdetail", method = RequestMethod.GET)
//	public String detail(MemberVo memver,Model model) {
//		model.addAttribute("detail",ms.detail(memver));
//		return "member/memberdetail";
//	}
//	//회원정보수정
//	@RequestMapping(value ="/member/membermodify", method = RequestMethod.POST)
//	public String moidfy(MemberVo member,RedirectAttributes rttr) {
//		ms.modify(member);
//		rttr.addAttribute("id",member.getId());
//		return "redirect:/member/memberdetail";
//	}
//	//회원정보삭제
//	@RequestMapping(value ="/member/memberdelete", method = RequestMethod.POST)
//	public String delete(MemberVo member) {
//		ms.delete(member);
//		return "redirect:/member/memberList";
//	}
}
