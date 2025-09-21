package Inheritence;

public class Dog extends Animals{
	 public Dog(String animalName , int age) {
		 super(animalName , age);
	 }
	 
	 @Override
	 public void makeSound() {
		 System.out.println(animalName + "is Woof Woof");
	 }
	 
}