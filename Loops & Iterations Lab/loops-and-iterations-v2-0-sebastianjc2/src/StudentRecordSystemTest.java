import static org.junit.Assert.*;

import org.junit.Test;

public class StudentRecordSystemTest {

	@Test
	public void removeTest() {
		StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(6);
		StudentRecordSystem.StudentRecord[] sr = new StudentRecordSystem.StudentRecord[6];

		sr[0] = new StudentRecordSystem.StudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 3.35);
		sr[1] = new StudentRecordSystem.StudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.00); 
		sr[2] = new StudentRecordSystem.StudentRecord("802123349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.90);
		sr[3] = new StudentRecordSystem.StudentRecord("502100785", "Eliana", StudentRecordSystem.Gender.FEMALE, 3.90);
		sr[4] = new StudentRecordSystem.StudentRecord("502107005", "Margarita", StudentRecordSystem.Gender.FEMALE, 4.00);
		sr[5] = new StudentRecordSystem.StudentRecord("502104463", "Julio", StudentRecordSystem.Gender.MALE, 3.95);
		studentRecordSystem.addAllStudents(sr);
				
		studentRecordSystem.remove(new StudentRecordSystem.StudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.00));
		assertEquals("The totalStudentData variable is not being updated.", 5, studentRecordSystem.getTotalStudentData());
		
		studentRecordSystem.remove(new StudentRecordSystem.StudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.00));
		StudentRecordSystem.StudentRecord[] studentRecords1 = studentRecordSystem.getStudentData();
		assertEquals("The student has not been removed.", 5, studentRecordSystem.getTotalStudentData());
		assertEquals("Student record ID is incorrect.", "502104463", studentRecords1[1].getID());
		assertEquals("Student record name is incorrect.", "Julio", studentRecords1[1].getName());
		assertNull("The last element is not null and is repeated.", studentRecords1[5]);
	}
	
	@Test
	public void minTest() {
		StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(3);
		StudentRecordSystem.StudentRecord[] sr = new StudentRecordSystem.StudentRecord[3];

		sr[0] = new StudentRecordSystem.StudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 3.04);
		sr[1] = new StudentRecordSystem.StudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.32);
		sr[2] = new StudentRecordSystem.StudentRecord("802123349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.87);
		studentRecordSystem.addAllStudents(sr);

		assertFalse("Min GPA is incorrect, it should be " + studentRecordSystem.getStudentData()[0].getGPA() + " but it was " + studentRecordSystem.minStudentGPA(),
				studentRecordSystem.getStudentData()[0].getGPA() != studentRecordSystem.minStudentGPA());

		sr = new StudentRecordSystem.StudentRecord[2];
		sr[0] = new StudentRecordSystem.StudentRecord("802152268", "Julia", StudentRecordSystem.Gender.FEMALE, 4.00);
		sr[1] = new StudentRecordSystem.StudentRecord("802143852", "Pedro", StudentRecordSystem.Gender.MALE, 2.42);
		studentRecordSystem.addAllStudents(sr);

		assertTrue("Min GPA correct, it should be " + studentRecordSystem.getStudentData()[4].getGPA() + " but it was " + studentRecordSystem.minStudentGPA(),
				studentRecordSystem.getStudentData()[4].getGPA() == studentRecordSystem.minStudentGPA());
	}

	@Test
	public void maxTest() {
		StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(3);
		StudentRecordSystem.StudentRecord[] sr = new StudentRecordSystem.StudentRecord[3];

		sr[0] = new StudentRecordSystem.StudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 3.04);
		sr[1] = new StudentRecordSystem.StudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.32);
		sr[2] = new StudentRecordSystem.StudentRecord("802123349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.87);
		studentRecordSystem.addAllStudents(sr);

		assertFalse("Max GPA is incorrect, it should be " + studentRecordSystem.getStudentData()[2].getGPA() + " but it was " + studentRecordSystem.maxStudentGPA(),
				studentRecordSystem.getStudentData()[2].getGPA() != studentRecordSystem.maxStudentGPA());

		sr = new StudentRecordSystem.StudentRecord[2];
		sr[0] = new StudentRecordSystem.StudentRecord("802152268", "Julia", StudentRecordSystem.Gender.FEMALE, 4.00);
		sr[1] = new StudentRecordSystem.StudentRecord("802143852", "Pedro", StudentRecordSystem.Gender.MALE, 2.42);
		studentRecordSystem.addAllStudents(sr);

		assertTrue("Max GPA correct, it should be " + studentRecordSystem.getStudentData()[3].getGPA() + " but it was " + studentRecordSystem.maxStudentGPA(),
				studentRecordSystem.getStudentData()[3].getGPA() == studentRecordSystem.maxStudentGPA());
	}    

	@Test
	public void meanTest() {
		StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(3);
		StudentRecordSystem.StudentRecord[] sr = new StudentRecordSystem.StudentRecord[3];

		assertEquals("Mean student record GPA is incorrect.", 0.0000000000, studentRecordSystem.getMean(), 1E-3);

		sr = new StudentRecordSystem.StudentRecord[4];
		sr[0] = new StudentRecordSystem.StudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 4.00);
		sr[1] = new StudentRecordSystem.StudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.00);
		sr[2] = new StudentRecordSystem.StudentRecord("802123349", "Eliezer", StudentRecordSystem.Gender.MALE, 2.00);
		sr[3] = new StudentRecordSystem.StudentRecord("802131831", "Zhoe", StudentRecordSystem.Gender.FEMALE, 1.00);
		studentRecordSystem.addAllStudents(sr);

		assertEquals("Mean student record GPA is incorrect.", 2.5000000000, studentRecordSystem.getMean(), 1E-3);

		sr = new StudentRecordSystem.StudentRecord[2];
		sr[0] = new StudentRecordSystem.StudentRecord("802118754", "Dillan", StudentRecordSystem.Gender.MALE, 2.50);
		sr[1] = new StudentRecordSystem.StudentRecord("802145672", "Rye", StudentRecordSystem.Gender.FEMALE, 3.50);
		studentRecordSystem.addAllStudents(sr);

		assertEquals("Mean student record GPA is incorrect.", 2.6666666666, studentRecordSystem.getMean(), 1E-3);
	}

	@Test
	public void startsWithTest() {
		String[] expectedStrings = new String[6];
		expectedStrings[0] = "ID: 802174579, Name: Juan, Gender: M, GPA: 3.40";
		expectedStrings[1] = "ID: 802122423, Name: Julia, Gender: F, GPA: 3.35";
		expectedStrings[2] = "ID: 802123349, Name: Eliezer, Gender: M, GPA: 3.70";
		expectedStrings[3] = "ID: 502100785, Name: Eliana, Gender: F, GPA: 3.90";
		expectedStrings[4] = "ID: 502107005, Name: Margarita, Gender: F, GPA: 4.00";
		expectedStrings[5] = "ID: 502104463, Name: Julio, Gender: M, GPA: 3.95";
		
		StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(8);
		String[] actualStrings = studentRecordSystem.startsWith("");
		assertEquals("The size of array of Strings doesn't have the right length.", 0, actualStrings.length);

		StudentRecordSystem.StudentRecord[] sr = new StudentRecordSystem.StudentRecord[6];

		sr[0] = new StudentRecordSystem.StudentRecord("802174579", "Juan", StudentRecordSystem.Gender.MALE, 3.40);
		sr[1] = new StudentRecordSystem.StudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 3.35);
		sr[2] = new StudentRecordSystem.StudentRecord("802123349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.70);
		sr[3] = new StudentRecordSystem.StudentRecord("502100785", "Eliana", StudentRecordSystem.Gender.FEMALE, 3.90);
		sr[4] = new StudentRecordSystem.StudentRecord("502107005", "Margarita", StudentRecordSystem.Gender.FEMALE, 4.00);
		sr[5] = new StudentRecordSystem.StudentRecord("502104463", "Julio", StudentRecordSystem.Gender.MALE, 3.95);
		studentRecordSystem.addAllStudents(sr);

		actualStrings = studentRecordSystem.startsWith("80212");
		assertEquals("Student Juan has incorrect record.", expectedStrings[1], actualStrings[0]);
		assertEquals("Student Julia has incorrect record.", expectedStrings[2], actualStrings[1]);
		assertEquals("The size of array of Strings doesn't have the right length.", 2, actualStrings.length);

		actualStrings = studentRecordSystem.startsWith("50210");
		assertEquals("Student Juan has incorrect record.", expectedStrings[3], actualStrings[0]);
		assertEquals("Student Julia has incorrect record.", expectedStrings[4], actualStrings[1]);
		assertEquals("Student Julia has incorrect record.", expectedStrings[5], actualStrings[2]);
		assertEquals("The size of array of Strings doesn't have the right length.", 3, actualStrings.length);
	}

	@Test
	public void containsAllTest() {
		StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(6);
		StudentRecordSystem.StudentRecord[] sr = new StudentRecordSystem.StudentRecord[6];

		sr[0] = new StudentRecordSystem.StudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 3.35);
		sr[1] = new StudentRecordSystem.StudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.00); 
		sr[2] = new StudentRecordSystem.StudentRecord("802123349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.90);
		sr[3] = new StudentRecordSystem.StudentRecord("502100785", "Eliana", StudentRecordSystem.Gender.FEMALE, 3.90);
		sr[4] = new StudentRecordSystem.StudentRecord("502107005", "Margarita", StudentRecordSystem.Gender.FEMALE, 4.00);
		sr[5] = new StudentRecordSystem.StudentRecord("502104463", "Julio", StudentRecordSystem.Gender.MALE, 3.95);
		studentRecordSystem.addAllStudents(sr);

		StudentRecordSystem.StudentRecord[] singleton = { 
				new StudentRecordSystem.StudentRecord("802121234", "Lorena", StudentRecordSystem.Gender.FEMALE, 3.90) };
		assertFalse("Student Lorena is not in the record system.", studentRecordSystem.containsAll(singleton));

		StudentRecordSystem.StudentRecord[] quadStudent = { 
				new StudentRecordSystem.StudentRecord("802123349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.90),
				new StudentRecordSystem.StudentRecord("502107005", "Margarita", StudentRecordSystem.Gender.FEMALE, 4.00),
				new StudentRecordSystem.StudentRecord("502100785", "Eliana", StudentRecordSystem.Gender.FEMALE, 3.90),
				new StudentRecordSystem.StudentRecord("502104463", "Julio", StudentRecordSystem.Gender.MALE, 3.95)};
		assertTrue("All student are in the record system.", studentRecordSystem.containsAll(quadStudent));

		StudentRecordSystem.StudentRecord[] triStudent = { 
				new StudentRecordSystem.StudentRecord("502107005", "Margarita", StudentRecordSystem.Gender.FEMALE, 4.00),
				new StudentRecordSystem.StudentRecord("802121234", "Lorena", StudentRecordSystem.Gender.FEMALE, 3.90),
				new StudentRecordSystem.StudentRecord("502104463", "Julio", StudentRecordSystem.Gender.MALE, 3.95)};
		assertFalse("Student Lorena is not in the record system.", studentRecordSystem.containsAll(triStudent));
	}

	@Test
	public void repeatedStudentNamesTest() {
		StudentRecordSystem studentRecordSystem = StudentRecordSystem.initializeInstance(3);
		StudentRecordSystem.StudentRecord[] sr = new StudentRecordSystem.StudentRecord[3];

		sr[0] = new StudentRecordSystem.StudentRecord("802122423", "Julia", StudentRecordSystem.Gender.FEMALE, 3.04);
		sr[1] = new StudentRecordSystem.StudentRecord("802113679", "Pedro", StudentRecordSystem.Gender.MALE, 3.32); 
		sr[2] = new StudentRecordSystem.StudentRecord("802123349", "Eliezer", StudentRecordSystem.Gender.MALE, 3.87);
		studentRecordSystem.addAllStudents(sr);

		assertFalse("There are no repeated names", studentRecordSystem.repeatedStudentNames());

		sr = new StudentRecordSystem.StudentRecord[2];
		sr[0] = new StudentRecordSystem.StudentRecord("802152268", "Julia", StudentRecordSystem.Gender.FEMALE, 4.00);
		sr[1] = new StudentRecordSystem.StudentRecord("802143852", "Pedro", StudentRecordSystem.Gender.MALE, 2.42);
		studentRecordSystem.addAllStudents(sr);

		assertTrue("There is a repeated name", studentRecordSystem.repeatedStudentNames());
	}

}