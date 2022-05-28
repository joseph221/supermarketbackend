package com.example.SuperMarket.Dto;



import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String firstname;
    private String lastname;
	private String username;
	private String password;
    private String email;
    private long roleId;
}
