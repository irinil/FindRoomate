package main.java.gr.aueb.mscis.roommatefinder.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;

import main.java.gr.aueb.mscis.roommatefinder.model.CellNumber;
import main.java.gr.aueb.mscis.roommatefinder.model.EmailAddress;
/**import main.java.gr.aueb.mscis.roommatefinder.model.House;*/
import main.java.gr.aueb.mscis.roommatefinder.model.Resident;
import main.java.gr.aueb.mscis.roommatefinder.model.Roommate;
import main.java.gr.aueb.mscis.roommatefinder.model.status;

@XmlRootElement
public class ResidentInfo extends Roommate {
	
	private long id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private int age;
	private int numOfFlatmates;
	private int ageRange;
	private boolean petRule;
	private Set<String> preferedHabits;
	private String preferedWorkSchedule;
	private status preferedProfession;
	private boolean guests;
	private String genderChoice;
	private Set<Double> rating;
	private CellNumber phoneNumber;
	private EmailAddress email;
	/**private House house;*/
	
	public ResidentInfo() {
		
	}

	public ResidentInfo(long id, String username, String password, String name, String surname, int age, int numOfFlatmates,
			int ageRange, Set<String> preferedHabits, boolean petRule, String preferedWorkSchedule, status preferedProfession,
			boolean guests, String genderChoice, Set<Double> rating, EmailAddress email, CellNumber phoneNumber) {
		this(username, password, name, surname, age, numOfFlatmates, ageRange, preferedHabits, petRule,preferedWorkSchedule,
				preferedProfession, guests, genderChoice, rating, email, phoneNumber);
		this.id = id;
	}
	
	public ResidentInfo(String username, String password, String name, String surname, int age, int numOfFlatmates,
			int ageRange, Set<String> preferedHabits, boolean petRule, String preferedWorkSchedule, status preferedProfession,
			boolean guests, String genderChoice, Set<Double> rating, EmailAddress email, CellNumber phoneNumber) {
		super(username,password,name,surname,age);
		this.numOfFlatmates = numOfFlatmates;
		this.ageRange = ageRange;
		this.preferedHabits = preferedHabits;
		this.petRule = petRule;
		this.preferedWorkSchedule = preferedWorkSchedule;
		this.preferedProfession = preferedProfession;
		this.guests = guests;
		this.genderChoice = genderChoice;
		this.rating = rating;
		this.email = email;
		this.phoneNumber = phoneNumber;		
	}
	
	public ResidentInfo(Resident resident) {
		username = resident.getUsername();
		password = resident.getPassword();
		name = resident.getName();
		surname = resident.getSurname();
		age = resident.getAge();
		id = resident.getId();
		numOfFlatmates = resident.getNumOfFlatmates();
		ageRange = resident.getAgeRange();
		preferedHabits = resident.getPreferedHabits();
		petRule = resident.isPetRule();
		preferedWorkSchedule = resident.getPreferedWorkSchedule();
		preferedProfession = resident.getPreferedProfession();
		guests = resident.isGuests();
		genderChoice = resident.getGenderChoice();
		rating = resident.getRating();
		email = resident.getEmail();
		phoneNumber = resident.getPhoneNumber();
	}
	
	public static List<ResidentInfo> wrap(List<Resident> residents) {
		List<ResidentInfo> residentInfoList = new ArrayList<>();
		
		for (Resident person : residents) {
			residentInfoList.add(new ResidentInfo(person));
		}
		
		return residentInfoList;
	}
	
	public static ResidentInfo wrap(Resident resident) {
		return new ResidentInfo(resident);
	}
	
	public Resident getResident(EntityManager em) {
		Resident resident = null;
		
		if(id <= -1) {
			resident = em.find(Resident.class, id);
		}else {
			resident = new Resident();
		}
		
		resident.setId(id);
		resident.setUsername(username);
		resident.setPassword(password);
		resident.setName(name);
		resident.setSurname(surname);
		resident.setAge(age);
		resident.setNumOfFlatmates(numOfFlatmates);
		resident.setAgeRange(ageRange);
		resident.setPreferedHabits(preferedHabits);
		resident.setPetRule(petRule);
		resident.setPreferedWorkSchedule(preferedWorkSchedule);
		resident.setPreferedProfession(preferedProfession);
		resident.setGuests(guests);
		resident.setGenderChoice(genderChoice);
		resident.setRating(rating);
		resident.setEmail(email);
		resident.setPhoneNumber(phoneNumber);
		
		return resident;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumOfFlatmates() {
		return numOfFlatmates;
	}

	public void setNumOfFlatmates(int numOfFlatmates) {
		this.numOfFlatmates = numOfFlatmates;
	}

	public int getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(int ageRange) {
		this.ageRange = ageRange;
	}

	public boolean isPetRule() {
		return petRule;
	}

	public void setPetRule(boolean petRule) {
		this.petRule = petRule;
	}

	public Set<String> getPreferedHabits() {
		return preferedHabits;
	}

	public void setPreferedHabits(Set<String> preferedHabits) {
		this.preferedHabits = preferedHabits;
	}

	public String getPreferedWorkSchedule() {
		return preferedWorkSchedule;
	}

	public void setPreferedWorkSchedule(String preferedWorkSchedule) {
		this.preferedWorkSchedule = preferedWorkSchedule;
	}

	public status getPreferedProfession() {
		return preferedProfession;
	}

	public void setPreferedProfession(status preferedProfession) {
		this.preferedProfession = preferedProfession;
	}

	public boolean isGuests() {
		return guests;
	}

	public void setGuests(boolean guests) {
		this.guests = guests;
	}

	public String getGenderChoice() {
		return genderChoice;
	}

	public void setGenderChoice(String genderChoice) {
		this.genderChoice = genderChoice;
	}

	public Set<Double> getRating() {
		return rating;
	}

	public void setRating(Set<Double> rating) {
		this.rating = rating;
	}

	public CellNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(CellNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public EmailAddress getEmail() {
		return email;
	}

	public void setEmail(EmailAddress email) {
		this.email = email;
	}
}	
