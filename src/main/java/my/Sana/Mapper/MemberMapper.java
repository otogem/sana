package my.Sana.Mapper;

import org.apache.ibatis.annotations.Mapper;

import my.Sana.Model.MemberVO;

@Mapper
public interface MemberMapper {
	
	public MemberVO mbloginpost(MemberVO member);
	public void mbuser(MemberVO member);
	public int overID(String id);
	public int logincheck(MemberVO member);
}
