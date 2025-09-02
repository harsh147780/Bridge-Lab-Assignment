package Bridge_lab.cls8.day8;

public class Q8 {
    public static void main(String[] args) {
        String s1 = "apple", s2 = "banana";
        compareLex(s1, s2);
    }
    public static void compareLex(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        for(int i = 0; i < len; i++) {
            if(s1.charAt(i) < s2.charAt(i)) {
                System.out.println(s1 + " comes before " + s2);
                return;
            } else if(s1.charAt(i) > s2.charAt(i)) {
                System.out.println(s1 + " comes after " + s2);
                return;
            }
        }
        if(s1.length() < s2.length())
            System.out.println(s1 + " comes before " + s2);
        else if(s1.length() > s2.length())
            System.out.println(s1 + " comes after " + s2);
        else
            System.out.println("Both are equal");
    }
}
