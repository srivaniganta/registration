package com.example.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

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

        Base64.Encoder encoder = Base64.getEncoder();
        String normalString = usr.getPassword();
        String encodedString = encoder.encodeToString(
                normalString.getBytes(StandardCharsets.UTF_8) );

        register.setPassword(encodedString);


        return repo.save(register);
    }
        @GetMapping("/list")
    public List<Register> userList()
    {
         List<Register> regList=repo.findAll();
        return  regList;
    }

    @GetMapping(path= "/singleUser/{id}")
    public User userById(@PathVariable long id)
    {
       Register register=repo.getOne(id);
        return  new User(register.getName(),register.getEmail(),register.getCountry(),register.getUid() );

    }
    @DeleteMapping(path="/delete/{id}")
    public void deleteUser(@PathVariable long id)
    {
        repo.deleteById(id);
    }



}
