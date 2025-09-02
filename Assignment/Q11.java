package Bridge_lab.cls8.day8;
import java.util.*;
public class Q11 {
    public static void main(String[] args) {
        String s1 = "listen", s2 = "silent";
        if(isAnagram(s1, s2))
            System.out.println("Anagrams");
        else
            System.out.println("Not Anagrams");
    }

    public static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
}
