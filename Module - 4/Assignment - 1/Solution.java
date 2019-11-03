/**
 * main class.
 * @author Ankith.
 * complexity is O(N^2).
 * not a stable algorithm but in place.
 * 
 */
class Solution {
	private Solution() {
	}
	/**
	 * method to sort the array.
	 * @param arr the array that is to be sorted..
	 * @return the sorted array.
	 */
	public static int[] quickSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
		return arr;
	}

	/**
	 * recurssive method to sort the arrayy.
	 * @param arr the array thaat is to be sorted.
	 * @param lo starting position of the array.
	 * @param hi ending position of the array.
	 */
	private static void sort(int[] arr, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int j = partition(arr, lo, hi);
		sort(arr, lo, j - 1);
		sort(arr, j + 1, hi);
	}

	/**
	 * function to divide the function based on the pivot position.
	 *
	 * @param arr the array to be sorted.
	 * @param lo  position of the initial element.
	 * @param hi  position of the last element.
	 * @return the jth index.
	 * complexity is O(N^2)
	 */
	private static int partition(int[] arr, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		while (true) {
			while (arr[++i] < arr[lo]) {
				if (i == hi) {
					break;
				}
			}
			while (arr[lo] < arr[--j]) {
				if (j == lo) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}

		int temp = arr[lo];
		arr[lo] = arr[j];
		arr[j] = temp;
		return j;
	}
}
