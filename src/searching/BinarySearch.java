package searching;

import arrays.LeftRotateArray;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    static int binarySearch(int arr[], int l, int r, int searchNumber) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (arr[mid] == searchNumber) {
            return mid;
        }
        if (arr[mid] > searchNumber) {
            return binarySearch(arr, l, mid - 1, searchNumber);
        } else {
            return binarySearch(arr, mid + 1, r, searchNumber);
        }
    }

    static int findLeftMostOccurence(int arr[], int l, int r, int searchNumber) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (arr[mid] == searchNumber && (mid == arr.length || arr[mid+1] != searchNumber)) {
            return mid;
        }
        if (arr[mid] >= searchNumber) {
            return binarySearch(arr, l, mid - 1, searchNumber);
        } else {
            return binarySearch(arr, mid + 1, r, searchNumber);
        }
    }

    static int findRightMostOccurence(int arr[], int l, int r, int searchNumber) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (arr[mid] == searchNumber && (mid == 0 || arr[mid-1] != searchNumber)) {
            return mid;
        }
        if (arr[mid] > searchNumber) {
            return binarySearch(arr, l, mid - 1, searchNumber);
        } else {
            return binarySearch(arr, mid + 1, r, searchNumber);
        }
    }

    // Time Complexity
    static int countOccurences(int arr[], int l, int r, int searchNumber) {
        int rightMostOccurence = findRightMostOccurence(arr, l, r, searchNumber);
        int leftMostOccurence = findLeftMostOccurence(arr, l, r, searchNumber);
        if (rightMostOccurence == -1 && leftMostOccurence == -1) {
            return 0;
        }
        return rightMostOccurence - leftMostOccurence + 1;
    }

    static int countOnes(int arr[], int l, int r) {
        int leftMostOccurence = findLeftMostOccurence(arr, l, r, 1);
        if (leftMostOccurence > 0) {
            return arr.length - leftMostOccurence + 1;
        } else {
            return 0;
        }
    }

    static int findInInfiniteArray(int arr[], int x, int searchNumber) {
        if (arr[0] == searchNumber)
            return 0;
        int i = 1;
        while (arr[i] > searchNumber) {
            i = i * 2;
        }
        if (arr[i] == searchNumber) {
            return i;
        }
        return binarySearch(arr,i/2, i, searchNumber);
    }

    static int findInSortedAndRotatedArray(int arr[], int n, int searchNumber) {
        int pivot = findPivot(arr, 0, n-1);

        if (pivot == -1)
            return binarySearch(arr, 0, n-1, searchNumber);

        if (arr[pivot] == searchNumber) {
            return pivot;
        }

        System.out.println("Pivot Is" + pivot);

        if (arr[0] <= searchNumber) {
            return binarySearch(arr, 0, pivot -1, searchNumber);
        }

        return binarySearch(arr, pivot + 1, n - 1, searchNumber);
    }

    static int findPivot(int arr[], int low, int high) {
        if( high < low ) {
            return -1;
        } else if (high == low) {
            return low;
        }
        int mid = (low + high)/2;

        if (mid < high && arr[mid] > arr[mid + 1]) {
          return mid;
        }

        if (mid > low && arr[mid] < arr[mid - 1]) {
            return mid -1 ;
        }

        if (arr[low] >= arr[mid]) {
            findPivot(arr, low, mid -1);
        }

        return findPivot(arr, mid + 1, high);
    }

    /*static int findPeakElement(int arr[], int low, int high) {

    }*/

    public static void main(String[] args) {
        int a[] = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = new Random().nextInt(20);
        }
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int searchNumber = a[new Random().nextInt(8)];
        System.out.println(searchNumber);
        System.out.println(binarySearch(a, 0, 10 - 1, searchNumber));
        searchNumber = a[new Random().nextInt(3)];
        System.out.println(searchNumber);
        System.out.println(binarySearch(a, 0, 10 - 1, searchNumber));
        System.out.println(findLeftMostOccurence(a, 0, 10 - 1, searchNumber));
        System.out.println(countOccurences(a, 0, 10 - 1, searchNumber));
        int b[] = new int[10];
        for (int i = 0; i < 10; i++) {
            b[i] = new Random().nextInt(2);
        }
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
        System.out.println(countOnes(b, 0, 10 - 1));
        int c[] = new int[10000];
        for (int i = 0; i < 10000; i++) {
            c[i] = new Random().nextInt(10000);
        }
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));
        searchNumber = c[new Random().nextInt(10000)];
        System.out.println(searchNumber);
        System.out.println(findInInfiniteArray(c, 10000, searchNumber));
        LeftRotateArray.leftRotate(a, 10, 3);
        searchNumber = a[new Random().nextInt(10)];
        System.out.println(Arrays.toString(a));
        System.out.println(searchNumber);
        System.out.println(findInSortedAndRotatedArray(a, 10, searchNumber));
    }
}
