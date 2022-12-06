package my.Sana.Service;

import org.springframework.stereotype.Service;

import my.Sana.Model.ShopCartVO;

@Service
public interface ShopCartService {
	/* 장바구니 추가 */
	public int addCart(ShopCartVO cart);
}
