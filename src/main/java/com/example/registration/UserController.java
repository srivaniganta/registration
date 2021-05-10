package com.example.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/r1")
public class UserController {
    @Autowired
    loginRepository repo;

@PostMapping("/save")
    public Register saveUser(@RequestBody User usr)
    {
        Register register=new Register();
        register.setName(usr.getName());
        register.setEmail(usr.getEmail());
        register.setPhoneNo(usr.getPhoneNo());
        register.setAddress(usr.getAddress());
        register.setCountry(usr.getCountry());
        register.setUid(usr.getUid());
        register.setPassword(usr.getPassword());


        return repo.save(register);
    }

}
