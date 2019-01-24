package lexicon.se.groupassignment.schoolAssignment;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lexicon.se.groupassignment.schoolAssignment.data_access.StudentDao;
import lexicon.se.groupassignment.schoolAssignment.data_access.StudentDaoListImpl;
import lexicon.se.groupassignment.schoolAssignment.models.Student;

public class StudentTest {
	
	//This is what we are going to test
		private StudentDao duringTest = new StudentDaoListImpl();
		
		private Student testStudent;
		private int testStudentId;
		
	//Runs BEFORE each test
			@Before
			public void init() {
				testStudent = new Student(1, "Maria", "maria.hofstam@gmail.com");
				duringTest.saveStudent(testStudent);
				testStudentId = testStudent.getId();
				//duringTest.saveStudent(new Student(2, "Johanna"));
			}
			
	//Runs AFTER each test
			@After
			public void tearDown() {
				StudentDaoListImpl.clear();
			}
			
	//Test cases
			
			@Test
			public void test_save_new_student() {
				Student expected = new Student(1, "Maria", "maria.hofstam@gmail.com");
				assertEquals(expected, duringTest.saveStudent(expected));
			}	

}
