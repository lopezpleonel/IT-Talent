package com.it_talent.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class User {
	
	private static final String dateFormat = "dd-MM-yyyy HH:mm:ss";
	
	@Id
	@Column(name = "id", columnDefinition = "binary(16)")
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator", parameters= {@Parameter(name="uuid_gen_strategy_class", value="org.hibernate.id.uuid.CustomVersionOneStrategy")})
    private UUID id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email", unique= true)
	@Email
	@NotBlank(message="El correo electrónico es requerido")
	private String email;
	
	@Column(name = "password")
	@NotBlank(message = "La contraseña es requerida")
	@Pattern(regexp ="^(?=.*[A-Z])(?=.*[0-9].*[0-9]).{4,16}$", message="Ingrese una letra mayúscula, al menos una minúscula y al menos 2 números para la contraseña (máx. 16 caracteres)")
	private String password;
	
	@Column(name = "created")
	@JsonFormat(pattern=dateFormat)
	private Date created = new Date(); 
	
	@Column(name = "modified")
	@JsonFormat(pattern=dateFormat)
	private Date modified = new Date();

	@Column(name = "lastLogin")
	@JsonFormat(pattern=dateFormat)
	private Date lastLogin = new Date();;	

	@Column(name = "token")
	private String token;

	@Column(name = "isActive")
	private Boolean isActive = true;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private Set<Phones> phoneList;
	
	
	public User() {
	}
	

	public User(UUID id, String name,
			@Email @NotNull @NotBlank(message = "El correo electrónico es mandatorio") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$", message = "Correo electrónico no valido") String email,
			@Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9].*[0-9]).{4,16}$", message = "Ingrese una letra mayúscula, al menos una minúscula y al menos 2 números para la contraseña (máx. 16 caracteres)") String password,
			Date created, Date modified, Date lastLogin, String token, Boolean isActive, Set<Phones> phoneList) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.created = created;
		this.modified = modified;
		this.lastLogin = lastLogin;
		this.token = token;
		this.isActive = isActive;
		this.phoneList = phoneList;
	}


	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Set<Phones> getPhoneList() {
		return phoneList;
	}
	public void setPhoneList(Set<Phones> phoneList) { 
		this.phoneList = phoneList;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String creationDate = sdf.format(created);
		String modificationDate = sdf.format(modified);
		String lastLoginDate = sdf.format(lastLogin);
		
		return "User [id=" + id + ", name=" + name + ", created="
				+ creationDate + ", modified=" + modificationDate + ", lastLogin=" 
				+ lastLoginDate + ", token=" + token + ", isActive="
				+ isActive + "]";
	}
}
