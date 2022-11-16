package my.Sana.Repository;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.Sana.Model.KakaoDTO;

@Repository
	public class MemberRepository {

		// mapper를 호출하기 위한 클래스 주입.
		@Autowired
		private SqlSessionTemplate sql;
		
		// 정보 저장
		public void kakaoinsert(HashMap<String, Object> userInfo) {
			sql.insert("Member.kakaoInsert",userInfo);
		}

		// 정보 확인
		public KakaoDTO findkakao(HashMap<String, Object> userInfo) {
			System.out.println("RN:"+userInfo.get("nickname"));
			System.out.println("RE:"+userInfo.get("email"));
			return sql.selectOne("Member.findKakao", userInfo);
		}
}
