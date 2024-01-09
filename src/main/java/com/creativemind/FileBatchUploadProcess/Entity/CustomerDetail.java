package com.creativemind.FileBatchUploadProcess.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class CustomerDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String contactNo;
	private String country;
	private String dob;
	public Integer getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public CustomerDetail(Integer id, String firstName,String lastName, String email, String gender, String contactNo, String country,
			String dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName=lastName;
		this.email = email;
		this.gender = gender;
		this.contactNo = contactNo;
		this.country = country;
		this.dob = dob;
	}
	public CustomerDetail() {
		super();
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "CustomerDetail [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", contactNo=" + contactNo + ", country=" + country + ", dob=" + dob + "]";
	}
    
	
}