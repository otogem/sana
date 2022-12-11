package my.Sana.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.Sana.Mapper.PostFileMapper;
import my.Sana.Mapper.ShopCartMapper;
import my.Sana.Model.PostFileVO;
import my.Sana.Model.ShopCartVO;

@Service
public class ShopCartServiceimpl implements ShopCartService{
	
	@Autowired
	ShopCartMapper scm;
	@Autowired
	PostFileMapper pfm;
	
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
	
	@Override
	public List<ShopCartVO> getCartList(String id){
		
		List<ShopCartVO> cart = scm.getCart(id);
		
		for(ShopCartVO vo : cart) {
			//종합정보 초기화
			vo.initSaleTotal();
			
			//이미지 정보 불러오기
			int product_number = vo.product_number();
			
			List<PostFileVO> imageList = pfm.getAttachList(id);
			
			vo.setImageList(imageList);
		}
		
		return cart;
	}
}
