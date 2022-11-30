package my.Sana.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import my.Sana.Model.SupportPageVO;
import my.Sana.Model.SupportVO;

@Mapper
public interface SupportMapper {
	
	//글쓰기에 해당되는 DB설계
	public void write(SupportVO support);
	
	//Post_list 게시글 목록 리스트에 해당되는 DB 설계
	public ArrayList<SupportVO> list(SupportPageVO spa);
		
	//Post_list테이블 전체건수 DB설계
	public int total(SupportPageVO spa);
	
	//목록리스트 에서 제목클릭시 조회수 +1업 하게 하는 DB 작업 설계
	public void cntup(SupportVO support);
	
	//목록리스트 에서 제목클릭시 상세내용 조회 가능한 DB작업 설계
	public SupportVO detail(SupportVO support);
	
	//상세내용 내용물 삭제 하는 DB작업 설계
	public boolean remove(int bno);
	//상세내용 내용물 수정하는 DB작업 설계
	public boolean modify(SupportVO support);
	
}
