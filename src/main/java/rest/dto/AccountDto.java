package rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AccountDto {
	
	private int id;
	private String userName;
	private String userPassword;
	private String userEmail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {this.userName = userName;}
	public String getUserPassword() {return userPassword;}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {return userEmail;}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
