package my.Sana.dbtest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import my.Sana.Mapper.ShopCartMapper;
import my.Sana.Model.ShopCartVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ShopCartMapperTests {
	
	@Autowired
	private ShopCartMapper mapper;
	
	@Test
	public void addCartTest() {
		String id="admin";
		int product_number=2;
		int product_count=124124;
		
		ShopCartVO cart = new ShopCartVO();
		cart.setId(id);
		cart.setProduct_number(product_number);
		cart.setProduct_count(product_count);
		
		int result = 0;
		//result = mapper.addCart(cart);
		
		System.out.println("결과 :" + result);
	}
	
	/*카트삭제*/
	@Test
	public void deleteCartTest() {
		int cartid = 1;
		
		mapper.deleteCart(cartid);
	}
	
	/*카트 수량 수정*/
	@Test
	public void modifyCartTest() {
		int cartid = 3;
		int count = 5;
		
		ShopCartVO cart = new ShopCartVO();
		cart.setCartid(cartid);
		cart.setProduct_count(count);
		
		mapper.modifyCount(cart);
	}
	
	/*카트 모곩*/
	@Test
	public void getCartTest() {
		String id = "admin";
		
		List<ShopCartVO> list = mapper.getCart(id);
		for(ShopCartVO cart : list) {
			System.out.println(cart);
			cart.initSaleTotal();
			System.out.println("init cart : " + cart);
		}
	}
	
	/*카트확인*/
	@Test
	public void checkCartTest() {
		
		String id = "admin";
		int product_number = 15;
		
		ShopCartVO cart = new ShopCartVO();
		cart.setId(id);
		cart.setProduct_number(product_number);
		
		ShopCartVO resultCart = mapper.checkCart(cart);
		System.out.println("결과 : "+ resultCart);
	}
}
