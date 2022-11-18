package my.Sana.Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import my.Sana.Mapper.MemberMapper;
import my.Sana.Model.MemberVO;
import my.Sana.Service.MemberService;
import my.Sana.Service.MemberServiceimpl;

@Controller
public class MemberController {
	
	@Autowired
	MemberService ms;
	@Autowired
	MemberServiceimpl msi;
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
	
	@RequestMapping(value = "/login/getKakaoAuthUrl")
	public @ResponseBody String getKakaoAuthUrl(
			HttpServletRequest request) throws Exception {
		String reqUrl = 
				"https://kauth.kakao.com/oauth/authorize"
				+ "?client_id=44daa6a53ff644904c893b155d273e0a"
				+ "&redirect_uri=http://localhost:8080/member/kakaolog"
				+ "&response_type=code";
		
		return reqUrl;
	}
	
	// 카카오 연동정보 조회
	@RequestMapping(value = "/member/kakaolog")
	public String oauthKakao(
			@RequestParam(value = "code", required = false) String code
			, Model model, HttpSession session) throws Exception {

		System.out.println("#########" + code);
        String access_Token = msi.getAccessToken(code);
        System.out.println("###access_Token#### : " + access_Token);
        
        
        HashMap<String, Object> userInfo = msi.getUserInfo(access_Token);
        System.out.println("###access_Token#### : " + access_Token);
        System.out.println("###nickname#### : " + userInfo.get("nickname"));
       
        JSONObject kakaoInfo =  new JSONObject(userInfo);
        model.addAttribute("kakaoInfo", kakaoInfo);
        
        if(kakaoInfo.get("nickname") != null) {
        	session.setAttribute("kakaoInfo.nickname", kakaoInfo.get("nickname"));
        	session.setAttribute("access_Token", access_Token);
        }
        
        return "/home"; //본인 원하는 경로 설정
	}
	
	//로그아웃
    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        String access_Token = (String)session.getAttribute("access_Token");

        if(access_Token != null && !"".equals(access_Token)){
            msi.kakaoLogout(access_Token);
            session.removeAttribute("access_Token");
            session.removeAttribute("kakaoInfo.nickname");
        }else{
            System.out.println("access_Token is null");
            //return "redirect:/";
        }
        //return "index";
        return "redirect:/";
    }
	

}
