/**
 * main class.
 * @author Ankith.\
 * complexity O(NlogN).
 * not a in place algorithm. stable.
 */
class Solution {
	private Solution() {
	}

	/**
	 * function to call the sort function.
	 *
	 * @param arr the array to be sorted.
	 * @return the sorted array.
	 */
	public static String[] mergeSort(String[] arr) {
		String[] aux = new String[arr.length];
		sort(arr, aux, 0, arr.length - 1);
		return arr;
	}

	/**
	 * the function to sort the array in ascending order.
	 *
	 * @param arr the array to be sorted.
	 * @param aux auxiliary array for temporary storage of elements.
	 * @param lo the starting position of the array.
	 * @param hi the ending position of the array.
	 * complexity is 1
	 */
	private static void sort(String[] arr, String[] aux,
				int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int mid = (lo + hi) / 2;
		sort(arr, aux, lo, mid);
		sort(arr, aux, mid + 1, hi);
		merge(arr, aux, lo, mid, hi);
	}

	/**
	 * the function to merge the parts in ascending order.
	 *
	 * @param arr the array to be sorted.
	 * @param aux temporary array to store elements.
	 * @param lo the starting position of the array.
	 * @param mid the mid position of the array.
	 * @param hi the last position of the array.
	 */
	private static void merge(String[] arr, String[] aux,
				int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = arr[k];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				arr[k] = aux[j++];
			} else if (j > hi) {
				arr[k] = aux[i++];
			} else if (aux[j].compareTo(aux[i]) < 0) {
				arr[k] = aux[j++];
			} else {
				arr[k] = aux[i++];
			}
		}
	}
}
