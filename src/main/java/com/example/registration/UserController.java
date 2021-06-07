package com.example.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
    public List<RegisterDTO> userList()
    {
        List<RegisterDTO> registerDTOS = new ArrayList<RegisterDTO>() ;

      List<Register> registerList=  service.userList();
        for (Register register: registerList) {
            registerDTOS.add(new RegisterDTO(register.getName(), register.getEmail(),register.getPhoneNo(),register.getAddress(),register.getCountry(), register.getUid(),register.getPassword()));
        }
        return  registerDTOS;
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

    @GetMapping("/listPageable")
    Page<Register> pagination(Pageable pageable) {

        return service.employeesPageable(pageable);

    }

}
