package my.Sana.Mapper;

import java.util.List;

import my.Sana.Model.ShopCratVO;

public interface ShopCartMapper {
	
	/* 카트 추가 */
	public int addCart(ShopCratVO cart);
	
	/* 카트 삭제 */
	public int deleteCart(int cartId);
	
	/* 카트 수량 수정 */
	public int modifyCount(ShopCratVO cart);
	
	/* 카트 목록 */
	public List<ShopCratVO> getCart(String Id);	
	
	/* 카트 확인 */
	public ShopCratVO checkCart(ShopCratVO cart);
}
