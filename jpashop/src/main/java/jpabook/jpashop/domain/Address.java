package jpabook.jpashop.domain;

import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable
@Getter //Getter만 열어주고 Setter는 닫음.
public class Address {

	public Address(String city, String street, String zipcode) {
		super();
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
	
	protected Address() {}
	
	private String city;
	private String street;
	private String zipcode;
}
