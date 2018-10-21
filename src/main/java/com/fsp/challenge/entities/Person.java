package com.fsp.challenge.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private Date dob;
	
	
	public Person(int id, String firstName, String lastName, String username, String password, String email, Date dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
	}
	
	public Person(String firstName, String lastName, String username, String password, String email, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
	}
	
	public Person() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public void set(Person newPerson) {
		this.firstName = newPerson.firstName != null ?
				newPerson.firstName : this.firstName; 
		this.lastName = newPerson.lastName != null ?
				newPerson.lastName : this.lastName;
		this.username = newPerson.username != null ?
				newPerson.username : this.username;
		this.password = newPerson.password != null ?
				newPerson.password : this.password;
		this.email = newPerson.email != null ?
				newPerson.email : this.email;
		this.dob = newPerson.dob != null ?
				newPerson.dob : this.dob;
	}
	
}

