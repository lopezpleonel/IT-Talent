package com.it_talent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table()
public class Phones {

	@Id
	@Column(name = "number", nullable = false)
	private String number;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id", referencedColumnName = "id")
	@JsonIgnore
	private User user;
	
	@Column(name = "cityCode", nullable = false)
	private String cityCode;

	@Column(name = "countryCode", nullable = false)
	private String countryCode;
	

	public Phones() {
		
	}


	public Phones(String number, User user, String cityCode, String countryCode) {
		super();
		this.number = number;
		this.user = user;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
	}
	

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
