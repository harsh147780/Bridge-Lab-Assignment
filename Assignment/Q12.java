package Bridge_lab.cls8.day8;

public class Q12 {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(replace(str, 'l', 'x'));
    }

    public static String replace(String str, char oldChar, char newChar) {
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) {
            if(c == oldChar) sb.append(newChar);
            else sb.append(c);
        }
        return sb.toString();
    }
}
