package my.Sana.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;
import my.Sana.Mapper.AttachMapper;
import my.Sana.Model.AttachImageVO;

@Service
@Log4j
public class AttachServiceimpl implements AttachService{
	
	@Autowired
	private AttachMapper am;
	
	
	/* 이미지 데이터 반환 */
	@Override
	public List<AttachImageVO> getAttachList(int product_number) {
		
		log.info("getAttachList.........");
		
		return am.getAttachList(product_number);
	}
}
