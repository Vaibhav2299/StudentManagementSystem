package com.student.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private static List<Student> studentList;

	public static void main(String[] args) {

		System.out.println("***************Student Management System!******************");

		System.out.println("***************Welcome To Student Management System!******************");

		studentList = new ArrayList<Student>();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Student Name:");
		
		String name = sc.next();
		
		System.out.println("You Have Entered Name: "+name);
		
		//read integer value 
		
		System.out.println("Enter Student Age:");
		
		int age = sc.nextInt();
		
		System.out.println("You Have Age: "+age);
		
		
		
	}

}
