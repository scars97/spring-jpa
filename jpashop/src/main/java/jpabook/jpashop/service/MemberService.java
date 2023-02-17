package jpabook.jpashop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import jpabook.jpashop.domain.Member;

@Service
@Transactional(readOnly = true)//그냥 데이터만 읽는 로직은 읽기전용으로 설정
@RequiredArgsConstructor // final이 붙은 객체만 생성자 만들어줌.
public class MemberService {//실제 작동할 비즈니스 로직

	//final 키워드를 넣음으로써 컴파일 시점에서 오류 로직 체크를 해줄 수 있음.
	private final MemberRepository memberRepository;
	
//	생성자가 하나만 있을 시 자동을 Autowired 해줌
//	public MemberService(MemberRepository memberRepository) {
//		this.memberRepository = memberRepository;
//	}

	
	//회원가입
	@Transactional
	public Long join(Member member) {
		
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();// persist하는 순간 pk인 id가 자동으로 넣어짐. 그래서 꺼낼 수 있음.
	}
	
	private void validateDuplicateMember(Member member) {//중복회원 검사
		List<Member> findMembers = memberRepository.findByName(member.getName());
		if(!findMembers.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}
	}
	
	//회원 전체 조회
	public List<Member> findMember(){
		return memberRepository.findAll();
	}
	
	public Member findOne(Long memberId) {
		return memberRepository.findOne(memberId);
	}
	
	
}
