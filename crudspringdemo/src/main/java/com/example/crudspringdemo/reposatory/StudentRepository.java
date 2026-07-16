package com.example.crudspringdemo.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudspringdemo.entity.Student;

/**
 * ---------------------------------------------------------
 * Student Repository
 * ---------------------------------------------------------
 * Repository interface responsible for performing
 * database operations on the Student entity.
 *
 * By extending JpaRepository, Spring Data JPA
 * automatically provides implementations for:
 *
 * 1. save()        - Insert or update a student.
 * 2. findById()    - Find a student using ID.
 * 3. findAll()     - Retrieve all students.
 * 4. deleteById()  - Delete a student using ID.
 * 5. existsById()  - Check if a student exists.
 * 6. count()       - Count total students.
 *
 * No implementation class is required because
 * Spring Data JPA generates it automatically.
 * ---------------------------------------------------------
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    /*
     * Custom query methods can be added here.
     *
     * Examples:
     *
     * Student findByEmail(String email);
     *
     * List<Student> findBySubject(String subject);
     *
     * List<Student> findByAgeGreaterThan(int age);
     */

}