package Assignment2;
import java.util.*;
class Student{
	private String studentName;
	private String studentId;
	private List<Subject> subjects;
	
	public Student(String studentName , String studentId) {
		this.studentName = studentName;
		this.studentId = studentId;
		this.subjects = new ArrayList<>();
	}
	

	public void addSubject(Subject subject) {
		subjects.add(subject);
	}
	
	public String getStudentName() {
		return studentName;
	}
	public String getStudentId() {
		return studentId;
	}
	public List<Subject> getSubjects(){
		return subjects;
	}
}

class Subject{
	private String subjectName;
	private int marks;
	
	public Subject(String subjectName , int marks) {
		this.subjectName = subjectName;
		this.marks = marks;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
}

class GradeCalculator{
	
	public String calculateGrade(Student student) {
		int totalMarks = 0;
		int subjectCount = student.getSubjects().size();
		
		 for (Subject subject : student.getSubjects()) {
	            totalMarks += subject.getMarks();
	        }
		 double average = (double) totalMarks / subjectCount;
	        String grade;

	        if (average >= 90) grade = "A";
	        else if (average >= 75) grade = "B";
	        else if (average >= 60) grade = "C";
	        else if (average >= 50) grade = "D";
	        else grade = "F";

	        return grade;
	}
	
}
public class SchoolResult {

	public static void main(String[] args) {
		Student john = new Student("John" , "MS001");

        // Add subjects
        john.addSubject(new Subject("Maths", 90));
        john.addSubject(new Subject("Science", 85));

        // Calculate grade
        GradeCalculator calculator = new GradeCalculator();
        String grade = calculator.calculateGrade(john);

        // Display result
        System.out.println("Student: " + john.getStudentName());
        System.out.println("Grade: " + grade);

	}

}
