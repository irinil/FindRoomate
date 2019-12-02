package main.java.gr.aueb.mscis.roommatefinder.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
@Table(name="flatmates")
public class Flatmate extends Roommate implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="flatmateid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	
    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "flatmate")
    private Set<CohabitRequest> cohabitRequests = new HashSet<CohabitRequest>();

	private String description;
	private String gender;
	private status profession;
	private boolean pets;
	@Column
	@ElementCollection(targetClass=String.class)
	private Set<String> habits;
	private String workSchedule;
	private boolean incomingGuests;
	@Column
	@ElementCollection(targetClass=Double.class)
	private Set<Double> rating;
	
	 @org.hibernate.annotations.Type(
	            type="main.java.gr.aueb.mscis.roommatefinder.persistence.EmailCustomType")
	    @Column(name="email", length = 50, nullable=true)
	private EmailAddress email;
	 @org.hibernate.annotations.Type(
	            type="main.java.gr.aueb.mscis.roommatefinder.persistence.TelphoneNumberCustomType")
	    @Column(name="cellNumber", length = 20, nullable=true)
	private CellNumber phoneNumber;
	
	public Flatmate(String username, String password, EmailAddress email, CellNumber phoneNumber, String name,
			String surname, int age, String description, String gender, status profession, boolean pets,
			Set<String> habits, String workSchedule, boolean incomingGuests, Set<Double> rating) {
		super(username, password, name, surname, age);
		this.description = description;
		this.gender = gender;
		this.profession = profession;
		this.pets = pets;
		this.habits = habits;
		this.workSchedule = workSchedule;
		this.incomingGuests = incomingGuests;
	}
	
	public Flatmate() {
		super();
	}

	public Flatmate(String username, String password, EmailAddress email, CellNumber phoneNumber, String name,
			String surname, int age, Set<Double> rating) {
		super(username, password, name, surname, age);
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public status getProfession() {
		return profession;
	}
	
	public void setProfession(status profession) {
		this.profession = profession;
	}
	
	public boolean isPets() {
		return pets;
	}
	
	public void setPets(boolean pets) {
		this.pets = pets;
	}
	
	public Set<String> getHabits() {
		return habits;
	}
	
	public void setHabits(Set<String> habits) {
		this.habits = habits;
	}
	
	public String getWorkSchedule() {
		return workSchedule;
	}
	
	public void setWorkSchedule(String workSchedule) {
		this.workSchedule = workSchedule;
	}
	
	public boolean isIncomingGuests() {
		return incomingGuests;
	}
	
	public void setIncomingGuests(boolean incomingGuests) {
		this.incomingGuests = incomingGuests;
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

	
	public Set<Double> getRating() {
		return rating;
	}


	public void setRating(Set<Double> rating) {
		this.rating = rating;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cohabitRequests == null) ? 0 : cohabitRequests.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((habits == null) ? 0 : habits.hashCode());
		result = prime * result + (incomingGuests ? 1231 : 1237);
		result = prime * result + (pets ? 1231 : 1237);
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((workSchedule == null) ? 0 : workSchedule.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flatmate other = (Flatmate) obj;
		if (cohabitRequests == null) {
			if (other.cohabitRequests != null)
				return false;
		} else if (!cohabitRequests.equals(other.cohabitRequests))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (habits == null) {
			if (other.habits != null)
				return false;
		} else if (!habits.equals(other.habits))
			return false;
		if (incomingGuests != other.incomingGuests)
			return false;
		if (pets != other.pets)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (profession != other.profession)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (workSchedule == null) {
			if (other.workSchedule != null)
				return false;
		} else if (!workSchedule.equals(other.workSchedule))
			return false;
		return true;
	}

	//TODO connection with houseAd
	public void request(String houseAdName) {
		Date date = new Date(System.currentTimeMillis());
		CohabitRequest request = new CohabitRequest(this,false,date,houseAdName);
		cohabitRequests.add(request);
	}
	
	
}
