package com.greatlearning.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.entities.Student;

public interface StudentService {
	public void saveStudent(Student student);
	public void updateStudent(Student student, Integer studentId);
	public List<Student> getAllStudents();
	public Student getStudentById(Integer studentId);
	public void deleteStudent(Integer studentId);
	
}
