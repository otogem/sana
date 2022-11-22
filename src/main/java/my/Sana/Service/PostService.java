package my.Sana.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import my.Sana.Model.PostPageVO;
import my.Sana.Model.PostVO;

@Service
public interface PostService {
	//글쓰기 설계
	public void write(PostVO post);
	//글 목록 리스트 설계
	public ArrayList<PostVO> list(PostPageVO ppa);
	//각 페이지별  전체 건수 설계
	public int total(PostPageVO ppa);
}
