package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository //component가 포함돼있기 때문에 자동으로 Spring Bean에 등록됨.
public class MemberRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Long save(Member member) {
		em.persist(member);
		return member.getId();
	}
	
	public Member find(Long id) {
		return em.find(Member.class, id);
	}
}
