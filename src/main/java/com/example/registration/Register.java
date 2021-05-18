package com.example.registration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Register")
@Data
public class Register implements Serializable {
    private static final long serialVersionUID = -2343243243242432341L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column (name = "phoneNo")
    private String phoneNo;
    @Column(name="address")
    private String address;
    @Column(name = "country")
    private String country;
    @Column(name = "uid")
    private String uid;
    @Column(name = "password")
    private String password;
}
