package com.example.registration;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    public Register saveUser(User usr);
    public List<Register> userList();
    public User userById(long id);
    public void deleteUser(long id);
}
