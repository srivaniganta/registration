package com.example.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String name;
    private String email;
    private String phoneNo;
    private String address;
    private String country;
    private String uid;
    private String password;

}
