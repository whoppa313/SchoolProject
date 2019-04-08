package lexicon.se.groupassignment.schoolAssignment.data_access;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lexicon.se.groupassignment.schoolAssignment.models.Course;
import lexicon.se.groupassignment.schoolAssignment.models.Student;

public class CourseDaoListImpl implements CourseDao{

	private static List<Course> courseList; 		//THE LIST!!!

	private CourseDaoListImpl(){
		courseList = new ArrayList<>();
	}
	
	
	private static final CourseDao instance;		
	
	static {
		instance = new CourseDaoListImpl();
	}
	
	public static CourseDao get() {	//Used in App-class for creating an instance of CourseDao
		return instance;
	}
	

	//--------------------------------------------------------
	
	@Override
	public Course saveCourse(Course course) {
		courseList.add(course);
		return course;
	}
	
	@Override
	public boolean removeCourse(Course course) {
		
		
			if(course == null) {
				return false;
			}
			
			if(!courseList.contains(course)) {
				return false;
			}
			
			//Check if any students are registered on the course before removing it
			if (course.getStudents().isEmpty()) {
				return courseList.remove(course);
			}else {
				System.out.println("Remove the students on the course first!");
				return false;
			}
		
	}

	@Override
	public Course findById(int id) {
		
			for(Course c : courseList) {
				if(c.getId() == id) {
					return c;
				}
			}
			return null;
	}

	@Override
	public List<Course> findByName(String name) {
		List<Course> result = new ArrayList<>();	//Create a new list containing all courses with the same name
		
		for(Course c: courseList) {
			if(c.getCourseName().toLowerCase().contains(name.toLowerCase())) {
				result.add(c);
			}
		}
		return result;
	}

	@Override
	public List<Course> findByDate(LocalDate date) {
		
		List<Course> result = new ArrayList<>();
		
		for(Course c : courseList) {
			if(c.getStartDate().isEqual(date)) {
				result.add(c);
			}
		}
		return result;
	}

	@Override
	public List<Course> findAll() {
				
			List<Course> result = new ArrayList<>();
			
			for(Course c : courseList) {
				if(c instanceof Course) {
					result.add((Course) c);
				}
			}
			return result;
	}
	
	public static void clear() {
		courseList.clear();
	}
}
