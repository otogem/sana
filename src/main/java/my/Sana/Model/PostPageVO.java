package my.Sana.Model;

public class PostPageVO {
	private int pageNum; 	//페이지번호
	private int amount; 	//한 페이지당 게시물 갯수
	private String keyword; //키워드를 통해 검색.
	private String type; 	//키워드 기준
	private int category_number;
	
	
	//생성자
	public PostPageVO() {
		this(1,10);
	}
	public PostPageVO(int pageNum,int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCategory_number() {
		return category_number;
	}
	public void setCategory_number(int category_number) {
		this.category_number = category_number;
	}
	@Override
	public String toString() {
		return "PostPageVO [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + ", type=" + type
				+ ", category_number=" + category_number + "]";
	}

	
	
}
