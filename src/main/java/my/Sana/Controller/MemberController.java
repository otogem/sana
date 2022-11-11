package my.Sana.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import my.Sana.Mapper.MemberMapper;
import my.Sana.Model.MemberVO;
import my.Sana.Service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService ms;
	@Autowired
	MemberMapper mm;
	
	//로그인 페이지
	@GetMapping("/member/mblogin")
	public String mblogin() {
		return "/member/mblogin";
	}
	//로그인 값 보내고 세션 유지
	@PostMapping("/member/mblogin")
	public String mbloginpost(MemberVO member, HttpServletRequest request) {
		MemberVO mbloginpost = mm.mbloginpost(member);
		HttpSession session = request.getSession();
		if(mbloginpost != null) {
			session.setAttribute("mbloginpost", mbloginpost);
			return "redirect:/";
		}else {
			session.setAttribute("mblogin", null);
			return "redirect:/member/mblogin";
		}
	}
	
	//로그아웃
	@GetMapping("/member/mbout")
	public String mbout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
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
	//id의중복확인값 전송용 컨트롤
	@RequestMapping(value="/member/idCheck",method = RequestMethod.POST)
	public 	@ResponseBody int overID(String id) {
		int result = mm.overID(id);
		return result;
	}
}
