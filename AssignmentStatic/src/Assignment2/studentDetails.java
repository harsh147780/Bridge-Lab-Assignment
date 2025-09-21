package StudentManagementSystem;
import java.util.*;
class Course{
	private String courseId;
	private String courseName;
	private int credits;
	
	public Course(String courseId , String courseName, int credits) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.credits = credits;
	}
	
	//getter for this course details
	
	public String getCourseId() {
		return courseId;
	}
	public String getCourseName() { 
		return courseName;
	}
	public int getCredits() {
		return credits;
	}
}

// now for enrollment

class Enrollment{
	private Course course ;
	private double grades;
	
	public Enrollment(Course course , double grades) {
		this.course = course;
		this.grades = grades;
		
	}
	
	// getter for the enrollment 
	public Course getCourse() {
		return course;
	}
	public double getGrades() {
		return grades;
	}
	
}
	class Student{
		private String studentId;
		private String studentName;
		private List<Enrollment> enrollments ;
		
		public Student(String studentId , String studentName ) {
			this.studentId = studentId;
			this.studentName = studentName;
			this.enrollments = new ArrayList<>();
		}
		
		// getter for the students
		public String getStudentId() {
			return studentId;
		}
		public String getStudentName() {
			return studentName;
		}
		public void enroll(Course course, double grade) {
			enrollments.add(new Enrollment(course, grade));
			}
		public List<Enrollment> getEnrollments() {
			return enrollments;
			}
		
		//polymorphic method
		
		public double calculateGPA() {
			if(enrollments.isEmpty()) return 0;
			double totalPoints  = 0;
			double totalCredits = 0;
			
			for(Enrollment e : enrollments) {
				totalPoints  += e.getGrades() * e.getCourse().getCredits();
				totalCredits  += e.getCourse().getCredits();
			}
			return totalPoints / totalCredits;
		}
		
		public void printTranscript() {
			System.out.println("Transcipt for " + studentName + " : ");
			
			for (Enrollment e : enrollments) {
				System.out.println(" " + e.getCourse().getCourseName() + ": " + e.getGrades());
				}
			System.out.printf("GPA", calculateGPA());
		}
	}
	 
	// subclass for undergraduate Students(inherits Students)
	
	class UndergraduateStudent extends Student{
		public UndergraduateStudent(String studentId ,String studentName) {
			super(studentId , studentName);
		}
		
		//custom GPA logic
		
		@Override
		public double calculateGPA() {
			
			double totalPoints = 0;
			double totalCredits = 0;
			
			for(Enrollment e : getEnrollments()) {
				double grade = Math.min(e.getGrades(), 4.0);
				totalPoints += grade * e.getCourse().getCredits();
				totalCredits += e.getCourse().getCredits();
			}
			
			return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
		}
	}
	
	//subclass for PostgraduateStudent(inherits Student)
	class PostgraduateStudent extends Student{
		public PostgraduateStudent(String studentId ,String studentName ) {
			super(studentId , studentName);
		}
		
		// Example PG student need minimum 2.5 GPA
		@Override
		public double calculateGPA() {
			double gpa = super.calculateGPA();
			return gpa < 2.5 ? 0.0:gpa; // fail if GPA is too low
		}
	}
	
// main class
public class studentDetails {

	public static void main(String[] args) {
		//create some courses
		Course java = new Course("C101" , "Java Programming",3);
		Course math = new Course("M101" , "Mathemathics",4);
		Course db = new Course("D101" , "Databases",2);
		
		//create students
		Student s1 = new UndergraduateStudent("UG001","Harsh Chaudhary");
		Student s2 = new PostgraduateStudent("PG001","Raaj Chaudhary");
		
		// Enroll students in courses
		s1.enroll(java, 3.5);
		s1.enroll(db, 3.7);
		
		s2.enroll(db,2.2);
		s2.enroll(java,2.8);
		
		//Print Transcripts
		
		s1.printTranscript();
		System.out.println("Student 2");
		
		s2.printTranscript();

	}

}
