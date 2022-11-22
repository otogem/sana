package my.Sana.Model;

public class PostVO {
	//가상번호(rownum)
	private int rownum;
	//게시판번호(bno)
	private int bno;
	//제목(title)
	private String title;
	//내용(content)
	private String content;
	//작성일자(regdate)
	private String regdate;
	//조회수(cnt)
	private int cnt;
	//아이디(id)
	private String id;
	//게시판 분류(BGNO)
	private int bgno;
	//가격(price)
	private int price;
	//상품등록이미지
	private String image;
	//이름(name)
	private String name;
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBgno() {
		return bgno;
	}
	public void setBgno(int bgno) {
		this.bgno = bgno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PostVO [rownum=" + rownum + ", bno=" + bno + ", title=" + title + ", content=" + content + ", regdate="
				+ regdate + ", cnt=" + cnt + ", id=" + id + ", bgno=" + bgno + ", price=" + price + ", image=" + image
				+ ", name=" + name + "]";
	}

}
