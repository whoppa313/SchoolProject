package lexicon.se.groupassignment.schoolAssignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lexicon.se.groupassignment.schoolAssignment.models.Course;
import lexicon.se.groupassignment.schoolAssignment.models.Student;

import lexicon.se.groupassignment.schoolAssignment.data_access.StudentDao;
import lexicon.se.groupassignment.schoolAssignment.data_access.StudentDaoListImpl;
import lexicon.se.groupassignment.schoolAssignment.data_access.CourseDao;
import lexicon.se.groupassignment.schoolAssignment.data_access.CourseDaoListImpl;


public class App 
{
	private static StudentDao studentDao = StudentDaoListImpl.get();	
	private static CourseDao courseDao = CourseDaoListImpl.get();
 	
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
	
	public static void createNewStudent(Student newStudent) {		//Method for creating new Student
		boolean available = true;
		boolean validId = true;
		
		while (validId) {
			System.out.println("Enter the Student Id:");		
			int studentId = getIntFromUser();
			if (studentDao.findById(studentId) == null) {
				newStudent.setId(studentId);
				validId = false;
			}else {
				System.out.println("This id is not available. Try again!");
			}
		}
		
		
		System.out.println("Enter the Student Name:");	
		newStudent.setName(getStringFromUser());
		
		while (available){
			System.out.println("Enter the Student Email:");	
			String studentEmail = getStringFromUser();
			if (studentDao.findByEmail(studentEmail) == null) {
				newStudent.setEmail(studentEmail);
				available = false;
			}else {
				System.out.println("This Email is not available. Try again!");
			}
		}
		
		System.out.println("Enter the Student Address:");	
		newStudent.setAddress(getStringFromUser());
		
		studentDao.saveStudent(newStudent);			//Add Student to the list
	}
	
	public static void createNewCourse(Course newCourse) {	//Method for creating a new course
		
		System.out.println("Enter the Course Id:");		
		newCourse.setId(getIntFromUser());				
		
		System.out.println("Enter the Course Name:");	
		newCourse.setCourseName(getStringFromUser());
		
		System.out.println("Enter the Start Date:");	
		LocalDate startDay = CourseStartDate();			
		newCourse.setStartDate(startDay);
		
		System.out.println("Enter the Week duration:");	
		newCourse.setWeekDuration(getIntFromUser());
		
		courseDao.saveCourse(newCourse);				//Add Course to courseList
	}

	public static LocalDate CourseStartDate() {			//Method for collecting the date
		System.out.println("Enter the Year:");
		int year = getIntFromUser();	
		
		System.out.println("Enter the Month (1-12):");
		int month = getIntFromUser();	
		
		System.out.println("Enter the Day:");
		int day = getIntFromUser();	
		
		LocalDate startDay = LocalDate.of(year, month, day);
		
		return startDay;
	}
	
	public static void addStudentToCourse() {			//Method for adding a student to a course
		Course temporyCourse = new Course();
		Student temporyStudent = new Student();
		List<Student> tempStudentList = new ArrayList<>();
		
		System.out.println("Enter the Course Id:");	
		temporyCourse = courseDao.findById(getIntFromUser());		//The course
		System.out.println(temporyCourse);
		tempStudentList = temporyCourse.getStudents();				//List of students for the course
		
		System.out.println("Enter the Student Id:");	
		temporyStudent = studentDao.findById(getIntFromUser());		//Student to be added
		System.out.println(temporyStudent);
		
		tempStudentList.add(temporyStudent);						//Add student to the course
		System.out.println(temporyCourse);
	}
	
	public static void removeStudentFromCourse() {		//Method for removing a student from a course
		Course temporyCourse = new Course();
		Student temporyStudent = new Student();
		List<Student> tempStudentList = new ArrayList<>();
	
		System.out.println("Enter the Course Id:");	
		temporyCourse = courseDao.findById(getIntFromUser());		//The course
		System.out.println(temporyCourse);
		tempStudentList = temporyCourse.getStudents();				//List of students for the course
	
		System.out.println("Enter the Student Id:");	
		temporyStudent = studentDao.findById(getIntFromUser());		//Student to be removed
		System.out.println(temporyStudent);
	
		tempStudentList.remove(temporyStudent);						//Remove student from the course
		System.out.println(temporyCourse);
	}
	
