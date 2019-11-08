package patients.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String phone;
	private String email;
	private String primaryDoctor;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(String name) {
		super();
		this.name = name;
	}
	public Patient(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPrimaryDoctor() {
		return primaryDoctor;
	}
	public void setPrimaryDoctor(String primaryDoctor) {
		this.primaryDoctor = primaryDoctor;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", phone=" + phone + ", email=" + email
				+ ", primaryDoctor=" + primaryDoctor + "]";
	}

}
