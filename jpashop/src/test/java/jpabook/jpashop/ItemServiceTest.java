package jpabook.jpashop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.itemRepository;
import jpabook.jpashop.service.ItemService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

	@Autowired itemRepository itemRepository;
	@Autowired ItemService itemService;

//	@Test
//	public void 아이템_등록() {
//		//given
//		Item item = new Item();
//		item.setName("테스트 상품");
//		
//		//when
//		Long saveItemId = itemService.saveItem(item);
//		
//		//then
//		assertEquals(item, itemRepository.findOne(saveItemId));
//		
//	}
}
