public class FirstNonRepeatingCharacter {

    static char count[] = new char[128];

    static void getCharCountArray(String str) {
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
    }

    static int getFirstNonRepeatingCharIndex(String str) {
        getCharCountArray(str);

        int index = -1, i;
        for (i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String str = "amandeepsingh";
        int index = getFirstNonRepeatingCharIndex(str);

        System.out.println(index == -1 ? "Either all characters are repeating or string " +
                "is empty" : "First non-repeating character is " + str.charAt(index));
    }
}
