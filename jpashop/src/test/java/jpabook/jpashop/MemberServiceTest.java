package jpabook.jpashop;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.MemberService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)//junit 실행할떄 Spring과 연결해서 테스트해줘
@SpringBootTest //Autowired를 사용하기위해 필요함
@Transactional //기본적으로 RollBack 해주는 기능가짐
public class MemberServiceTest {

	@Autowired MemberRepository memberRepository;
	@Autowired MemberService memberService;
	
	@Test
	public void 회원가입() {
		//given
		Member member = new Member();
		member.setName("spring");
		
		//when
		Long saveId = memberService.join(member);
		
		//then
		assertEquals(member, memberRepository.findOne(saveId));
	}
	
	@Test
	public void 중복_회원_예외() {
		//given
		Member member1 = new Member();
		member1.setName("spring1");
		Member member2 = new Member();
		member2.setName("spring1");
		
		//when
		memberService.join(member1);
		try{
			memberService.join(member1);
		}catch(IllegalStateException e) {
			return;
		}
		
		//then
		fail("예외가 발생해야 합니다.");
	}
}
