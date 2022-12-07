package my.Sana.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import my.Sana.Model.MemberVO;
import my.Sana.Model.ShopCartVO;
import my.Sana.Service.ShopCartService;

@Controller
public class ShopCartController {
	
	@Autowired
	ShopCartService scs;
	
	@PostMapping("/cart/add")
	@ResponseBody
	public String addCartPOST(ShopCartVO cart, HttpServletRequest request) {
		// 로그인 체크
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("mbloginpost");

		if(mvo == null) {
			return "5";
		}
		//카트 등록
		int result = scs.addCart(cart);
		return result + "";
	}
	
	@GetMapping("/cart/add")
	public String addCartGet(ShopCartVO cart, Model model) {
		return "/cart/add";
	}
}
