package my.Sana.Service;

import java.util.List;

import my.Sana.Model.AttachImageVO;

public interface AttachService {
	
	/* 이미지 데이터 반환 */
	public List<AttachImageVO> getAttachList(int product_number);	
}
