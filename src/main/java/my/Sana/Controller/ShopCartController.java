package my.Sana.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		System.out.println(cart);
		return result + "";
	}
	
	//장바구니 아이디별 페이지
	@GetMapping("/cart/{id}")
	public String CartPageGet(@PathVariable("id") String id, Model model) {
		
		model.addAttribute("cart", scs.getCartList(id));
		
		return "/cart/cart";
	}
	
	//장바구니 수량 수정 post
	@PostMapping("/cart/update")
	public String updateCartPost(ShopCartVO cart) {
		
		scs.modifyCount(cart);
		
		return "redirect:/cart/" + cart.getId();
	}
	
	// 장바구니 삭제 post
	@PostMapping("/cart/delete")
	public String deleteCartPOST(ShopCartVO cart) {
		System.out.println("실행됨?");
		scs.deleteCart(cart.getCartid());
		
		return "redirect:/cart/" + cart.getId();
		
	}
}
