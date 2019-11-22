/**
 * class solution to check the probability.
 */
public class Solution {
	/**
	 * main method to check the probability. my program execution will start from here.
	 * @param args args.
	 */
	public static void main(String[] args) {
		LinearProbingHashST<Integer, Integer> st = new LinearProbingHashST<> (10000000);
		int value = 0; // value.

		for (int i = 0; i < 500000; i++) {
			st.put((i + 1) * 3, value + i); // inserting key value pair in to hashtable.
		}

		int count = 0;
		for ( int i = 0; i < 1000000; i += 100) {
			if (st.contains(i)) {  // checking the number of indices that divisible by 100.
				count++;
			}
		}

		System.out.println(count / 10000.0); // finding probability.
	}
}