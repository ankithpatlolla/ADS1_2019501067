/**
 * class solution to checkl the dynamic median for given elements.
 * we create to objects for minpq and maxpq classes and we [erform operations on them.
 * @author Ankith.
 */
class Solution{

	/**
	 * method dynamic median for calculating the median for a given.
	 * when each elements add to array we clculate that.
	 * @param arr array thaht is to be consider.
	 * @return arr the array with all median values.
	 * complexity N.
	 */
	public static double[] dynamicMedian(double[] arr){
		double median = 0.0;
		int n = arr.length;
		MinHeap minPQ = new MinHeap(n);
		MaxHeap maxPQ = new MaxHeap(n);
		for (int i = 0; i < n; i++) {
		if (arr[i] <= median) {
			maxPQ.insert(arr[i]);
		} else {
			minPQ.insert(arr[i]);
		}

		if (minPQ.size > maxPQ.size + 1) {
			maxPQ.insert(minPQ.pq[1]);
			minPQ.delete();
		}

		if (maxPQ.size > minPQ.size+1) {
			minPQ.insert(maxPQ.pq[1]);
			maxPQ.delete();
		}
		
		if (minPQ.size == maxPQ.size) {
			median = (maxPQ.pq[1] + minPQ.pq[1])/2.0;
		} else if(minPQ.size > maxPQ.size) {
			median = minPQ.pq[1];
		} else if (minPQ.size < maxPQ.size) {
			median = maxPQ.pq[1];
		}
		arr[i] = median;
	}
	return arr;
	}
}

