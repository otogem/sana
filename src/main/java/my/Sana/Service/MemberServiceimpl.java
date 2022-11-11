package my.Sana.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.Sana.Mapper.MemberMapper;
import my.Sana.Model.MemberVO;

@Service
public class MemberServiceimpl implements MemberService{
	
	@Autowired
	MemberMapper mm;
	
	public void mblogin(MemberVO member){
		mm.mbloginpost(member);
	}
	
	public void mbuser(MemberVO member) {
		mm.mbuser(member);
	}
}
