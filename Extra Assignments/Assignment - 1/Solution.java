import java.util.*;
/**
*class Solution to find the farthestpair in a given double array.
*@author Ankith.
 */
public class Solution {

    /**
    * method farthestPair to  find the farthestPair in a given array.
    * @param arr double array in which we have to check.
    * @return String miimum and maximum pair.
    * complexity is N.
    */
    public String farthestPair (double[] arr) {
        int i = 1;
        double min = arr[0];
        double max = arr[0];
        while (i < arr.length) {
            if (min > arr[i]) {
                min = arr[i];
            } else if (max < arr[i]) {
                max = arr[i];
            }
            i++;
            }
            return min + ", " + max;
        }

    /**
    * main method. my program will start execution from here.
    * complexity is N.
     */
    public static void main(String[] args) {
    Solution s = new Solution();
    Scanner sc = new Scanner(System.in);
    System.out.println("please enter an positive integer to initialize array size");
    int N = sc.nextInt();
    double[] arr = new double[N];
    for (int i = 0; i < N; i++) {
        System.out.println("please enter an double value to insert in an array");
        double ele = sc.nextDouble();
        arr[i] = ele;
    }
    System.out.println(s.farthestPair(arr));
    }
}