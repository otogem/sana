package my.Sana.Model;

import java.util.List;

public class ShopCartVO {
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
	private double product_discount;
	
	//상품이미지
	private List<PostFileVO> imageList;
	
	//추가
	//할인률
	private int salePrice;
	//판매가격에 수량을 곱한 총가격
	private int totalPrice;
	//포인트
	private int point;
	//총합 포인트
	private int totalpoint;
	
	//변수값을 초기화 해주는 메서드
	public void initSaleTotal() {
		this.salePrice = (int) (this.product_price * (1-this.product_discount));
		this.totalPrice = this.salePrice*this.product_count;
		this.point = (int) (Math.floor(this.salePrice*0.05));
		this.totalpoint = this.point * this.product_count;
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

	public double getProduct_discount() {
		return product_discount;
	}

	public void setProduct_discount(double product_discount) {
		this.product_discount = product_discount;
	}

	public List<PostFileVO> getImageList() {
		return imageList;
	}

	public void setImageList(List<PostFileVO> imageList) {
		this.imageList = imageList;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getTotalpoint() {
		return totalpoint;
	}

	public void setTotalpoint(int totalpoint) {
		this.totalpoint = totalpoint;
	}

	@Override
	public String toString() {
		return "ShopCartVO [cartid=" + cartid + ", product_count=" + product_count + ", id=" + id + ", product_number="
				+ product_number + ", product_name=" + product_name + ", product_price=" + product_price
				+ ", product_discount=" + product_discount + ", imageList=" + imageList + ", salePrice=" + salePrice
				+ ", totalPrice=" + totalPrice + ", point=" + point + ", totalpoint=" + totalpoint + "]";
	}




	
	
}
