package lexicon.se.groupassignment.schoolAssignment;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import lexicon.se.groupassignment.schoolAssignment.models.Course;
import lexicon.se.groupassignment.schoolAssignment.models.Student;

import lexicon.se.groupassignment.schoolAssignment.data_access.StudentDaoListImpl;
import lexicon.se.groupassignment.schoolAssignment.data_access.CourseDaoListImpl;


public class App 
{
 	
	private static Scanner scanner = new Scanner(System.in);
	
	private static String getStringFromUser() {					//method getStringFromUser	
		String text = scanner.nextLine();
		
		return text;
	}
	
	private static int getIntFromUser() {						//method getIntFromUser
		
		boolean valid = false;
		int number = 0;
		while(!valid) {
			try {
				number = Integer.parseInt(getStringFromUser());
				valid = true;				
			}catch(NumberFormatException e) {
				System.out.println("Input was not a number");
			}
		}
		return number;
	}
	
	//****************************** MAIN *************************************

	public static void main( String[] args ){
		boolean keepLooping = true;
		String selection = "";
		
		//private static Course course = new Course();	
		
		Student[] student = new Student[15];		//A couple of students
    	student[0] = new Student(1901,"Malin Svensson", "malin.svensson@gmail.com");
    	student[1] = new Student(1902,"Knut Andersson", "knut.andersson@gmail.com");
    	student[2] = new Student(1903,"Sofia Jönsson", "sofia.jonsson@gmail.com");
    	student[3] = new Student(1904,"Lars Bengtson", "lars.bengtsson@gmail.com");
    	student[4] = new Student(1905,"Anna Johnsson", "anna.johnsson@gmail.com");
    	student[5] = new Student(1906,"Bo Lundqvist", "bo.lundqvist@gmail.com");
    	
    	while(keepLooping) {
    		System.out.print(
    				"        ****************************\n" +
    				"          SCHOOL MANAGEMENT SYSTEM  \n" +
    				"        ****************************\n" +
    				"\n------- Student administration -------\n" + 
    				"<LS>	List Students = List ALL the students in the list\n" +
    				"<SI>	Student Id = Find Student by Id\n" +
    				"<SN>	Student Name = Find Student by Name\n" +
    				"<SE>	Student Email = Find Student by Email\n" +
    				"<AS>	Add Student = Add a new Student to the list\n" +
    				"<DS>	Delete Student = Delete a Student from the list\n" +
    				"\n" +
					"\n------- Courses administration -------\n" + 
					"<LC>	List Courses = List ALL the Courses in the list\n" +
					"<CI>	Course Id = Find Course by Id\n" +
    				"<CN>	Course Name = Find Course by Name\n" +
    				"<CD>	Course Date = Find Course by Date\n" +
					"<AC>	Add Course = Add a new Course to the list\n" +
					"<DC>	Delete Course = Delete a Course from the list\n" +
					"\n" +
    				"<Q>	Quit = Exit the system\n" + 
    				"\nYour selection: "
    				);
    		
    		selection = scanner.nextLine();
    		
    		switch (selection.toLowerCase()) {
				case "ls":							//List ALL the students in the list
					
					
					break;
				case "si":							//Find Student by Id
					System.out.println("Enter the Student Id:");	
					int studentId = getIntFromUser();
					//Some code please
					break;
				case "sn":							//Find Student by Name
				
					
					break;
				case "se":							//Find Student by Email
				
					break;
				case "as":							//Add a new Student to the list
				
					break;
				case "ds":							//Delete a Student from the list
				
					break;
				case "lc":							//List ALL the Courses in the list
				
					break;
				case "ci":							//Find Course by Id
					System.out.println("Enter the Course Id:");	
					int courseId = getIntFromUser();
					//Some code please
					break;
				case "cn":							//Find Course by Name
				
					break;
				case "cd":							//Find Course by Date
				
					break;
				case "ac":							//Add a new Course to the list
				
					break;
				case "dc":							//Delete a Course from the list
				
					break;					
				case "q":
					keepLooping = false;
					System.out.println("You exited the system - Welcome back!");
					break;
    		
				default:
					break;
			}
    	}
    }
	
}
