import java.util.*;
/**
 * class solution to show K elements are largest after deleting N-K elements.
 * @author Ankith.
 */
public class Solution {

	/**
	 * this is main method.
	 * in this i insertall array elements to maxpq and minpq.
	 * then i ll check remining elements in in pq are largest by comapring with deleted elements
	 * in maxPQ.
	 * @param args args.
	 */
	public static void main(String[] args) {
		int K = 3; //the elements that is be deleted.
		int[] arr = {1, 3, 5, 2, 10, 9};
		int N = arr.length;
		MinHeap minPQ = new MinHeap(N + 1); // creating minpq.
		MaxHeap maxPQ = new MaxHeap(N + 1); //creating maxpq.
		for (int i = 0; i < arr.length; i++) {
			minPQ.insert(arr[i]); // complexity O(logN).
			maxPQ.insert(arr[i]); // complexity O(logN).
		}

		// System.out.println(Arrays.toString(maxPQ.pq));
		// System.out.println(Arrays.toString(minPQ.pq));
		
		int[] ar1 = new int[K]; //creating integer array to store deleted values in maxpq.

		for (int i = 0; i < K; i++) {
			minPQ.delete(); //complexty is O(logN).
			ar1[i] = maxPQ.delete();
		}

		Arrays.sort(ar1);
		String s1 = ""; // string to store elements which are in minpq.
		String s2 = ""; // String to store elements which are deleted from maxpq.
		for (int i = 1; i <= minPQ.size; i++) {
			s1 += " " + minPQ.pq[i];
			s2 += " " + ar1[i - 1];
		}

		System.out.println(s1); //to print s1.
		System.out.println(s2); //to prinnt s2.
		if (s1.equals(s2)) {
			System.out.println("remaining K elements are largest of N items ");
		} else {
			System.out.println("No");
		}

	}
}