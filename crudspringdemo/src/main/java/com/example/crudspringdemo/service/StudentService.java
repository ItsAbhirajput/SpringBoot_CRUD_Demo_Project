package com.example.crudspringdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.crudspringdemo.entity.Student;
import com.example.crudspringdemo.reposatory.StudentRepository;

/**
 * ---------------------------------------------------------
 * Student Service
 * ---------------------------------------------------------
 * This service class contains the business logic for
 * Student operations.
 *
 * Responsibilities:
 * 1. Create Student
 * 2. Get Student by ID
 * 3. Get All Students
 * 4. Update Student
 * 5. Delete Student
 *
 * The controller communicates with this service,
 * and this service communicates with the repository.
 * ---------------------------------------------------------
 */
@Service
public class StudentService {

    /**
     * Repository used to perform database operations.
     */
    private final StudentRepository studentRepository;

    /**
     * Constructor Injection.
     *
     * Spring automatically injects the repository.
     *
     * @param studentRepository Repository layer
     */
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * ---------------------------------------------------------
     * Create Student
     * ---------------------------------------------------------
     *
     * Saves a new student record into the database.
     *
     * @param student Student object received from Controller
     * @return Saved Student object
     */
    public Student createStudent(Student student) {

        // Save student into database
        Student savedStudent = studentRepository.save(student);

        // Return saved student
        return savedStudent;
    }

    /**
     * ---------------------------------------------------------
     * Get Student By ID
     * ---------------------------------------------------------
     *
     * Searches for a student using the given ID.
     *
     * @param id Student ID
     * @return Student if found, otherwise null
     */
    public Student getStudent(Long id) {

        // Find student by ID
        Optional<Student> student = studentRepository.findById(id);

        // Check whether the student exists
        if (student.isPresent()) {
            return student.get();
        }

        // Student not found
        return null;
    }

    /**
     * ---------------------------------------------------------
     * Get All Students
     * ---------------------------------------------------------
     *
     * Retrieves all student records from the database.
     *
     * @return List of students
     */
    public List<Student> getAllStudents() {

        // Fetch all students
        return studentRepository.findAll();
    }

    /**
     * ---------------------------------------------------------
     * Update Student
     * ---------------------------------------------------------
     *
     * Updates an existing student's details.
     *
     * @param id Student ID
     * @param studentRequest Updated student information
     * @return Updated student if found, otherwise null
     */
    public Student updateStudent(Long id, Student studentRequest) {

        // Search for student by ID
        Optional<Student> existingStudent = studentRepository.findById(id);

        // Check whether student exists
        if (existingStudent.isEmpty()) {
            return null;
        }

        // Retrieve existing student object
        Student student = existingStudent.get();

        // Update student details
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setSubject(studentRequest.getSubject());
        student.setAge(studentRequest.getAge());
        student.setRollNo(studentRequest.getRollNo());

        // Save updated student
        return studentRepository.save(student);
    }

    /**
     * ---------------------------------------------------------
     * Delete Student
     * ---------------------------------------------------------
     *
     * Deletes a student using the given ID.
     *
     * @param id Student ID
     * @return true if deleted successfully,
     *         false if student does not exist
     */
    public boolean deleteStudent(Long id) {

        // Check if student exists
        boolean studentExists = studentRepository.existsById(id);

        // Return false if student is not found
        if (!studentExists) {
            return false;
        }

        // Delete student from database
        studentRepository.deleteById(id);

        // Return success
        return true;
    }
}