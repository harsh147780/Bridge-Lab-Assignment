package Bridge_lab.cls8.day8;

public class Q5 {
    public static void main(String[] args) {
        String sentence = "I love programming in Java";
        System.out.println("Longest word: " + findLongestWord(sentence));
    }

    public static String findLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longest = "";
        for(String word : words) {
            if(word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
}
