package com.fsp.challenge.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="person_id")
	@JsonIgnore
	Person person;
		
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zipcode;
	//private Boolean primary;
	
	public Address(String street1, String street2, String city, String state, String zipcode) {
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		//this.primary = primary;
	}
	
	public Address(String street1, String city, String state, String zipcode) {
		this.street1 = street1;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		//this.primary = primary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Customer person) {
		this.person = person;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/*public Boolean getPrimary() {
		return primary;
	}
	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}*/
	public void set(Address newAddress) {
		this.street1 = newAddress.street1 != null ?
				newAddress.street1 : this.street1;
		this.street2 = newAddress.street2 != null ?
				newAddress.street2 : this.street2;
		this.city = newAddress.city != null ?
				newAddress.city : this.city;
		this.state = newAddress.state != null ?
				newAddress.state : this.state;
		this.zipcode = newAddress.zipcode != null ?
				newAddress.zipcode : this.zipcode;
		/*this.primary = (Boolean) newAddress.primary != null ?
				newAddress.primary : this.primary;*/
		this.person = newAddress.person != null ?
				newAddress.person : this.person;
	}
}
