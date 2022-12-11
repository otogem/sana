package my.Sana.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import my.Sana.Model.ShopCartVO;

@Service
public interface ShopCartService {
	
	/* 장바구니 추가 */
	public int addCart(ShopCartVO cart);
	
	/* 장바구니 정보 리스트*/
	public List<ShopCartVO> getCartList(String id);
}
