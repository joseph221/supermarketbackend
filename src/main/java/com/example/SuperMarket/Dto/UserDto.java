package com.example.SuperMarket.Dto;

import lombok.Data;

@Data
public class UserDto {
    private String firstname;
    private String lastname;
	private String username;
	private String password;
    private String email;
    private String imgUrl;
    private boolean disabled;
	private boolean accountExpired;
	private boolean accountLocked;
	private boolean credentialsExpired;
}
