package lexicon.se.groupassignment.schoolAssignment.data_access;

import java.time.LocalDate;
import java.util.List;

import lexicon.se.groupassignment.schoolAssignment.models.Course;

public class CourseDaoListImpl implements CourseDao

{

	
	private static List<Course> courses;

	public static List<Course> getCourses() {
		return courses;
	}

	public static void setCourses(List<Course> courses) {
		CourseDaoListImpl.courses = courses;
	}

	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCourse(Course course) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
