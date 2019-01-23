package lexicon.se.groupassignment.schoolAssignment.data_access;

import java.util.*;
import java.util.List;

import lexicon.se.groupassignment.schoolAssignment.models.Student;



public class StudentDaoListImpl implements StudentDao{
	
	private static List<Student> studentList; //- från pdf:en
	
	

	@Override
	public boolean saveStudent(Student student) {
		if(student == null) {
			return false;
		}
		
		//if(findByEmail(student.getEmail()).isPresent()) {
		//	return false;
		//}
		
		if(studentList.contains(student)) {
			return false;
		}
		return studentList.add(student);
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByName(String name) {
		
		List<Student> result = new ArrayList<>();
		
			for(Student s: studentList) {
				if(s.getName().toLowerCase().contains(name.toLowerCase())) {
					result.add(s);
				}
			}
			return result;
	
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
