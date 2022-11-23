package my.Sana.Service;

import org.springframework.stereotype.Service;

import my.Sana.Model.MemberVO;

@Service
public interface MemberService {
	public void mblogin(MemberVO member);
	public void mbuser(MemberVO member);
	public int logincheck(MemberVO member);
}
