package Inheritence;

public class Bird extends Animals{
	
	public Bird(String animalName , int age) {
		super(animalName , age);
	}
	
	@Override
	public void makeSound() {
		System.out.println(animalName + " is Chrip Chrip");
	}
}
