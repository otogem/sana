package my.Sana.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
