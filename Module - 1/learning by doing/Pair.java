import java.util.*;
/**
 * class pair.
*/
public class Pair {
    /**
     * method pairs to check the pairs.
     * @param arr array that is to be consider.
     * @return count.
     */
    public static int pairs (int[] arr) {
        int c = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i+1]) {
                c += 1;
            }
        }
        return c;
    }
    /**
     * main method the excuetion of our program will start from here.
     * @param args args.
     */
    public static void main(String[] args) {
        // int[] a = {1, 2, 1, 4, 5, 4, 4};
        int[] a = {1,2,1,2,1,2,1};
        System.out.println(pairs(a));
    }
}