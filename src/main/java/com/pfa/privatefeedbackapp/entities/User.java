package com.pfa.privatefeedbackapp.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;
//MAYBE @ GENERRATE VALUE ALLOWS US TO PASS OUR OWN METHOD1!!!!!!
    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
   // @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "password")
    @Length(min = 6, message = "*Your password must have at least 6 characters")
   // @NotEmpty(message = "*Please provide your password")
    private String password;

    @Column(name = "firstName")
    //@NotEmpty(message = "*Please provide your firstName")
    private String firstName;

    @Column(name = "lastName")
   // @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @Column(name = "active")
    private int active;

    @Column(name = "phoneNumber")
    private String phoneNumber;

//    @Column(name = "encKey")
//    private Long encKey;

    @Column (name = "verificationNumber")
    private int verificationNumber;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
    private String[] rolesStringSetUsedForSignUp;

}