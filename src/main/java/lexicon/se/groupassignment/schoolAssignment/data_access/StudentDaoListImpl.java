package lexicon.se.groupassignment.schoolAssignment.data_access;

import java.util.*;

import lexicon.se.groupassignment.schoolAssignment.models.Student;



public class StudentDaoListImpl implements StudentDao{
	
	private static List<Student> studentList; 		//THE LIST!!!

	private StudentDaoListImpl(){
		studentList = new ArrayList<>();
	}
	
	
	private static final StudentDao instance;		
	
	static {
		instance = new StudentDaoListImpl();
	}
	
	public static StudentDao get() {	//Used in App-class for creating an instance of studentDao
		return instance;
	}
	
	
//--------------------------------------------------------
	@Override
	public Student saveStudent(Student student) {
		studentList.add(student);
		return student;
	}
	
	@Override
	public boolean deleteStudent(Student student) {
		if(student == null) {
			return false;
		}
		
		if(!studentList.contains(student)) {
			return false;
		}
		
		return studentList.remove(student);
	}

	@Override
	public Student findByEmail(String email) {		
		for(Student s : studentList) {
			if(s.getEmail().toLowerCase().contains(email.toLowerCase())) {
				return s;
			}
		}
		return null;
	}


	@Override
	public Student findById(int id) {
		for(Student s : studentList) {
			if(s.getId() == id) {
				return s;
			}
		}
		return null;
	}
	
	@Override
	public List<Student> findByName(String name) {
		
		List<Student> result = new ArrayList<>();	//Create a new list containing all students with the same name
		
			for(Student s: studentList) {
				if(s.getName().toLowerCase().contains(name.toLowerCase())) {
					result.add(s);
				}
			}
			return result;
	
	}

	@Override
	public List<Student> findAll() {		
		List<Student> result = new ArrayList<>();
		
		for(Student s : studentList) {
			if(s instanceof Student) {
				result.add((Student) s);
			}
		}
			return result;
		
	}
	
	

	public static void clear() {
		studentList.clear();
	}

}
