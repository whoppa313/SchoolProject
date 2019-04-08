package lexicon.se.groupassignment.schoolAssignment.data_access;

import java.util.List;
import java.util.Optional;

import lexicon.se.groupassignment.schoolAssignment.models.Student;

public interface StudentDao {
	
	Student saveStudent(Student student);
	
	boolean deleteStudent(Student student);
	
	Student findByEmail(String email);
	
	List<Student> findByName(String name);
	
	Student findById(int id);
	
	List<Student> findAll();
	
}
