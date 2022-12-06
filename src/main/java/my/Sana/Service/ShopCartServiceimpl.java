package my.Sana.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.Sana.Mapper.ShopCartMapper;
import my.Sana.Model.ShopCartVO;

@Service
public class ShopCartServiceimpl implements ShopCartService{
	
	@Autowired
	ShopCartMapper scm;
	
	@Override
	public int addCart(ShopCartVO cart) {
		//장바구니 데이터 체크
		ShopCartVO checkCart = scm.checkCart(cart);
		
		if(checkCart != null) {
			return 2;
		}
		
		//장바구니 등록 & 에러 시 0반환
		try {
			return scm.addCart(cart);
		} catch (Exception e) {
			return 0;
		}
	}
}
