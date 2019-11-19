import java.util.*;
/**minheap class to create a minpq.
 * we use this to add left side elemnts in priority queue.
 * @author Ankith.
*/
class MinHeap {
    /**
     * @param size size of minpq.
     */
    int size;
    /**
     * @param pq array to store 
     */
    int[] pq;

    /**
     * constructor for minheap class.
     * @param capacity the capacity that is to be consider.
     */

    public MinHeap(int capacity) {
        pq = new int[capacity];
    }

    /**
     * void insert method to insert an element into the maximum  heap.
     * @param value value that isto be insertd din the maxheap.
     * complexity of insert method is logN. beacuse we call swim function after every insertion.
     */

    public void insert(int value) {
        pq[++size] = value;
        swim(size);
    }

    /**
     * delete the minimum element from the minheap.
     * @return delete element. which is minimum element.
     * complexity is logN. because we call sink fucntion after every one deletion.
     */

    public int delete() {
        int temp = pq[1];
        swap(1, size--);
        sink(1);
        pq[size + 1] = 0;
        return temp;
    }

    /**
     * void swap method to swap two elements.
     * @param i index of an element.
     * @param j index of an element.
     * the complexity is constant.
     */

    public void swap (int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * swim method to check whether the parent is lesser than childs are not.
     * @param k size of a max heap.
     * complexity is logN as it checks only half side of max pq.
     */

    public void swim(int k) {
        while(k > 1 && pq[k/2] > pq[k]) {
            swap (k, k/2);
            k = k/2;
        }
    }

    /**
     * methos sink to check wheather parent is less than
     *  childs are not if not we swap parents with child.
     * @param k we always pass 1 as a parameter to this function.
     * complexity of this method is logN.
     */

    public void sink(int k) {
        while (2*k <= size) {
            int j = 2 * k;
            if (j < size && pq[j] > pq[j+1]) {
                j++;
            }
            if (pq[k] < pq[j]) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

}