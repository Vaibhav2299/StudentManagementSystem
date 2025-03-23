package com.student.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main4 {
	
	public static List<Student> student ;
	
	public static void main(String[] args) {
		
		System.out.println("***************Student Management System!******************");
		
		System.out.println("***************Welcome To Student Management System!******************");
		
		student = new ArrayList<Student>();
		
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
		
		student.add(s1);
		student.add(s2);
		student.add(s3);

//		s1.printStudentInfo(); //constmize function printing data
//		s2.printStudentInfo();
//		s3.printStudentInfo();
		//System.out.println(s1); //to String Method printing data
		Student result= findStudentById("S-3");
		System.out.println("Result  "+ result);
		
		sortByName();
	}
	
	private static void sortByName() {
		Comparator< Student> studentNameComparator = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(student,studentNameComparator);
		System.out.println(student);
		
	}

	public static Student findStudentById(String studentId) {
		
		Student result = null;
		try {
			result = student.stream().filter(x->x.getStudentId().equalsIgnoreCase(studentId)).findFirst().
			orElseThrow(()-> new RuntimeException("No Data Found!"));
			
			
		} catch (RuntimeException e) {
			System.err.println("No Data Found ! For Student Id "+ studentId);
		}
		
		return result;
	}

}
