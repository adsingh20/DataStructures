package hashing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountFrequencyOfWords {

    private static Map<Character, Integer> countFrequency(String text) {
        Map<Character, Integer> counts = new TreeMap<>();
        return getCharacterIntegerMap(text, counts);
    }

    private static Map<Character, Integer> countFrequencyBasedOnInsertion(String text) {
        Map<Character, Integer> counts = new LinkedHashMap<>();
        return getCharacterIntegerMap(text, counts);
    }

    private static Map<Character, Integer> getCharacterIntegerMap(String text, Map<Character, Integer> counts) {
        for (int i = 0; i < text.length(); i++) {
            if (counts.containsKey(text.charAt(i))) {
                Integer count = counts.get(text.charAt(i));
                counts.put(text.charAt(i), count + 1);
            } else {
                counts.put(text.charAt(i), 1);
            }
        }

        return counts;
    }

    public static void main(String args[]) {
        System.out.println(countFrequency("Amandeep Singh"));
        System.out.println(countFrequencyBasedOnInsertion("Amandeep Singh"));
    }
}
