package com.CrudApplication.crud;
//sudo docker run -p 8181:8181 --net=host a53a908564a9
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CrudApplication.crud.Model.Student;
import com.CrudApplication.crud.Model.StudentRepository;

@SpringBootApplication
@RestController
public class CrudApplication {

	@Autowired
	StudentRepository studentRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
	
	  @GetMapping("/test")
	  public String test(){
		  return "Test is working!!!!!!!";
	  }
	
	  @GetMapping("/students")
	  public ResponseEntity<List<Student>> getAllStudents(){
		  return new ResponseEntity<>(studentRepo.findAll(), HttpStatus.OK);
	  }
	  
	  @GetMapping("/student/{id}")
	  public ResponseEntity<Student> getStudentById(@PathVariable("id") int studentId){
		    Optional<Student> foundStudent = studentRepo.findById(studentId);
		    if (foundStudent.isPresent()) {
		      return new ResponseEntity<Student>(foundStudent.get(), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		    }
	  }
	  
	  @PostMapping("/addstudent")
	  public String addStudent(@RequestBody Student student){
		  try {
			  Student newStudent = studentRepo.save(
					  new Student(
							  student.getStudentId(), 
							  student.getFirstName(), 
							  student.getLastName(), 
							  student.getEmail(), 
							  student.getPhoneNumber()
							  )
					  );
			  return "Student added!";
		  } catch(Exception e) {
			  return "Incorrect body format";
		  }
	  }
	  
	  @PostMapping("/updatestudent/{id}")
	  public String updateStudent(@PathVariable("id") int studentId, @RequestBody Student student) {
		  try {
			  Optional<Student> foundStudent = studentRepo.findById(studentId);
			    if (foundStudent.isPresent()) {
			    	Student newStudent = foundStudent.get();
			    	newStudent.setStudentId(studentId);
			    	newStudent.setFirstName(student.getFirstName());
			    	newStudent.setLastName(student.getLastName());
			    	newStudent.setEmail(student.getEmail());
			    	newStudent.setPhoneNumber(student.getPhoneNumber());
			    	studentRepo.save(newStudent);
			    	return "Student with id: " + studentId + " has been updated";
			    } else {
			    	return "Student with id: " + studentId + " is not found";
			    }
		  } catch(Exception e) {
			  return "Something went wrong...";
		  }
	  }
	  
	  
	  @DeleteMapping("/deletestudent/{id}")
	  public String deleteStudentById(@PathVariable("id") int studentId){
		    try {
		        studentRepo.deleteById(studentId);
		        return "Student deleted successfully.";
		      } catch (Exception e) {
		        return "Student could not be found and/or deleted";
		      }
	  }

}
