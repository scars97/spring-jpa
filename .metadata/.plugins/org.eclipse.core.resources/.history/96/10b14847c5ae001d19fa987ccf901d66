package jpabook.jpashop.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;

@Repository //스프링 빈을 자동으로 등록됨. 직접하려면 SpringConfig 클래스 만들어서 따로 설정해줘야함
@RequiredArgsConstructor
public class MemberRepository {

	@PersistenceContext
	private final EntityManager em;
	
//	public MemberRepository(EntityManager em) {
//		this.em = em;
//	}
	
	public void save(Member member) { //회원가입
		em.persist(member); //영속성으로 한번 회원가입됐던 값은 들어갈 수 없음.
		//Transactional로 commit을 해야 DB에 인서트문 날아감
		//근데 Spring은 RollBack이 디폴트로 되어있음.
		//Spring에서 하려면 .flush()해서 인서트문 볼 수 있음
	}
	
	public Member findOne(Long id) { //회원 조회, pk
		return em.find(Member.class, id);
	}
	
	public List<Member> findAll(){ //전체 회원 조회, jqpl 사용
		return em.createQuery("select m from Member m", Member.class)
				.getResultList();
	}
	
	public List<Member> findByName(String name){ //이름으로 회원 조회, jqpl 사용
		return em.createQuery("select m from Member m where m.name= :name", Member.class)
				.setParameter("name", name) //m.name과 매치되서 값 들어감
				.getResultList(); // 결과값 가져오기
	}
	
}



