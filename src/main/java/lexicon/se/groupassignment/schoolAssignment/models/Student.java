package lexicon.se.groupassignment.schoolAssignment.models;

public class Student {
	
	//private static sequence...?
	private int id;
	private String name;
	private String email;
	private String address;
	
	//Constructors
	
	//Empty default contructor
	public Student() {}
	
	public Student(int id, String name, String email, String address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public Student(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
		
	}
	
	//Getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}
	
	
}
