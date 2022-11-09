package my.Sana.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import my.Sana.Model.MemberVO;
import my.Sana.Service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService ms;
	
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
	//user 회원가입 정보 전송
	@RequestMapping(value="/member/mbuser",method = RequestMethod.POST)
	public String userpost(MemberVO member) {
		
		ms.mbuser(member);
		
		return "redirect:/member/mblogin";
	}
	
	@ResponseBody
	@RequestMapping(value="idCheck",method = RequestMethod.GET)
	public int overID(MemberVO member) {
		int result = MemberService.overID(member);
		return result;
	}
}
