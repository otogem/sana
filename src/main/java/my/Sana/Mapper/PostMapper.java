package my.Sana.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import my.Sana.Model.PostPageVO;
import my.Sana.Model.PostVO;

@Mapper
public interface PostMapper {
	
	//글쓰기에 해당되는 DB설계
	public void write(PostVO post);
	
	//Post_list 게시글 목록 리스트에 해당되는 DB 설계
	public ArrayList<PostVO> list(PostPageVO ppa);
		
	//Post_list테이블 전체건수 DB설계
	public int total(PostPageVO ppa);
	
	//목록리스트 에서 제목클릭시 조회수 +1업 하게 하는 DB 작업 설계
	public void cntup(PostVO post);
	
	//목록리스트 에서 제목클릭시 상세내용 조회 가능한 DB작업 설계
	public PostVO detail(PostVO post);
	
	//상세내용 내용물 삭제 하는 DB작업 설계
	public boolean remove(int bno);
}
