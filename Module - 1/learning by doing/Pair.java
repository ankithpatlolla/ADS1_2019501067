import java.util.*;
public class Pair {
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
    public static void main(String[] args) {
        // int[] a = {1, 2, 1, 4, 5, 4, 4};
        int[] a = {1,2,1,2,1,2,1};
        System.out.println(pairs(a));
    }
}