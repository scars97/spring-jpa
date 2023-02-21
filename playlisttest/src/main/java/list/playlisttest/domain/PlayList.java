package list.playlisttest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PlayList {

	@Id @GeneratedValue
	@Column(name = "pl_id")
	private int id;
	
	@Column(name = "pl_title")
	private String title;
	
	private String discription;
//	private String image;
	
	@OneToOne(mappedBy = "playList",fetch = FetchType.LAZY)
	private WishList wishList;
}
