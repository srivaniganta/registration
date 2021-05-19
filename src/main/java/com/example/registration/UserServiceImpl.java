package com.example.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
@Service
public class UserServiceImpl  implements UserService{
    @Autowired
    loginRepository repo;
    public Register saveUser(User usr)
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

    public List<Register> userList()
    {
        List<Register> regList=repo.findAll();
        return  regList;
    }


    public User userById(long id)
    {
        Register register=repo.getOne(id);
        return  new User(register.getName(),register.getEmail(),register.getCountry(),register.getUid() );

    }

    public void deleteUser(long id)
    {

        repo.deleteById(id);
    }



}
