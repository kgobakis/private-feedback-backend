//package com.pfa.privatefeedbackapp.entities;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Random;
//
//@Embeddable
//@Data
//public class VerificationToken {
//
//   // private static final int EXPIRATION = 60 * 24;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//
//    private int token;
//
//    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false, name = "user_id")
//    private User user;
//
////    private Date expiryDate;
////
////    private Date calculateExpiryDate(int expiryTimeInMinutes) {
////        Calendar cal = Calendar.getInstance();
////        cal.setTime(new Timestamp(cal.getTime().getTime()));
////        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
////        return new Date(cal.getTime().getTime());
////    }
//
//
//
//}
