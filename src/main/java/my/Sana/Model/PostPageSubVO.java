package my.Sana.Model;

public class PostPageSubVO {
	//시작번호
	private int startPage;
	//끝번호
	private int endPage;
	//이번버튼
	private boolean prev;
	//다음버튼
	private boolean next;
	//PostPageVO 포함
	private PostPageVO ppa;
	//board테이블의 전체건수를 저장
	private int total;
	//생성자(매개변수가 2개인 생성자) 선언
	public PostPageSubVO(PostPageVO ppa,int total) {
		this.ppa=ppa;
		this.total=total;
		
		//시작번호,끝번호,이전버튼,다음버튼 계산
		//끝번호 식:현재페이지/10(올림)*10
		this.endPage=(int)(Math.ceil(ppa.getPageNum()/10.0))*10;
		//시작번호 식:끝번호-9
		this.startPage=this.endPage - 9 ;
		//제일마지막 페이지 번호는 전체건수를 고려해야 함.
		//제일마지막 끝번호식:전체건수(올림)/페이지당 게시물 갯수
		int realEnd=(int)(Math.ceil((total*1.0)/ppa.getAmount()));
		
		//13(realEnd)<20(endPage)면
		//realEnd가 적용되게 함.
		if(realEnd<this.endPage) {
			this.endPage=realEnd;
		}
		//startPage가 1보다 크면 이전버튼 활성화
		this.prev=this.startPage>1;
		
		//endPage가 realEnd 보다 작으면
		this.next=this.endPage<realEnd;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public PostPageVO getPpa() {
		return ppa;
	}
	public void setPpa(PostPageVO ppa) {
		this.ppa = ppa;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "PostPageSubVO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", ppa=" + ppa + ", total=" + total + "]";
	}
	
	
}
