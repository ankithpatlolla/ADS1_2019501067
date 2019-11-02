import java.util.*;
/**
 * main class.
 * Complexity is N^2 LogN cause i used binary search method
 *  to reduce the complexity from N^3 to N^2 LogN
 * @author Ankith.
 */
class ThreeSum {
    /**
     * method threesum to count
     * @param arr array that is to be consider.
     * @return count of threesum  values.
     */
    public static int threeSumCount (int[] arr) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int  index = (Arrays.binarySearch(arr, -(arr[i]+arr[j])));
                if (index >= 0 && index > j) {
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * main method program excution will start from here.
     * @param args args.
     */
    public static void main(String[] args) {
        int[] arr = {30, -40, -20, -10, 40, 0, 10, 5};
        System.out.println(threeSumCount(arr));
    }
}