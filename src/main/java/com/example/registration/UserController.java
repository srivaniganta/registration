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
    UserServiceImpl service;

@PostMapping("/save")
    public String saveUser(@RequestBody User usr)
    {
          service.saveUser(usr);
          return "Success";

    }
        @GetMapping("/list")
    public List<Register> userList()
    {

        return  service.userList();
    }

    @GetMapping(path= "/singleUser/{id}")
    public User userById(@PathVariable long id)
    {
         return  service.userById(id);
    }

    @DeleteMapping(path="/delete/{id}")
    public void deleteUser(@PathVariable long id)
    {

       service.deleteUser(id);
    }



}
