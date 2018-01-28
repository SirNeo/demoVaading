package es.jmpalma.tutorial;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -5926941032951389096L;
	private Integer id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	
	public Integer getId() {
		return id;
	}
	public void setUserId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
}
