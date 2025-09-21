package Inheritence;

public class Cat extends Animals{
	 
	 public Cat(String animalName , int age) {
		 super(animalName , age);
	 }
	 
	 @Override
	 public void makeSound() {
		 System.out.println(animalName + " is Meow Meow");
	 }
}

