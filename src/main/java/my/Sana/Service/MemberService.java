package my.Sana.Service;

import my.Sana.Model.MemberVO;

public interface MemberService {
	public void mblogin(MemberVO member);
	public void mbuser(MemberVO member);
	//서비스부터 아이디중복쓰기
}
