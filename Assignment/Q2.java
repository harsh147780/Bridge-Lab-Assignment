package Bridge_lab.cls8.day8;

public class Q2 {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println("Reversed: " + reverse(str));
    }

    public static String reverse(String str) {
        String rev = "";
        for(int i = str.length()-1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        return rev;
    }
}
