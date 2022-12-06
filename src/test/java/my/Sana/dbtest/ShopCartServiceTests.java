package my.Sana.dbtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import my.Sana.Model.ShopCartVO;
import my.Sana.Service.ShopCartService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ShopCartServiceTests {
	
	@Autowired
	private ShopCartService service;
	
	//등록 테스트
	@Test
	public void addCartTest() {
		//given
			String Id = "admin";
			int product_number = 22;
			int product_count = 7;
			
			ShopCartVO dto = new ShopCartVO(); 
			dto.setId(Id);
			dto.setProduct_number(product_number);
			dto.setProduct_count(product_count);
		
		//when
			int result = service.addCart(dto);
		
		//then
			System.out.println("** result : " + result);
		
		
	}
 
}
