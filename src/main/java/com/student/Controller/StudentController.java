package com.student.Controller;

import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.student.Profile.Profiler;
import com.student.RequestPayload.StudentRequest;
import com.student.Responce.MessageResponce;
import com.student.Service.StudentService;

@RestController
@RequestMapping("/v1/student")
public class StudentController {

	@Autowired
	private StudentService StudentService;
	
	
	
	@PostMapping("/add-student")
	public ResponseEntity<MessageResponce> addStudent(@RequestBody StudentRequest studentRequest){
		String result = StudentService.addStudent(studentRequest);
		if (null != result && result.equals("success")) {
			return new ResponseEntity<>(new MessageResponce(true, "Student Registred", result), HttpStatus.OK);
		} else if(null != result && result.equals("Already Exist")) {
			return new ResponseEntity<>(new MessageResponce(false, "Student Alreday Registred", result), HttpStatus.NOT_ACCEPTABLE);
		}else {
			return new ResponseEntity<>(new MessageResponce(false, "Something Wrong", result), HttpStatus.BAD_REQUEST);
		}
	  }
	
	@DeleteMapping("/delete-student/{stuid}")
	public ResponseEntity<MessageResponce> deleteStudent(@PathVariable("stuid") int stuid){
		String result = StudentService.deleteStudent(stuid);
		if (null != result && result.equals("success")) {
			return new ResponseEntity<>(new MessageResponce(true, "Student Data Deleted", result), HttpStatus.OK);
		} else if(null != result && result.equals("Doesn't Exist")) {
			return new ResponseEntity<>(new MessageResponce(false, "Data Not Found", result), HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(new MessageResponce(false, "Something Wrong", result), HttpStatus.BAD_REQUEST);
		}
	  }
	
	@GetMapping("/getall-student")
	public ResponseEntity<MessageResponce> getAllStudent(){
		List<Map<String, Object>> result = StudentService.getAlldata();
		if (null != result && !result.isEmpty()) {
			return new ResponseEntity<>(new MessageResponce(true, "Student Details Fetched", result), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new MessageResponce(false, "Data Not Found", result), HttpStatus.NOT_FOUND);
		}
	  }
	
	@GetMapping("/get-student-by-id/{stuid}")
	public ResponseEntity<MessageResponce> getSingleStudentdata(@PathVariable("stuid") int stuid){
		List<Map<String, Object>> result = StudentService.getStudentdata(stuid);
		if (null != result && !result.isEmpty()) {
			return new ResponseEntity<>(new MessageResponce(true, "Student Detail Fetched", result), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new MessageResponce(false, "Data Not Found", result), HttpStatus.NOT_FOUND);
		}
	  }
	
	@PutMapping("/update-studentdata/{stuid}")
	public ResponseEntity<MessageResponce> updateStudentData(@PathVariable("stuid") int stuid,@RequestBody StudentRequest studentRequest){
		String result = StudentService.updateStudentData(stuid,studentRequest);
		if (null != result && result.equals("success")) {
			return new ResponseEntity<>(new MessageResponce(true, "Student Data Updated", result), HttpStatus.OK);
		} else if(null != result && result.equals("Doesn't Exist")) {
			return new ResponseEntity<>(new MessageResponce(false, "Student Data Not Found", result), HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(new MessageResponce(false, "Something Wrong", result), HttpStatus.BAD_REQUEST);
		}
	  }
	}
