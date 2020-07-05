import java.util.*;

public class CreateLargestNumberFromArray {
    static void printLargest(List<String> arr) {
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x+y;
                String yx = y+x;
                int result = xy.compareTo(yx);
                return result > 0 ? -1 : 1; // Consider x = 546 and y = 54. Here xy > yx which means x > y
                                            // we return -1 since we want the larger number first.
            }
        });

        Iterator it = arr.iterator();

        while(it.hasNext())
            System.out.print(it.next());
    }

    public static void main (String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
    printLargest(arr);
}
}
