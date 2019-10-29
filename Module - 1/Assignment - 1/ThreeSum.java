import java.util.*;
class ThreeSum {
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
    public static void main(String[] args) {
        int[] arr = {30, -40, -20, -10, 40, 0, 10, 5};
        System.out.println(threeSumCount(arr));
    }
}