	public static void initialCreation () {		//Initial creation of Students and Courses
		
		//-------------- STUDENTS -------------
		//List of Students
		Student[] student = new Student[10];		
    	student[0] = new Student(201,"Malin Svensson", "malin.svensson@gmail.com", "Ringvägen 14");
    	student[1] = new Student(202,"Knut Andersson", "knut.andersson@gmail.com", "Saltsjövägen 21");
    	student[2] = new Student(203,"Sofia Jönsson", "sofia.jonsson@gmail.com", "Kalkstensgatan 26");
    	student[3] = new Student(204,"Lars Bengtson", "lars.bengtsson@gmail.com", "Olyckstrappan 89");
    	student[4] = new Student(205,"Anna Johnsson", "anna.johnsson@gmail.com", "Semlevägen 48");
    	student[5] = new Student(206,"Bo Lundqvist", "bo.lundqvist@gmail.com", "Philotrap 18");
    	student[6] = new Student(207,"Anja Runesson", "anja.runesson@gmail.com", "Kopparberg 2");
    	student[7] = new Student(208,"Börje Antonsson", "borje.antonsson@gmail.com", "Storgatan 11");
    	student[8] = new Student(209,"Hans Trestjärna", "hans.trestjarna@gmail.com", "Oljefläcken 4");
    	student[9] = new Student(210,"Sanna Johansson", "sanna.johansson@gmail.com", "Fridlevsgatan 20");
    	
    	//Save students to "studentList"
    	studentDao.saveStudent(student[0]);
    	studentDao.saveStudent(student[1]);
    	studentDao.saveStudent(student[2]);
    	studentDao.saveStudent(student[3]);
    	studentDao.saveStudent(student[4]);
    	studentDao.saveStudent(student[5]);
    	studentDao.saveStudent(student[6]);
    	studentDao.saveStudent(student[7]);
    	studentDao.saveStudent(student[8]);
    	studentDao.saveStudent(student[9]);
    	
    	//-------------- COURSES -------------
    	
		//Startdates for each Course
		LocalDate english = LocalDate.of(2019, 3, 6);
		LocalDate math = LocalDate.of(2019, 4, 8);
		LocalDate java = LocalDate.of(2019, 2, 18);
		LocalDate html = LocalDate.of(2019, 4, 22);
		LocalDate agile = LocalDate.of(2019, 5, 20);
				
		//List of Students for each Course
		List<Student> englishStudents = new ArrayList<>();
		List<Student> mathStudents = new ArrayList<>();
		List<Student> javaStudents = new ArrayList<>();
		List<Student> htmlStudents = new ArrayList<>();
		List<Student> agileStudents = new ArrayList<>();
				
		//List of Courses
		Course englishCourse = new Course(101, "English class", english, 6, englishStudents);	
		Course mathCourse = new Course(102, "Math class", math, 8, mathStudents);
		Course javaCourse = new Course(103, "Java Programming", java, 10, javaStudents);
		Course htmlCourse = new Course(104, "HTML Programming", html, 4, htmlStudents);
		Course agileCourse = new Course(105, "Agile Software Development", agile, 3, agileStudents);
		
		//Save Courses to "courseList"
		courseDao.saveCourse(englishCourse);
		courseDao.saveCourse(mathCourse);
		courseDao.saveCourse(javaCourse);
		courseDao.saveCourse(htmlCourse);
		courseDao.saveCourse(agileCourse);
		
		//A couple of students for each course
		englishStudents.add(student[0]);
		englishStudents.add(student[2]);
		englishStudents.add(student[5]);
		mathStudents.add(student[1]);
		mathStudents.add(student[3]);
		javaStudents.add(student[2]);
		javaStudents.add(student[5]);
		javaStudents.add(student[6]);
		javaStudents.add(student[7]);
		htmlStudents.add(student[8]);
		agileStudents.add(student[9]);
		
		   	
	}
	
//****************************** MAIN *************************************

	public static void main( String[] args ){
		boolean keepLooping = true;
		String selection = "";
		
		//Service service = new Service();
		//service.initialCreation();
    	
		initialCreation();			
		
		
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
					"<ASC>	Add Student to a Course \n" +
					"<RSC>	Remove Student from a Course \n" +
					"\n" +
    				"<Q>	Quit = Exit the system\n" + 
    				"\nYour selection: "
    				);
    		
    		selection = scanner.nextLine();
    		
    		
    		switch (selection.toLowerCase()) {
				case "ls":System.out.println("List ALL the students in the list");
						System.out.println(studentDao.findAll());
					break;
				case "si":System.out.println("Find Student by Id");
						System.out.println("Enter the Student Id:");	
						System.out.println(studentDao.findById(getIntFromUser()));
					break;
				case "sn":System.out.println("Find Student by Name");
						System.out.println("Enter the Student Name:");
						System.out.println(studentDao.findByName(getStringFromUser()));
					break;
				case "se":System.out.println("Find Student by Email");
						System.out.println("Enter the Student Email:");
						System.out.println(studentDao.findByEmail(getStringFromUser()));
					break;
				case "as":System.out.println("Add a new Student to the list");
						Student newStudent = new Student();			
						createNewStudent(newStudent);		//Create a new student
						System.out.println(newStudent); 	//Prints out the new student
					break;
				case "ds":System.out.println("Delete a Student from the list");											
						System.out.println("Enter the Student Id:");
						studentDao.deleteStudent(studentDao.findById(getIntFromUser()));
					break;
				case "lc":System.out.println("List ALL the Courses in the list");
						System.out.println(courseDao.findAll());
					break;
				case "ci":System.out.println("Find Course by Id");
						System.out.println("Enter the Course Id:");	
						System.out.println(courseDao.findById(getIntFromUser()));
					break;
				case "cn":System.out.println("Find Course by Name");
						System.out.println("Enter the Course Name:");
						System.out.println(courseDao.findByName(getStringFromUser()));
					break;
				case "cd":System.out.println("Find Course by Date");
						LocalDate startDay = CourseStartDate();
						System.out.println(courseDao.findByDate(startDay));
					break;
				case "ac":System.out.println("Add a new Course to the list");
						Course newCourse = new Course();			
						createNewCourse(newCourse);		//Create a new Course
						System.out.println(newCourse); 	//Prints out the new Course
					break;
				case "dc":System.out.println("Delete a Course from the list");		
						System.out.println("Enter the Course Id:");
						courseDao.removeCourse(courseDao.findById(getIntFromUser()));
					break;	
				case "asc":System.out.println("Add a student to a course");
						addStudentToCourse();
					break;
				case "rsc":System.out.println("Remove a student from a course");
					removeStudentFromCourse();
					break;
				case "q":
					keepLooping = false;
					System.out.println("You exited the system - Welcome back!");
					StudentDaoListImpl.clear();
					CourseDaoListImpl.clear();
					break;
    		
				default:
					break;
			}
    	}
    }
	
}
