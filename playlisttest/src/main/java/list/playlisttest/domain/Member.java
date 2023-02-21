package list.playlisttest.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
	//조장님이 만드신 컬럼명이랑 다를 수 있습니다.
	//원활한 진행을 위해 필수 요소들만 넣었습니다.

	@Id @GeneratedValue
	@Column(name = "m_id")//임시 변수명 - 나중에 바꿀 수 있음
	private String id;
	
	private String nickname;
	
	@OneToMany(mappedBy = "member")
	private List<WishList> wishList = new ArrayList<>();//
}
