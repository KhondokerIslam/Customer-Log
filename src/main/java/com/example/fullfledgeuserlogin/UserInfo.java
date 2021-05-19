package com.example.fullfledgeuserlogin;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class UserInfo {

    @Id
    @GeneratedValue()
    private Integer id;

    private String name;
    private String dateOfBirth;


    @ElementCollection
    private List<String> qualification ;



    private String gender;
    private String ageRange;
    private String aboutMe;
//    private String address;




}
