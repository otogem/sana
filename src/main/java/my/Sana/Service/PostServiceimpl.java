package my.Sana.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.Sana.Mapper.PostMapper;
import my.Sana.Model.PostPageVO;
import my.Sana.Model.PostVO;

@Service
public class PostServiceimpl implements PostService{
	
	@Autowired
	PostMapper pm;
	
	
	//write 추상메서드 구현
	public void write(PostVO post) {
		pm.write(post);
	}
	
	//list 추상메서드 구현
	public ArrayList<PostVO> list(PostPageVO ppa){
		System.out.println("service="+ppa);
		return pm.list(ppa);
	}
	
	//total 추상메서드 구현
	public int total(PostPageVO ppa) {
		return pm.total(ppa);
	}
	
	//detail 추상메서드 구현
	@Transactional
	public PostVO detail(PostVO post) {
		//1회 조회할 때마다 리스트 에서 조회수 +1 증가
		pm.cntup(post);
		return pm.detail(post);
	}
	
	//remove 첨부파일 삭제용 추상메서드 구현
	public boolean remove(int product_number) {
		System.out.println("첨부 파일 삭제 게시글 번호:"+ product_number);
		
		return pm.remove(product_number);
	}
	public void modify(PostVO post) {
		pm.modify(post);
	}
}
