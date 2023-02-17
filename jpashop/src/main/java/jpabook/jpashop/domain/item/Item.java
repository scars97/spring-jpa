package jpabook.jpashop.domain.item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 추상화로 나뉜 테이블을 하나의 테이블로 묶어줌.
@DiscriminatorColumn(name = "dtype") // 한 테이블로 묶었을때 구분하게 해주는 키워드
@Getter
@Setter
public abstract class Item {

	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private Long id;

	private String name;
	private int price;
	private int stockQuantity;

	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<>();

	// == 비즈니스 로직 ==//
	
	//외부에서 값을 set할 필요없이 이 로직에서 변경해야 할 수 있음
	
	//stock 증가
	public void addStock(int quantity) {
		this.stockQuantity += quantity;
	}
	
	//stock 감소
	public void removeStock(int quantity) {
		int restStock = this.stockQuantity - quantity;
		if(restStock < 0) {
			throw new NotEnoughStockException("need mor stock");
		}
		this.stockQuantity = restStock;
	}
}
