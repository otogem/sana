package my.Sana.Model;

import java.util.ArrayList;

public class SupportVO {
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
	//게시판 분류(support_number)
	private int support_number;
	//이름(name)
	private String name;
	//PostFileVO(파일 업로드 관련 model)
	private ArrayList<SupportFileVO> supportfile;
	
	public ArrayList<SupportFileVO> getSupportfile() {
		return supportfile;
	}
	public void setSupportfile(ArrayList<SupportFileVO> supportfile) {
		this.supportfile = supportfile;
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
	public int getSupport_number() {
		return support_number;
	}
	public void setSupport_number(int support_number) {
		this.support_number = support_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SupportVO [rownum=" + rownum + ", bno=" + bno + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + ", cnt=" + cnt + ", id=" + id + ", support_number=" + support_number
				+ ", name=" + name + ", supportfile=" + supportfile + "]";
	}
	
		
}
