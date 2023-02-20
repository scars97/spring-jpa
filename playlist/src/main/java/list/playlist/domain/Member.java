package list.playlist.domain;

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

	@Id @GeneratedValue
	@Column(name = "m_id")
	private String id;
	
	private String nickname;
	
	@OneToMany(mappedBy = "member")
	private List<WishList> wishList = new ArrayList<>();
}
