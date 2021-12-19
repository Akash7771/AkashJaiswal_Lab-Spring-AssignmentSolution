package com.greatlearning.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.greatlearning.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.greatlearning.entities.Student;
import com.greatlearning.services.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;

	@Override
	@Transactional
	public void saveStudent(Student student) {

		if(student!=null && student.getName()!=null && student.getCountry()!=null && student.getDepartment()!=null){
			studentRepository.save(student);
		}
	}

	@Override
	@Transactional
	public void updateStudent(Student student , Integer studentId) {
		if(studentId!=null){

			Student studentFromDb = getStudentById(studentId);
			if(studentFromDb!=null){
				student.setStudentId(studentId);
				studentRepository.save(student);
			}
		}
	}

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		List<Student> theStudentList = new ArrayList<>();
		Iterable<Student> studentIterable =  studentRepository.findAll();
		studentIterable.forEach(theStudentList::add);

		return theStudentList;

	}

	@Override
	@Transactional
	public Student getStudentById(Integer studentId){
		Optional<Student> theStudent =  studentRepository.findById(studentId);
		return theStudent.orElse(null);
	}

	@Override
	@Transactional
	public void deleteStudent(Integer studentId) {
		if(studentId!=null){
			Student student = getStudentById(studentId);
			if(student!=null){
				studentRepository.delete(student);
			}
		}
	}
}
