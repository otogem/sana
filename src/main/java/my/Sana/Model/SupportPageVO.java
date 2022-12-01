package my.Sana.Model;

public class SupportPageVO {
	private int pageNum; 	//페이지번호
	private int amount; 	//한 페이지당 게시물 갯수
	private String keyword; //키워드를 통해 검색.
	private String type; 	//키워드 기준
	private int support_number; //게시판 분류
	
	//생성자
	public SupportPageVO() {
		this(1,10);
	}
	public SupportPageVO(int pageNum,int amount) {
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

	public int getSupport_number() {
		return support_number;
	}

	public void setSupport_number(int support_number) {
		this.support_number = support_number;
	}

	@Override
	public String toString() {
		return "SupportPageVO [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + ", type=" + type
				+ ", support_number=" + support_number + "]";
	}
	
	
}
