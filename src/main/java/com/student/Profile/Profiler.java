package com.student.Profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Profiler {
 
	@Profile("dev")
	@Bean
	public void getDevEnvironment() {
		System.out.println("**********I am from DEV Environment***********");
	}
	
	@Profile("qa")
	@Bean
	public void getQaEnvironment() {
		System.out.println("**********I am from QA Environment***********");
	}
	
	@Profile("prod")
	@Bean
	public void getProdEnvironment() {
		System.out.println("**********I am from PROD Environment***********");
	}
	
	/*@Profile("dev")
	@Bean
	public void getDefaultEnvironment() {
		System.out.println("**********I am from DEFAULT Environment***********");
	}*/
	
	@Profile("uat")
	@Bean
	public void getUatEnvironment() {
		System.out.println("**********I am from UAT Environment***********");
	}
	
	@Profile("apisaurav")
	@Bean
	public void getApiSauravEnvironment() {
		System.out.println("**********I am from APISaurav Environment***********");
	}
}
