package com.basecs101.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Employee {

    private @Id
    @GeneratedValue Long id;
    private String name;
    private String role;

    public Employee(String name, String role) {

        this.name = name;
        this.role = role;
    }
}