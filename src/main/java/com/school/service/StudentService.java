package com.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.Student;
import com.school.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Optional<Student> getStudentById(Long id) {
		return studentRepository.findById(id);
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
	
	 public Student updateStudent(Long id, Student updatedStudent) {
	        Optional<Student> existingStudentOptional = studentRepository.findById(id);

	        if (existingStudentOptional.isPresent()) {
	            Student existingStudent = existingStudentOptional.get();
	            existingStudent.setFirstName(updatedStudent.getFirstName());
	            existingStudent.setLastName(updatedStudent.getLastName());
	            existingStudent.setAge(updatedStudent.getAge());
	            existingStudent.setCity(updatedStudent.getCity());
	            return studentRepository.save(existingStudent);
	        }

	        return null; 
	    }
	
}
