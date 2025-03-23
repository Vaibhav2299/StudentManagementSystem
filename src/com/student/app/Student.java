package com.student.app;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;
	private int age;
	private String studentId;
	private List<String> courses;
	

	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>(); // Initialization of courses
		}

	}

	public String getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public List<String> getCourses() {
		return courses;
	}

	private boolean validateStudentId(String studentId) {
		String studentIdRegex = "S-\\d+$";
		Pattern studentPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = studentPattern.matcher(studentId);

		if (studentIdMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Student Id... use the format Eg.. S-1234 ");

		}
		return false;
	}

	public void enrollCourse(String course) {
		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("\n Student is enrolled to " + course + " successfully!!");
			} else {
				System.err.println("\n Student is already enrolled to " + course);
			}
		}

	}

	public void printStudentInfo() {

		System.out.println("===========Student Infromation=============");

		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student Id: " + studentId);
		System.out.println("Enrolled For: " + courses);

	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	// Validation Methods

	public boolean validateAge(int age) {

		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid Age !! Student Age needs to be between 19 and 35");
			return false;
		}
	}

	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Name !! Please enter alphabets only");
			return false;
		}
	}

	public boolean validateCourseName(String course) {

		if (course.equalsIgnoreCase("JAVA") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("CYPRESS")) {
			return true;
		} else {
			System.err.println("Invalid Course Name !! Please Select Course from the List !! [JAVA, CYPRESS, DSA]");
			return false;
		}
	}

}
