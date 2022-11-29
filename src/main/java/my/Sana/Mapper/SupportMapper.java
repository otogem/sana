package my.Sana.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import my.Sana.Model.SupportPageVO;
import my.Sana.Model.SupportVO;

@Mapper
public interface SupportMapper {
	
	//Post_list 게시글 목록 리스트에 해당되는 DB 설계
	public ArrayList<SupportVO> list(SupportPageVO spa);
		
	//Post_list테이블 전체건수 DB설계
	public int total(SupportPageVO spa);
	
}
