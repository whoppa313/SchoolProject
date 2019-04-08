package lexicon.se.groupassignment.schoolAssignment;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lexicon.se.groupassignment.schoolAssignment.data_access.StudentDao;
import lexicon.se.groupassignment.schoolAssignment.data_access.StudentDaoListImpl;
import lexicon.se.groupassignment.schoolAssignment.models.Student;

public class StudentTest {
	
	//This is what we are going to test
		private StudentDao duringTest = StudentDaoListImpl.get();
		
		private Student testStudent;
		private int testStudentId;
		private String testStudentName;
		private String testStudentEmail;
		
	//Runs BEFORE each test
			@Before
			public void init() {
				testStudent = new Student(1, "Maria", "maria.hofstam@gmail.com");
				duringTest.saveStudent(testStudent);
				testStudentId = testStudent.getId();
				testStudentName = testStudent.getName();
				testStudentEmail = testStudent.getEmail();
			}
		
	//Test cases
		
			
			@Test
			public void test_find_student_byId() {
				Student expected = testStudent;
				assertEquals(expected, duringTest.findById(testStudentId));
			}
			
			
			@Test
			public void test_find_student_byName() {
				List <Student> expected = Arrays.asList(testStudent);
				assertEquals(expected, duringTest.findByName(testStudentName));
			}
			
			
			@Test
			public void test_find_student_byEmail() {
				Student expected = testStudent;
				assertEquals(expected, duringTest.findByEmail(testStudentEmail));
			}
			
			
		
			
	//Runs AFTER each test
			@After
			public void tearDown() {
				StudentDaoListImpl.clear();
			}
}
