package com.example.fullfledgeuserlogin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Qualifications {

    @Id
    private Integer id;

    private String name;
}
