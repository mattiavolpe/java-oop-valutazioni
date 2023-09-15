package org.lessons.java.valutazioni;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		
		Studente[] students = new Studente[20];
		Random rnd = new Random();
		
		byte admitted = 0;
		
		for (byte i = 0; i < students.length; i++) {
			students[i] = new Studente();
			students[i].id = i + 1;
			students[i].absencePercentage = rnd.nextInt(101);
			students[i].avg = (float) rnd.nextInt(501) / 100;
			
			System.out.println("\nID: " + students[i].id + "\nAbsence percentage: " + students[i].absencePercentage + "%\nVote average: " + String.format("%.02f", students[i].avg));
			
			if (students[i].success()) {
				System.out.println("Admitted");
				admitted++;
			} else {
				System.out.println("Not admitted");
			}
		}
		
		System.out.println("\n\nTotal admitted students: " + admitted);
		
		Studente[] admittedStudents = new Studente[admitted];
		Studente[] notAdmittedStudents = new Studente[students.length - admitted];
		
		byte admittedCounter = 0;
		byte notAdmittedCounter = 0;
		
		int minIdIndex = 0;
		int maxIdIndex = 0;
		
		for (byte i = 0; i < students.length; i++) {
			if (students[i].success()) {
				admittedStudents[admittedCounter] = students[i];
				admittedCounter++;
			} else {
				notAdmittedStudents[notAdmittedCounter] = students[i];
				notAdmittedCounter++;
			}
			
			if ((!students[i].success()) && students[i].avg < students[minIdIndex].avg) {
				minIdIndex = i;
			}
			
			if (students[i].success() && students[i].avg > students[maxIdIndex].avg) {
				maxIdIndex = i;
			}
		}
		
		System.out.println("\n\nMin id: " + students[minIdIndex].id);
		System.out.println("Max id: " + students[maxIdIndex].id);
	}
}
