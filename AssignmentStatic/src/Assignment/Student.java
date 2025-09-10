package Assignment;

public class Student {

	   private static String universityName;
	   private static int totalStudents = 0;
	   
	   private final int rollNumber; 
	   private String name;
	   private char grade;

	   public Student(String name, int rollNumber, char grade) {
	       this.name = name;
	       this.rollNumber = rollNumber;
	       this.grade = grade;
	       totalStudents++;
	   }
	   // Static method to set the university name
	   public static void setUniversityName(String name) {
	       universityName = name;
	   }
	   // Static method to display the total number of students enrolled
	   public static void displayTotalStudents() {
	       System.out.println("Total Students Enrolled: " + totalStudents);
	   }
	  
	   public void displayStudentDetails() {
	       // Using 'instanceof' to verify the object's type before displaying details
	       if (this instanceof Student) {
	           System.out.println("University Name: " + universityName);
	           System.out.println("Roll Number: " + rollNumber);
	           System.out.println("Name: " + name);
	           System.out.println("Grade: " + grade);
	       } else {
	           System.out.println("The object is not an instance of the Student class.");
	       }
	   }
	   
	   public void updateGrade(char newGrade) {
	       // Using 'instanceof' to verify the object's type before updating grade
		   
	       if (this instanceof Student) {
	           this.grade = newGrade;
	           System.out.println("Grade updated to: " + newGrade);
	       } else {
	           System.out.println("The object is not an instance of the Student class.");
	       }
	   }
	   // Getters 
	   public String getName() {
	       return name;
	   }
	   public int getRollNumber() {
	       return rollNumber;
	   }
	   public char getGrade() {
	       return grade;
	   }
	   public static void main(String[] args) {
	   
	       Student.setUniversityName("Gla University");
	       
	       Student student1 = new Student("Harsh", 29, 'A');
	       Student student2 = new Student("Tanuj",64, 'B');
	     
	       Student.displayTotalStudents();
	       
	       student1.displayStudentDetails();
	       System.out.println();
	       student2.displayStudentDetails();
	       
	       student2.updateGrade('A');
	       System.out.println();
	       
	       student2.displayStudentDetails();
	   }
	}
