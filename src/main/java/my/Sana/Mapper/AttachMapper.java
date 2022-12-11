package my.Sana.Mapper;

import java.util.List;

import my.Sana.Model.AttachImageVO;

public interface AttachMapper {
	
	/* 이미지 데이터 반환 */
	public List<AttachImageVO> getAttachList(int product_number);	
}
