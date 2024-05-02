package com.learn.TacoCloud.Forms;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.learn.TacoCloud.Models.Users;

import lombok.Data;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;
    public Users toUser(PasswordEncoder passwordEncoder) {
        return new Users(
            username, passwordEncoder.encode(password),
            fullname, street, city, state, zip, phone);
    }
}
