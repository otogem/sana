package my.Sana.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.Sana.Mapper.SupportMapper;
import my.Sana.Model.SupportPageVO;
import my.Sana.Model.SupportVO;

@Service
public class SupportServiceimpl implements SupportService{
	
	@Autowired
	SupportMapper sm;
	
	//list 추상메서드 구현
	public ArrayList<SupportVO> list(SupportPageVO spa){
		System.out.println("Supportlist="+spa);
		return sm.list(spa);
	}
	
	//total 추상메서드 구현
	public int total(SupportPageVO spa) {
		return sm.total(spa);
	}
}
