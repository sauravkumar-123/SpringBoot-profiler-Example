package com.student.Service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.student.RequestPayload.StudentRequest;

@Service
public interface StudentService {
	
	public String addStudent(StudentRequest studentRequest);
	public String deleteStudent(int stuid);
	public List<Map<String,Object>> getAlldata();
	public List<Map<String,Object>> getStudentdata(int stuid);
	public String updateStudentData(int stuid,StudentRequest studentRequest);	
}
