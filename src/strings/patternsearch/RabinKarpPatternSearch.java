package strings.patternsearch;

public class RabinKarpPatternSearch {

    public final static int CHAR_SIZE = 256;
    public final static int q = 97;

    private static void patternSearching(String text, String pattern) {
        int patternLength = pattern.length();
        int textLength = text.length();

        int i, j;

        int patternHashValue = 0; // hash value for pattern
        int textHashValue = 0; // hash value for txt

        int h = 1;

        // The value of h would be "pow(d, patternLength-1)%q"
        for (i = 0; i < patternLength - 1; i++)
            h = (h * CHAR_SIZE) % q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < patternLength; i++) {
            patternHashValue = (CHAR_SIZE * patternHashValue + pattern.charAt(i)) % q;
            textHashValue = (CHAR_SIZE * textHashValue + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= textLength - patternLength; i++) {

            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if (patternHashValue == textHashValue) {
                /* Check for characters one by one */
                for (j = 0; j < patternLength; j++) {
                    if (text.charAt(i + j) != text.charAt(j))
                        break;
                }

                /* if patternHashValue == textHashValue and pat[0...patternLength-1]
                = txt[i, i+1, ...i+patternLength-1] */
                if (j == patternLength)
                    System.out.println("Pattern found at index " + i);
            }

            /* Calculate hash value for next window of text: Remove
            leading digit, add trailing digit */
            if (i < textLength - patternLength) {
                textHashValue = (CHAR_SIZE * (textHashValue - text.charAt(i) * h) +
                        text.charAt(i + patternLength)) % q;

                // We might get negative value of textHashValue, converting it
                // to positive
                if (textHashValue < 0)
                    textHashValue = (textHashValue + q);
            }
        }
    }

    public static void main(String[] args) {

        patternSearching("ABCDA", "AB");
        patternSearching("ABCABCD", "ABCD");

        patternSearching("AAAA", "AA");
        patternSearching("AAAABBCDDBB", "BB");

        patternSearching("AAAABBCDDBB", "Z");
    }
}
