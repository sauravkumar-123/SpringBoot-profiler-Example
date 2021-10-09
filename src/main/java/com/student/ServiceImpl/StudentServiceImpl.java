package com.student.ServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.student.Dao.StudentRepository;
import com.student.Model.Student;
import com.student.RequestPayload.StudentRequest;
import com.student.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	public final static Logger logger=LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentRepository studentRepository;
	
	//@Value("${student.name:saurav}") //@if you want to use application.proprirites constant then just remove :value OK.
	@Value("#{'${student.name}'=='saurav'?'${student.fathername}':'${student.mothername}'}") //@spring expression language.
	String stuname;
	
	@Value("${student.collage:tit,rbms,rgpv,pgms,edbc,lmpt,lnct,pqrs}")
	String[] clgnamearr;
	
	//@Value("${student.fees:450.87,87451.00,895.78,744.85}")
	@Value("#{'${student.fees}'=='450.87,87451.00,895.78,744.5'?'45.87,200.00,78.85':'780.85,874.85'}")
    List<Double> feeList;
	
	@Value("${student.course:python,java,php,sql,oracle,j2ee,spring}")
    Set<String> courseSet;          
	
	@Value("${student.status:true}")
    boolean status;
	
	//@Value("#{${student.map:{python:900,java:1000,php:2000}}}")
	@Value("#{${student.map}=={python:900,java:1000,php:2000}?{${student.map1}}:{C:6,D:90}}")
    Map<String, Integer> mapvalue;
	
	//@Add Student data in table.
	public String addStudent(StudentRequest studentRequest) {
		Student student=studentRepository.findByStudentId(studentRequest.getStudentid());
        if (null==student) {
			Student stu=new Student();
			stu.setStudentId(studentRequest.getStudentid());
			stu.setStudentName(studentRequest.getStudentname());
			stu.setStudentdob(StringConvertedToDate(studentRequest.getDob()));
			stu.setStudentdoj(StringConvertedToDate(studentRequest.getDoj()));
			studentRepository.save(stu);
		}else {
			return "Already Exist";
		}
	 return "success";
   }

	//@Delete Student data from table.
	public String deleteStudent(int stuid) {
		Student student=studentRepository.findByStudentId(stuid);
		if(null!=student) {
			studentRepository.delete(student);
		}else {
			return "Doesn't Exist";
		}
	  return "success";
	}

	//@get All Student Data.
	public List<Map<String, Object>> getAlldata() {
		List<Map<String, Object>> list=new ArrayList<>();
		Map<String, Object> map=new HashMap<>();
		List<Student> studentlist=studentRepository.findAll();
		if(null!=studentlist && !studentlist.isEmpty()) {
			for(Student student:studentlist) {
				map.put("StudentID", student.getStudentId());
				map.put("StudentName", student.getStudentName());
				map.put("DOB", student.getStudentdob());
				map.put("DOJ", student.getStudentdoj());
			}
			list.add(map);
		}else {
			return list;
		}
		
	System.out.println("Student Name: "+stuname);	
	System.out.println("Student Collage: "+clgnamearr.length);	
	System.out.println("Fee list: "+ feeList);	
	System.out.println("Course set: "+ courseSet);
	System.out.println("Student status: "+ status);
	System.out.println("Student mapvalue: "+ mapvalue);
	
	logger.info("I AM INFO");
	logger.warn("I AM WARN");
	logger.error("I AM ERROR", list);
	logger.debug("I AM Debugger");
	logger.trace("I AM Tracer");
	 return list;
  }

	//@get a single student data.
	public List<Map<String, Object>> getStudentdata(int stuid) {
		List<Map<String, Object>> list=new ArrayList<>();
		Student student=studentRepository.findByStudentId(stuid);
		if(null!=student) {
			Map<String, Object> map=new HashMap<>();
				map.put("StudentID", student.getStudentId());
				map.put("StudentName", student.getStudentName());
				map.put("DOB", student.getStudentdob());
				map.put("DOJ", student.getStudentdoj());
			    list.add(map);
		}else {
			return list;
		}
	 return list;
	}

	//@update student data.
	public String updateStudentData(int stuid,StudentRequest studentRequest) {
		Student student=studentRepository.findByStudentId(stuid);
		if(null!=student) {
			student.setStudentName(studentRequest.getStudentname());
			student.setStudentdob(StringConvertedToDate(studentRequest.getDob()));
			student.setStudentdoj(StringConvertedToDate(studentRequest.getDoj()));
			studentRepository.save(student);
		}else {
			return "Doesn't Exist";
		}
	  return "success";
	}
	
	public Date StringConvertedToDate(String stringdate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(stringdate);
			System.out.println(date + "\t" + stringdate);
		}catch (ParseException e) {
			e.printStackTrace();
		}
	  return date;
	}
}
