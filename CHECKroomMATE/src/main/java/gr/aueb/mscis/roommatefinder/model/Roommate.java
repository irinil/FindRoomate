package gr.aueb.mscis.roommatefinder.model;

import java.util.Set;

//Superclass Roommate 

import javax.persistence.*;

import org.jpwh.model.Constants;


@MappedSuperclass

public class Roommate {
	
	@Id
	@GeneratedValue(generator = Constants.ID_GENERATOR)
	private Long id;
	

	
	private String username;
	private String password;
	private EmailAddress email;
	private CellNumber phoneNumber;
	private String name;
	private String surname;
	private int age;
	private Set<Double> rating;
	
	
	public Roommate(String username, String password, EmailAddress email, CellNumber phoneNumber, String name,
			String surname, int age, Set<Double> rating) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.rating = rating;
	}
	
	public Roommate() {
		
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
	
	public EmailAddress getEmail() {
		return email;
	}
	
	public void setEmail(EmailAddress email) {
		this.email = email;
	}
	
	public CellNumber getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(CellNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public Set<Double> getRating() {
		return rating;
	}

	public void setRating(Set<Double> rating) {
		this.rating = rating;
	}
	
	





}
