import java.util.ArrayList;

public class StudentRecordSystem {

	private static StudentRecordSystem studentRecordSystem;
	private StudentRecord[] studentData;
	private int totalStudentData;	// Actual number of student records currently in the system.
	
	static {
		studentRecordSystem = new StudentRecordSystem();
	}
	
	private StudentRecordSystem() {}
	
	public static StudentRecordSystem initializeInstance(int maxNumberOfStudentRecords){
		studentRecordSystem.studentData = new StudentRecord[maxNumberOfStudentRecords];
		studentRecordSystem.totalStudentData = 0;
        return studentRecordSystem;
    }
	
	// Getters
	public StudentRecord[] getStudentData() {
		return studentData;
	}
	
	public int getTotalStudentData() {
		return totalStudentData;
	}
	
	/*                       **IMPORTANT**
	 * Method for testers, Other methods should be done using Arrays.
	 * The use of Lists or any of it's functions is forbidden.
	 */
	
	public void addAllStudents(StudentRecord[] sr) {
		ArrayList<StudentRecord> list = new ArrayList<StudentRecord>();
		for(int i = 0; i<totalStudentData; i++) {
			list.add(studentData[i]);
		}
		for(StudentRecord s: sr) {
			list.add(s);
		}
		studentData = list.toArray(new StudentRecord[0]);
		totalStudentData += sr.length;
	}
	
    /*
     * EXERCISE: #1
     * 
     * IMPLEMENT WITH ANY LOOP
	 * 
	 * Removes the first occurrence of the specified StudentRecord 
	 * from the system, if it is present. If the system does not 
	 * contain the StudentRecord, it is unchanged.
	 * 
	 * If the student is present, he / she will be replaced with 
	 * the last student in the system. 
	 * 
	 * If the student is present and is the last, she / he will be 
	 * replaced with a null.
	 * 
	 */
	public void remove(StudentRecord s) { 
		//Write your code here	
	}
	
	/* 
	 * EXERCISE: #2A
     *
	 * IMPLEMENT USING AN ENHANCED FOR LOOP (For-each).
	 * 
	 * Returns the minimum element of the student record system, according 
	 * to the natural ordering of its GPA.
	 * 
	 */
	public double minStudentGPA() {
		// YOUR CODE GOES HERE.
		return 4.0;
	}	

    /* 
	 * EXERCISE: #2B
     *
	 * IMPLEMENT USING AN ENHANCED FOR LOOP (For-each).
	 * 
	 * Returns the maximum element of the student record system, according 
	 * to the natural ordering of its GPA.
	 * 
	 */
	public double maxStudentGPA() {
		// YOUR CODE GOES HERE.
		return 0.0;		
	}
	
	/* 
	 * EXERCISE: #2C
     *
	 * IMPLEMENT WITH ANY LOOP.
	 * 
	 * Returns the mean of the GPA's in student record system
	 * 
	 */
	public double getMean() {
		// YOUR CODE GOES HERE.
		return 0;
	}
	
	/* 
	 * EXERCISE: #3A
     * 
	 * IMPLEMENT USING A REGULAR FOR LOOP.
	 * 
	 * Returns an array of Strings where each element is a string 
	 * representation of the record of each student string whose id
	 * starts with the specified prefix.
	 * 
	 * The size of the array has to be exactly the number of elements 
	 * that meet the property.
	 * 
	 * HINT: Use the toString method in the Student Record inner class 
	 * and startsWith method in the String class.
	 */
	public String[] startsWith(String prefix) {
		// YOUR CODE GOES HERE.
		return null;
	}
	
	/* 
	 * EXERCISE: #3B
     * 
	 * IMPLEMENT USING A WHILE LOOP.
	 * 
	 * Returns true if the system contains all of the elements in the specified array.
	 * 
	 */
	public boolean containsAll(StudentRecord[] s) {
		// YOUR CODE GOES HERE.
		return false;
	}
	
	/* 
	 * BONUS
	 * 
	 * IMPLEMENT WITH NESTED LOOPS.
	 * 
	 * Returns true if two instances of StudentRecord have the same name, false otherwise.
	 * HINT: Use the Equals method.
	 */
	public boolean repeatedStudentNames() {
		// YOUR CODE GOES HERE.
		return false;
	}
	
	/*
	 * Enum of type Gender representing male or female.
	 */
	public enum Gender {
		MALE('M'), FEMALE('F');
		private final char letter;
		Gender(char letter) { this.letter = letter; }
		public char genderLetter() { return letter; }
	}
	
	/*
	 * Inner class representing student records in the student record system.
	 */
	public static class StudentRecord {
		
		private String id;
		private String name;
		private Gender gender;
		private double gpa;
		
		public StudentRecord(String id, String name, Gender gender, double gpa) {
			this.id = id;
			this.name = name;
			this.gender = gender;
			this.gpa = gpa;
		}

		public String toString() {
			return String.format("ID: " + id + ", Name: " + name + ", Gender: " + gender.genderLetter() + ", GPA: %.2f", gpa);
		}
		
		// Getters
		public String getID() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public Gender getGender() {
			return gender;
		}
		
		public double getGPA() {
			return gpa;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof StudentRecord) {
				StudentRecord s = (StudentRecord) obj;
				return (this.getID().equals(s.getID()) && this.getName().equals(s.getName()));
			}
			return false;
		}
	}
}
