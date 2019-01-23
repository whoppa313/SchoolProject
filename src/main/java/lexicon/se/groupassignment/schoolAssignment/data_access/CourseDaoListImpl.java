package lexicon.se.groupassignment.schoolAssignment.data_access;

import java.util.List;

import lexicon.se.groupassignment.schoolAssignment.models.Course;

public class CourseDaoListImpl

{

	
	private static List<Course> courses;

	public static List<Course> getCourses() {
		return courses;
	}

	public static void setCourses(List<Course> courses) {
		CourseDaoListImpl.courses = courses;
	}
	
	
}
