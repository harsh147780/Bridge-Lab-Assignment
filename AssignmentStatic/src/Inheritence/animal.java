package Inheritence;


 
public class animal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animals dog = new Dog("Buddy " , 4);
		Animals cat = new Cat("hell " ,3);
		Animals bird = new Bird("tweeter",2);
		
		dog.makeSound();
		cat.makeSound();
		bird.makeSound();

	}

}
