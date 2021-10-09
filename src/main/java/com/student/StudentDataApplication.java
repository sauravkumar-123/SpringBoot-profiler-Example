package com.student;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student.Profile.Profiler;

@SpringBootApplication
public class StudentDataApplication {
	
	@Value("${spring.profiles.active}")
	private String profile;
	@Autowired
	private Profiler profileconfig;
	
	@PostConstruct
	  public void init(){
	    // Setting Spring Boot SetTimeZone
		System.out.println("**************START INIT***************");
	    TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	    
	    if(profile.equals("dev")) {
	    	profileconfig.getDevEnvironment();
	    }else if (profile.equals("qa")) {
	    	profileconfig.getQaEnvironment();
		}else if (profile.equals("prod")) {
			profileconfig.getProdEnvironment();
		}else if (profile.equals("uat")) {
			 profileconfig.getUatEnvironment();
		}else if (profile.equals("apisaurav")) {
			 profileconfig.getApiSauravEnvironment();
		}else {
			System.out.println("No Profile Found");
		}
	    System.out.println("*************END INIT***************");
	  }
	
	public static void main(String[] args) {
		SpringApplication.run(StudentDataApplication.class, args);
	}
}
