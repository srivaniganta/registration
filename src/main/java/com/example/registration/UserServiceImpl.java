package com.example.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService{
    @Autowired
    loginRepository repo;
    @Autowired
    GradeRepository gradeRepository;

    @Transactional
    public String saveUser(User usr)
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


         repo.save(register);
         Grade grade =new Grade();
         grade.setStudentName(usr.getName());
        grade.setTeacherName(usr.getTeacher_name());
        grade.setPhoneNo(usr.getPhone_no());
        grade.setGradeLevel(usr.getGrade_level());
        gradeRepository.save(grade);
        if(register.getId()==30)
         {
             int a=10/2;
             System.out.println("The value  of a is"+a);
         }

        if(register!=null)
        {
            System.out.println("Record inserted Successfully");
        }
         return "Record is not inserted in database";
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


    Page<Register> employeesPageable(Pageable pageable) {
        System.out.println(pageable.getPageSize());
        return repo.findAll(pageable);

    }


}
