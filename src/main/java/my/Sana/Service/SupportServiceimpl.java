package my.Sana.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.Sana.Mapper.SupportFileMapper;
import my.Sana.Mapper.SupportMapper;
import my.Sana.Model.SupportVO;
import my.Sana.Model.SupportFileVO;
import my.Sana.Model.SupportPageVO;

@Service
public class SupportServiceimpl implements SupportService{
	
	@Autowired
	SupportMapper sm;
	@Autowired
	SupportFileMapper sfm;
	

	//write 추상메서드 구현
	public void write(SupportVO support) {
		sm.write(support);
		
		support.getSupportfile().forEach(supportfile->{
			
			//supportfileVO의 bno에 Service VO 의 bno 저장
			supportfile.setBno(support.getBno());
				
			sfm.insert(supportfile);
		});
	}
	
	//list 추상메서드 구현
	public ArrayList<SupportVO> list(SupportPageVO spa){
		System.out.println("supportlist="+spa);
		return sm.list(spa);
	}
	
	//total 추상메서드 구현
	public int total(SupportPageVO spa) {
		return sm.total(spa);
	}
	
	//detail 추상메서드 구현
	@Transactional
	public SupportVO detail(SupportVO support) {
		//1회 조회할 때마다 리스트 에서 조회수 +1 증가
		sm.cntup(support);
		return sm.detail(support);
	}
	
	//remove 첨부파일 삭제용 추상메서드 구현
	public boolean remove(int bno) {
		System.out.println("첨부 파일 삭제 게시글 번호:"+ bno);
		
		sfm.deleteAll(bno);
		
		return sm.remove(bno);
	}
	
	//modify 추상메서드 구현
	@Transactional
	@Override
	public boolean modify(SupportVO support) {
		sfm.deleteAll(support.getBno());
		
		if(sm.modify(support) && support.getSupportfile() != null
						&& support.getSupportfile().size() > 0) {
			support.getSupportfile().forEach(supportfile->{
			supportfile.setBno(support.getBno());
			sfm.insert(supportfile);
		});
		}
		
		return sm.modify(support);
	}
	
	//첨부파일 조회 부여
	public ArrayList<SupportFileVO>spfilelist(int bno){
		return sfm.spfilelist(bno);
	}
}
