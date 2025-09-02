package Bridge_lab.cls8.day8;
import java.util.*;
public class Q4 {
    public static void main(String[] args) {
        String str = "programming";
        System.out.println("Without Duplicates: " + removeDuplicates(str));
    }

    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for(char c : str.toCharArray()) {
            if(!set.contains(c)) {
                sb.append(c);
                set.add(c);
            }
        }
        return sb.toString();
    }
}
