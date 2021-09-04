package com.cg.main.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name="UserModule")
public class User {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;
private String password;
private String role;
//private Customer userId;

@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
@JoinColumn(name = "customer", referencedColumnName = "id")
private Customer userId;

public User() {
	super();
}

public User(Customer userId, String password, String role) {
	super();
	this.userId = userId;
	this.password = password;
	this.role = role;
}

public Customer getUserId() {
	return userId;
}
public void setUserId(Customer userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}
}

