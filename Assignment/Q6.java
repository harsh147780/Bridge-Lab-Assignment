package Bridge_lab.cls8.day8;

public class Q6 {
    public static void main(String[] args) {
        String str = "abababa";
        String sub = "aba";
        System.out.println("Occurrences: " + countOccurrences(str, sub));
    }

    public static int countOccurrences(String str, String sub) {
        int count = 0, idx = 0;
        while((idx = str.indexOf(sub, idx)) != -1) {
            count++;
            idx++; // shift forward
        }
        return count;
    }
}
