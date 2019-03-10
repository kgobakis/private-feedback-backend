package com.example.kostas.demoeeee.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    private String emailId;

}