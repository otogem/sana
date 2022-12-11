package my.Sana.Mapper;

import java.util.List;

import my.Sana.Model.ShopCartVO;

public interface ShopCartMapper {
	
	/* 카트 추가 */
	public int addCart(ShopCartVO cart) throws Exception;
	
	/* 카트 삭제 */
	public int deleteCart(int cartid);
	
	/* 카트 수량 수정 */
	public int modifyCount(ShopCartVO cart);
	
	/* 카트 목록 */
	public List<ShopCartVO> getCart(String id);	
	
	/* 카트 확인 */
	public ShopCartVO checkCart(ShopCartVO cart);
}
