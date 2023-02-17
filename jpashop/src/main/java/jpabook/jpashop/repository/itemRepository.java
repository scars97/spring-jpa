package jpabook.jpashop.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class itemRepository {

	private final EntityManager em;
	
	public void save(Item item) {
		if(item.getId() == null) {
			em.persist(item);//아이템 신규 등록
		}else {
			em.merge(item); //업데이트 비슷한...?
		}
	}
	
	public Item findOne(Long id) {
		return em.find(Item.class, id);
	}

	public List<Item> findAll(){
		return em.createQuery("select i from Item i", Item.class)
				.getResultList();
	}
}
