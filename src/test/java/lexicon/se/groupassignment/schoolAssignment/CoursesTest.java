package lexicon.se.groupassignment.schoolAssignment;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lexicon.se.groupassignment.schoolAssignment.data_access.CourseDao;
import lexicon.se.groupassignment.schoolAssignment.data_access.CourseDaoListImpl;
import lexicon.se.groupassignment.schoolAssignment.data_access.StudentDao;
import lexicon.se.groupassignment.schoolAssignment.data_access.StudentDaoListImpl;
import lexicon.se.groupassignment.schoolAssignment.models.Course;
import lexicon.se.groupassignment.schoolAssignment.models.Student;

public class CoursesTest {
	//This is what we are going to test
	
	private CourseDao duringTest = CourseDaoListImpl.get();
	
	private Course testCourse;
	private int testCourseId;
	private String testCourseName;
	private LocalDate testStartDate;
	
	
	//Runs BEFORE each test
	@Before
	public void init() {
		LocalDate testdate = LocalDate.of(2018, 12, 10);
		testCourse = new Course(100, "Testcourse", testdate, 2);	//Create Testcourse
		duringTest.saveCourse(testCourse);							//Save Testcourse to "courseList"
		
		testCourseId = testCourse.getId();
		testCourseName = testCourse.getCourseName();
		testStartDate = testCourse.getStartDate();
	}
	
	//Test cases
	
	@Test
	public void test_find_course_byId() {
		Course expected = testCourse;
		assertEquals(expected, duringTest.findById(testCourseId));
	}
	
	@Test
	public void test_find_course_byName() {
		List <Course> expected = Arrays.asList(testCourse);
		assertEquals(expected, duringTest.findByName(testCourseName));
	}
	
	@Test
	public void test_find_course_byStartDate() {
		List <Course> expected = Arrays.asList(testCourse);
		assertEquals(expected, duringTest.findByDate(testStartDate));
	}
	
	//Runs AFTER each test
	@After
	public void tearDown() {
		CourseDaoListImpl.clear();
	}
}
