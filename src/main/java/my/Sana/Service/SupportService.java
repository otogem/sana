package my.Sana.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import my.Sana.Model.SupportPageVO;
import my.Sana.Model.SupportVO;

@Service
public interface SupportService {
	
	//글 목록 리스트 설계
	public ArrayList<SupportVO> list(SupportPageVO spa);
	//각 페이지별  전체 건수 설계
	public int total(SupportPageVO spa);
}
