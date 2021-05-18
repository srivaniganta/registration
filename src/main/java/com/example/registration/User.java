package com.example.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {
    public int id;
    private String name;
    private String email;
    private String phoneNo;
    private String address;
    private String country;
    private String uid;
    private String password;

    public User(String name, String email,  String country, String uid) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.uid = uid;
    }
}
