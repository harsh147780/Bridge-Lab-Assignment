package Bridge_lab.cls8.day8;
import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int[] result = countVowelsAndConsonants(str);
        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);
    }

    public static int[] countVowelsAndConsonants(String str) {
        str = str.toLowerCase();
        int vowels = 0, consonants = 0;
        for(char c : str.toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                if("aeiou".indexOf(c) != -1) vowels++;
                else consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }
}
