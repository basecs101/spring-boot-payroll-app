package com.basecs101.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Employee has 3 fields -> id, name and role
 * Employee Table
 * | id | name | role
 * | 1 | ABC  | HR
 * | 2 | XYZ | Admin
 */

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Employee")
//Model or POJO or bean or Object or Instance or Table or Schema
public class Employee {

    private @Id @GeneratedValue Long id;
    private String role;
    private String name;
    private String firstName;
    private String lastName;

    public Employee(String role, String firstName, String lastName) {
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    //name = "Vikram Gupta"
    public void setName(String name){

        String[] fistNameAndLastName = name.split(" ");

        this.firstName = fistNameAndLastName[0];
        this.lastName = fistNameAndLastName[1];
    }
}