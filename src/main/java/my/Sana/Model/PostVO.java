package my.Sana.Model;

import java.util.ArrayList;


public class PostVO {
	//가상번호(rownum)
	private int rownum;
	//상품번호(product_number)
	private int product_number;
	//제목(product_name)
	private String product_name;
	//내용(product_desc)
	private String product_desc;
	//작성일자(product_date)
	private String product_date;
	//조회수(product_cnt)
	private int product_cnt;
	//게시판 분류(category_number)
	private int category_number;
	//가격(product_price)
	private int product_price;
	//재고 수량(product_stock)
	private int product_stock;
	//업로드 파일
	private String filem;
	//PostFileVO(파일 업로드 관련 model)
	private ArrayList<PostFileVO> postfile;
	//페이징
	private ArrayList<PostPageVO> postpage;
	
	
	
	public ArrayList<PostPageVO> getPostpage() {
		return postpage;
	}
	public void setPostpage(ArrayList<PostPageVO> postpage) {
		this.postpage = postpage;
	}
	public String getFilem() {
		return filem;
	}
	public void setFilem(String filem) {
		this.filem = filem;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
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
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public String getProduct_date() {
		return product_date;
	}
	public void setProduct_date(String product_date) {
		this.product_date = product_date;
	}
	public int getProduct_cnt() {
		return product_cnt;
	}
	public void setProduct_cnt(int product_cnt) {
		this.product_cnt = product_cnt;
	}
	public int getCategory_number() {
		return category_number;
	}
	public void setCategory_number(int category_number) {
		this.category_number = category_number;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}
	public ArrayList<PostFileVO> getPostfile() {
		return postfile;
	}
	public void setPostfile(ArrayList<PostFileVO> postfile) {
		this.postfile = postfile;
	}
	@Override
	public String toString() {
		return "PostVO [rownum=" + rownum + ", product_number=" + product_number + ", product_name=" + product_name
				+ ", product_desc=" + product_desc + ", product_date=" + product_date + ", product_cnt=" + product_cnt
				+ ", category_number=" + category_number + ", product_price=" + product_price + ", product_stock="
				+ product_stock + ", filem=" + filem + ", postfile=" + postfile + ", postpage=" + postpage + "]";
	}
	
	

	
}
