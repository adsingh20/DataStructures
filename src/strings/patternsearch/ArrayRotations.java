package strings.patternsearch;

public class ArrayRotations {

    /**
     * Time Complexity theta(n) since concatenation and contains taken linear time
     * Space Complexity theta(n) since we are using concatenated string
     * @param s1
     * @param s2
     * @return
     */
    private static boolean checkIfArrayRotationOfAnother(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return (s1 + s1).contains(s2);
    }

    public static void main(String[] args) {

        System.out.println(checkIfArrayRotationOfAnother("ABCDA", "DAABC"));
        System.out.println(checkIfArrayRotationOfAnother("ABCD", "DABC"));
        System.out.println(checkIfArrayRotationOfAnother("ABCD", "DABE"));
    }
}
