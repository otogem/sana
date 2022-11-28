package my.Sana.Mapper;

import java.util.ArrayList;


import my.Sana.Model.PostFileVO;

public interface PostFileMapper {
	//글쓰기에 해당되는 DB작업 설계
	public void insert(PostFileVO postfile);
	// 해당게시물의 첨부파일 조회
	public ArrayList<PostFileVO> filelist(int product_number);
	//게시물 삭제시 첨부파일도 같이 삭제
	public void deleteAll(int product_number);
}
