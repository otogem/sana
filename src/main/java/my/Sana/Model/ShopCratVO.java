package my.Sana.Model;

public class ShopCratVO {
	//장바구니 상품 분류 번호
	private int cartid;
	//상품 개수
	private int product_count;
	//아이디
	private String id;
	//상품번호
	private int product_number;
	
	//상품이름
	private String product_name;
	//상품 가격
	private int product_price;
	//상품 할인
	private int product_discount;
	
	//추가
	//할인률
	private int salePrice;
	//판매가격에 수량을 곱한 총가격
	private int totalPrice;
	
	//변수값을 초기화 해주는 메서드
	public void initTotal() {
		this.salePrice = (int) (this.product_price * (1-this.product_discount));
		this.totalPrice = this.salePrice*this.product_count;
	}
	
	
	public int getProduct_discount() {
		return product_discount;
	}


	public void setProduct_discount(int product_discount) {
		this.product_discount = product_discount;
	}


	public int getSalePrice() {
		return salePrice;
	}


	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}


	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getProduct_count() {
		return product_count;
	}

	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getProduct_number() {
		return product_number;
	}

	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ShopCratVO [cartid=" + cartid + ", product_count=" + product_count + ", id=" + id + ", product_number="
				+ product_number + ", product_name=" + product_name + ", product_price=" + product_price
				+ ", product_discount=" + product_discount + ", salePrice=" + salePrice + ", totalPrice=" + totalPrice
				+ "]";
	}
	
	
}
