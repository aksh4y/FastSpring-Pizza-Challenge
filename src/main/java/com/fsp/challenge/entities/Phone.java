package com.fsp.challenge.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="person_id")
	@JsonIgnore
	Person person;
	
	private String number;
	//private Boolean primary;
	
	public Phone(String number) {//, Boolean primary) {
		super();
		this.number = number;
		//this.primary = primary;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	/*public Boolean isPrimary() {
		return primary;
	}
	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public void set(Phone newPhone) {
		this.number = newPhone.number != null ?
				newPhone.number : this.number;
		/*this.primary = (Boolean) newPhone.primary != null ?
				newPhone.primary : this.primary;*/
		this.person = newPhone.person != null ?
				newPhone.person : this.person;

	}
}
