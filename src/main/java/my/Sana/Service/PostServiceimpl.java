package my.Sana.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.Sana.Mapper.PostFileMapper;
import my.Sana.Mapper.PostMapper;
import my.Sana.Model.PostFileVO;
import my.Sana.Model.PostPageVO;
import my.Sana.Model.PostVO;

@Service
public class PostServiceimpl implements PostService{
	
	@Autowired
	PostMapper pm;
	@Autowired
	PostFileMapper pfm;
	
	
	//write 추상메서드 구현
	public void write(PostVO post) {
		pm.write(post);
		
		post.getPostfile().forEach(postfile->{
			
			//PostFileVO의 Product_number에 Service VO 의 product_number 저장
			postfile.setProduct_number(post.getProduct_number());
				
			pfm.insert(postfile);
		});
	}
	
	//list 추상메서드 구현
	public ArrayList<PostVO> list(PostPageVO ppa){
		System.out.println("postlist="+ppa);
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
		
		pfm.deleteAll(product_number);
		
		return pm.remove(product_number);
	}
	
	//modify 추상메서드 구현
	@Transactional
	@Override
	public boolean modify(PostVO post) {
		pfm.deleteAll(post.getProduct_number());
		
		if(pm.modify(post) && post.getPostfile() != null
						&& post.getPostfile().size() > 0) {
			post.getPostfile().forEach(postfile->{
			postfile.setProduct_number(post.getProduct_number());
			pfm.insert(postfile);
		});
		}
		
		return pm.modify(post);
	}
	
	//첨부파일 조회 부여
	public ArrayList<PostFileVO>filelist(int product_number){
		return pfm.filelist(product_number);
	}
}
