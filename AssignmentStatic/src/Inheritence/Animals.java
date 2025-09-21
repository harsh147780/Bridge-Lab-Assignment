package Inheritence;

public class Animals{
	 protected String animalName;
	 protected int age;
	 
	 public Animals(String animalName , int age ) {
		 this.animalName = animalName;
		 this.age = age;
	 }
	 
	 public void makeSound() {
		 System.out.println("Animal Sound Good");
	 }
	 public String getAnimalName() {
		 return animalName;
	 }
	 public int getAge() {
		 return age;
	 }
}