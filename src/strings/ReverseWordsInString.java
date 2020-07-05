package strings;

public class ReverseWordsInString {

    /**
     *
     * @param str
     * @return
     */
    private static String reverseWordsInStringEfficientSolution(String str) {
       String[] splitString = str.split(" ");
       StringBuilder reversedString = new StringBuilder();
        for (int i = splitString.length - 1; i >= 0; i--) {
            reversedString.append(splitString[i]).append(" ");
        }
        return reversedString.toString().trim();
    }

    /**
     *
     * @param str
     * @return
     */
    private static String reverseWordsInStringEfficientSolution2(String str) {
        String[] splitString = str.trim().split("\\s+");
        StringBuilder reversedString = new StringBuilder();
        for (int i = splitString.length - 1; i > 0; i--) {
            reversedString.append(splitString[i]).append(" ");
        }
        return reversedString.append(splitString[0]).toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsInStringEfficientSolution("Amandeep Singh CSE"));
        System.out.println(reverseWordsInStringEfficientSolution2("Amandeep Singh CSE"));
    }
}
