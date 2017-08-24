package com.rangeofride.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Register
{

@Column
String Username;
@Id
String Email;
@Column
String Upassword;
@Column
String status="true";
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}
@Column
String Role="ROLE_USER";

public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getUpassword() {
	return Upassword;
}
public void setUpassword(String upassword) {
	Upassword = upassword;
}

}
