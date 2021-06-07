package com.example.registration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Grade")
@Data
public class Grade {
    private static final long serialVersionUID = -2343243243242432341L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String gradeLevel;
    private String teacherName;
    private String phoneNo;
    private String studentName;
}
