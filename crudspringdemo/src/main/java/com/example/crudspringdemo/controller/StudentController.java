package com.example.crudspringdemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudspringdemo.entity.Student;
import com.example.crudspringdemo.service.StudentService;

/**
 * ---------------------------------------------------------
 * Student Controller
 * ---------------------------------------------------------
 * This controller handles all REST API requests related to
 * Student operations.
 *
 * It provides APIs for:
 * 1. Create Student
 * 2. Get Student by ID
 * 3. Get All Students
 * 4. Update Student
 * 5. Delete Student
 * ---------------------------------------------------------
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {

    /**
     * Service layer dependency.
     * All business logic is handled in the service layer.
     */
    private final StudentService studentService;

    /**
     * Constructor Injection.
     *
     * Spring automatically injects StudentService.
     *
     * @param studentService Service class
     */
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * ---------------------------------------------------------
     * Create a New Student
     * ---------------------------------------------------------
     *
     * URL:
     * POST /api/student/create
     *
     * @param student Student details received from request body
     * @return Created Student with HTTP Status 201 (CREATED)
     */
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        // Save student using service layer
        Student createdStudent = studentService.createStudent(student);

        // Return created student with HTTP 201
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    /**
     * ---------------------------------------------------------
     * Get Student By ID
     * ---------------------------------------------------------
     *
     * URL:
     * GET /api/student/get/{id}
     *
     * @param id Student ID
     * @return Student details if found,
     *         otherwise HTTP 404 (NOT FOUND)
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {

        // Fetch student from service layer
        Student student = studentService.getStudent(id);

        // Check if student exists
        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        // Return student details
        return ResponseEntity.ok(student);
    }

    /**
     * ---------------------------------------------------------
     * Get All Students
     * ---------------------------------------------------------
     *
     * URL:
     * GET /api/student/getAll
     *
     * @return List of all students
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents() {

        // Retrieve all students
        List<Student> students = studentService.getAllStudents();

        // Return 404 if no students are found
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Return student list
        return ResponseEntity.ok(students);
    }

    /**
     * ---------------------------------------------------------
     * Update Student
     * ---------------------------------------------------------
     *
     * URL:
     * PUT /api/student/update/{id}
     *
     * @param id Student ID
     * @param studentRequest Updated student information
     * @return Updated student if found,
     *         otherwise HTTP 404
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student studentRequest) {

        // Update student
        Student updatedStudent = studentService.updateStudent(id, studentRequest);

        // Check if student exists
        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }

        // Return updated student
        return ResponseEntity.ok(updatedStudent);
    }

    /**
     * ---------------------------------------------------------
     * Delete Student
     * ---------------------------------------------------------
     *
     * URL:
     * DELETE /api/student/delete/{id}
     *
     * @param id Student ID
     * @return Success or failure message
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {

        // Delete student using service layer
        boolean isDeleted = studentService.deleteStudent(id);

        // If student does not exist
        if (!isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Student record not found.");
        }

        // Student deleted successfully
        return ResponseEntity.ok("Student record deleted successfully.");
    }
}