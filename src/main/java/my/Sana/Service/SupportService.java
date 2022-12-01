package my.Sana.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


import my.Sana.Model.SupportVO;
import my.Sana.Model.SupportFileVO;
import my.Sana.Model.SupportPageVO;

@Service
public interface SupportService {
	
	//글쓰기 설계
	public void write(SupportVO support);
	//글 목록 리스트 설계
	public ArrayList<SupportVO> list(SupportPageVO spa);
	//각 페이지별  전체 건수 설계
	public int total(SupportPageVO spa);
	//글 상세 내용 보기 설계
	public SupportVO detail(SupportVO support);
	//글 삭제
	public boolean remove(int bno);
	//글 수정 
	public boolean modify(SupportVO support);
	//첨부파일 조회 설계
	public ArrayList<SupportFileVO>spfilelist(int bno);
}
