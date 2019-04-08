package lexicon.se.groupassignment.schoolAssignment.models;

import java.time.LocalDate;
import java.util.List;

public class Course 
{

	private int id;
	private String courseName;
	private LocalDate startDate;
	private int weekDuration;
	private List<Student> students;
	
	//Constructors
	
	public Course(int id, String courseName, LocalDate startDate, int weekDuration, List<Student> students) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.startDate = startDate;
		this.weekDuration = weekDuration;
		this.students = students;
	}
	
	public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
		this.id = id;
		this.courseName = courseName;
		this.startDate = startDate;
		this.weekDuration = weekDuration;
	}

	public Course() {
		super();
	}


	//Getters and Setters
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public int getWeekDuration() {
		return weekDuration;
	}
	
	public void setWeekDuration(int weekduration) {
		this.weekDuration = weekduration;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	


	@Override
	public String toString() {
		return "\nCourse [id=" + id + ", courseName=" + courseName + ", startDate=" + startDate + ", weekDuration="
				+ weekDuration + ", students=" + students + "]";
	}
	

	
}
















/* 		Java ArrayList
 * 
 * 		MethodDescriptionvoidadd(intindex, Objectelement)It is used to insert the specified element at the specified position index in a list.
 * 
 * 		booleanaddAll(Collectionc)It is used to append all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator.
 * 
 * 		voidclear()It is used to remove all of the elements from this list.
 * 
 * 		intlastIndexOf(Objecto)It is used to return the index in this list of the last occurrence of the specified element, or -1 if the list does not contain this element.
 * 
 *	 	Object[] toArray()It is used to return an array containing all of the elements in this list in the correct order.
 *
 * 		Object[] toArray(Object[] a)It is used to return an array containing all of the elements in this list in the correct order.
 * 
 * 		booleanadd(Objecto)It is used to append the specified element to the end of a list.
 * 
 * 		booleanaddAll(intindex, Collectionc)It is used to insert all of the elements in the specified collection into this list, starting at the specified position.
 * 
 * 		Objectclone()It is used to return a shallow copy of an ArrayList.
 * 
 * 		intindexOf(Objecto)It is used to return the index in this list of the first occurrence of the specified element, or -1 if the List does not contain this element.
 * 
 * 		voidtrimToSize()It is used to trim the capacity of this ArrayListinstance to be the list's current size.
 * 
 * 
 */




























