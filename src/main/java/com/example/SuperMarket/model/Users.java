package com.example.SuperMarket.model;


import java.time.LocalDate;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
	private long id;
    private String firstname;
    private String lastname;
	private String username;
	private String password;
    private String email;
    // private String imgUrl;
	// private boolean disabled;
	// private boolean accountExpired;
	// private boolean accountLocked;
	// private boolean credentialsExpired;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", 
		joinColumns = @JoinColumn(name="id"),
		inverseJoinColumns = @JoinColumn(name = "role_id"))
	List<Roles> roles;
  

}
