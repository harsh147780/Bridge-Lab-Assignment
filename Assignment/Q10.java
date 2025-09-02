package Bridge_lab.cls8.day8;

public class Q10 {
    public static void main(String[] args) {
        String str = "Hello World";
        char remove = 'l';
        System.out.println("Modified String: " + removeChar(str, remove));
    }

    public static String removeChar(String str, char ch) {
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) {
            if(c != ch) sb.append(c);
        }
        return sb.toString();
    }
}
