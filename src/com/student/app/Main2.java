package com.student.app;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
	
	public static void main(String[] args) {
		
		System.out.println("***************Student Management System!******************");
		
		System.out.println("***************Welcome To Student Management System!******************");
		
		Student s1 ;
		
		s1= new Student("Vaibhav Kumar", 27, "S-1");
		s1.enrollCourse("Java");
		s1.enrollCourse("Cypress");
		s1.enrollCourse("DSA");
		
		Student s2= new Student("Rohit", 28, "S-2");
		s2.enrollCourse("Java");
		s2.enrollCourse("Cypress");
		s2.enrollCourse("DSA");
		
		Student s3= new Student("Shivam", 29, "S-3");
		s3.enrollCourse("Java");
		s3.enrollCourse("Cypress");
		s3.enrollCourse("DSA");
		

		s1.printStudentInfo(); //constmize function printing data
		s2.printStudentInfo();
		s3.printStudentInfo();
		//System.out.println(s1); //to String Method printing data
	}

}
