package com.example.crudspringdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * ---------------------------------------------------------
 * Student Entity
 * ---------------------------------------------------------
 * This class represents a Student entity.
 *
 * Each object of this class corresponds to one record
 * in the Student table of the database.
 *
 * It contains all the necessary information related
 * to a student.
 * ---------------------------------------------------------
 */
@Entity
public class Student {

    /**
     * Unique identifier for each student.
     * This field acts as the Primary Key.
     */
    @Id
    private Long id;

    /**
     * Stores the student's full name.
     */
    private String name;

    /**
     * Stores the student's email address.
     */
    private String email;

    /**
     * Stores the subject in which the student is enrolled.
     */
    private String subject;

    /**
     * Stores the student's age.
     */
    private int age;

    /**
     * Stores the student's roll number.
     */
    private int rollNo;

    /**
     * Returns the student ID.
     *
     * @return Student ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the student ID.
     *
     * @param id Student ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the student's name.
     *
     * @return Student name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the student's name.
     *
     * @param name Student name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the student's email address.
     *
     * @return Student email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the student's email address.
     *
     * @param email Student email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the student's subject.
     *
     * @return Student subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the student's subject.
     *
     * @param subject Student subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Returns the student's age.
     *
     * @return Student age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the student's age.
     *
     * @param age Student age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the student's roll number.
     *
     * @return Student roll number
     */
    public int getRollNo() {
        return rollNo;
    }

    /**
     * Sets the student's roll number.
     *
     * @param rollNo Student roll number
     */
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}