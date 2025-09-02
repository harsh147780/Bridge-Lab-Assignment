package Bridge_lab.cls8.day8;
import java.util.*;
public class Q9 {
    public static void main(String[] args) {
        String str = "success";
        System.out.println("Most Frequent Character: " + mostFrequent(str));
    }

    public static char mostFrequent(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char res = ' ';
        int max = 0;
        for(char c : map.keySet()) {
            if(map.get(c) > max) {
                max = map.get(c);
                res = c;
            }
        }
        return res;
    }
}
