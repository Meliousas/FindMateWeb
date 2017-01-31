package rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProfileDto {

	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String city;
	private String country;
	
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {this.age = age;}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
