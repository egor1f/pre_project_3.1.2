package com.pre_project_312.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Entity
@Table(name="users", schema = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotBlank
    @Size(min = 2, max = 40, message = "Invalid name")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё]{2,40}$", message = "use correct value")
    private String name;

    @Column
    @Min(value = 18, message = "Age should be at least 18")
    @Max(value = 120, message = "Age should be less than 120")
    private int age;

    @Column
    @Size(min = 6, max = 11, message = "Invalid number")
    private String number;
    public User() {
    }

    public User(String name, int age, String number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", number='" + number + '\'' +
                '}';
    }
}
