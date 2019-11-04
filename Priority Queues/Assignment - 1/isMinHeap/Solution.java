/**
 * class solution
 * @author Ankith.
 * complexity O(logN)
 */
class Solution{
	/**
	 * isMinHeap method to check whether the given array is in minHeap or not.
	 * @param arr the array that is to be check.
	 * complexity O(logN)
	 * @return True if it is minheap else false.
	 */
	public static boolean isMinHeap(double[] arr){
		if (arr.length > 0) {
			for (int i = arr.length - 1; i >= 0; i--) {
				if (arr[i/2] > arr[i]) {
					return false;
				}
			}
			return true;
		}
		return false;
		// in this the number of operations will be more.
		// if (arr.length > 0) {
		// 	for (int i = 0; i <= arr.length/2 - 2; i++) {
		// 		if (arr[2*i+1] > arr[2*i+2]) {
		// 			return false;
		// 		}
		// 	}
		// 	return true;
		// }
		// return false;
	}
}