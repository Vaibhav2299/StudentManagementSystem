package com.student.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<Student> studentList;
	private static Scanner scanner;

	public static void main(String[] args) {

		System.out.println("***************Student Management System!******************");

		System.out.println("***************Welcome To Student Management System!******************");

		studentList = new ArrayList<Student>();
		scanner = new Scanner(System.in);

		while (true) {
			System.out.println("***************Welcome !************");
			System.out.println("Select an Option...");

			System.out.println("1. Register a Student:");
			System.out.println("2. Find Student with studentId:");
			System.out.println("3. List Off All Student Information:");
			System.out.println("4. List Student Information in Sorted Order:");
			System.out.println("5. Exit:");

			int option = scanner.nextInt();

			switch (option) {

			case 1:
				enrollStudent(scanner);
				break;

			case 2:
				findStudentById(scanner);
				break;

			case 3:
				printAllStudentData();
				break;

			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("Invalid Option Selected!.... Enter Between 1 to 5");

			}
		}

	}

	private static void findStudentById(Scanner scanner2) {
		Student findStudent = null;
		System.out.println("Enter the StudentId");
		String studentId = scanner2.next();
		try {
			findStudent = studentList.stream().filter(student->student.getStudentId().equalsIgnoreCase(studentId)).findFirst().orElseThrow(()-> new RuntimeException("No Data Found!"));
			
			
		} catch (RuntimeException e) {
			System.err.println("No Data Found ! For Student Id "+ scanner2);
		}
		
		findStudent.printStudentInfo();

	}

	private static void exit() {
		System.out.println("Thanks For using Student Management System Hope You Enjoyed it!");
		System.exit(0);

	}

	private static void sortByName() {
		Comparator< Student> studentNameComparator = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(studentList,studentNameComparator);
		printAllStudentData();

	}

	private static void printAllStudentData() {

		if (studentList.size() > 0) {
			System.out.println("Printing All Student Data");

			for (Student student : studentList) {
				student.printStudentInfo();
			}

			System.out.println("**************************************");
		} else {
			System.err.println("No Student Record Find	!");
		}

	}

	private static void enrollStudent(Scanner scanner2) {
		System.out.println("Enter Student Name");
		String studentName = scanner2.next();

		System.out.println("Enter Student Age");
		int studentAge = scanner2.nextInt();

		System.out.println("Enter Student Id");
		String studentId = scanner2.next();

		Student newStudent = new Student(studentName, studentAge, studentId);

		studentList.add(newStudent);

		while (true) {
			System.out.println("Enter the course to enrolled!!... Type Done to Exit!");
			String courseName = scanner2.next();

			if (courseName.equalsIgnoreCase("done")) {
				break;
			}

			newStudent.enrollCourse(courseName);
		}

		newStudent.printStudentInfo();

	}

//	public static Student findStudentById(String scanner2) {
//		
//		Student result = null;
//		try {
//			result = student.stream().filter(x->x.getStudentId().equalsIgnoreCase(scanner2)).findFirst().
//			orElseThrow(()-> new RuntimeException("No Data Found!"));
//			
//			
//		} catch (RuntimeException e) {
//			System.err.println("No Data Found ! For Student Id "+ scanner2);
//		}
//		
//		return result;
//	}

}
