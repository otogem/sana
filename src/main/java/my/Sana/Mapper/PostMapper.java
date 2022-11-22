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
}
