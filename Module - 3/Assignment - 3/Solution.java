/**
 * class Solution for performing selection sort and insertion sort.
 * @author Ankith.
 */
class Solution{
	/**
	 * This is a method to swap the elements in an array based on the index positions.
	 * @param arr the array that is to be sorted.
	 * @param i index
	 * @param j index
	 */
	public void swap (final int[] arr, final int i, final int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	/**
	 * insertion sort method to sort array.
	 * @param arr the array thaat is to be sorted.
	 * 
	 * we use two for loops iterating through length of an array
	 * the time complexity of this sort is N in best case and N^2 worst case.
	 * 
	 */
	public int[] sortInsertion(final int[] arr){
		// fill you code Here
		// int outerLoopCount = 0;
		// int innerLoopCount = 0;
		for (int i = 1; i < arr.length; i++) {
			// outerLoopCount++;
			for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
				// int temp = arr[j-1];
				// arr[j-1]  = arr[j];
				// arr[j] = temp;
				swap (arr, j-1, j);
				// innerLoopCount++;
			}
		}
		// System.out.println(outerLoopCount);
		// System.out.println(innerLoopCount);
		return arr;
	}
	/**
	 * @param arr the array that is to be sorted.
	 * we use this method to sort array.
	 * we use two for loops which irritate through length of an array
	 * the complexity for this sort is N^2 in both best and worst cases.
	 */
	public int[] sortSelection(final int[] arr){
		// fill you code Here
		// int outerLoopCount = 0;
		// int innerLoopCount = 0;
		// int ifCount = 0; 
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			// outerLoopCount++;
			for (int j = i+1; j < arr.length; j++) {
				// innerLoopCount++;
				if (arr[j] < arr[min]) {
					min = j;
					// ifCount++;
				}
			}
			// int temp = arr[i];
			// arr[i] = arr[min];
			// arr[min] = temp;
			swap (arr, i, min);
		}
		// System.out.println(outerLoopCount);
		// System.out.println(innerLoopCount);
		// System.out.println(ifCount);
		return arr;
	}
}