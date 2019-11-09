/**
 * class MAX heap we use this class to create a maximum heap.
 * methods in this class insert,delete,swap,swim,sink.
 * @author Ankith.
 */
public class MaxHeap {
    /**
     * @param size the size of the heap.
     */
    int size;
    /**
     * @param pq array which accepts double values.
     */
    double[] pq;

    /**
     * constructor for maxheap class.
     * @param capacity the capacity that is to be consider.
     */
    public MaxHeap(int capacity) {
        pq = new double[capacity];
    }

    /**
     * void insert method to insert an element into the maximum  heap.
     * @param key key that isto be insertd din the maxheap.
     * complexity of insert method is logN. beacuse we call swim function after every insertion.
     */
    public void insert(double key) {
        pq[++size] = key;
        swim(size);
    }

    /**
     * delete the maximum element from the maxheap.
     * @return delete element. which is maximum element.
     * complexity is logN. becaause we call sink fucntion after every one deletion.
     */
    public double delete() {
        double temp = pq[1];
        swap(1, size--);
        sink(1);
        return temp;
    }

    /**
     * void swap method to swap two elements.
     * @param i index of an element.
     * @param j index of an element.
     * the complexity is constant.
     */
    public void swap (int i, int j) {
        double temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * swim method to check whether the parent is greater than childs are not.
     * @param k size of a max heap.
     * complexity is logN as it checks only half side of max pq.
     */
    public void swim(int k) {
        while(k > 1 && pq[k/2] < pq[k]) {
            swap (k, k/2);
            k = k/2;
        }
    }
    /**
     * methos sink to check wheather parent is greate than
     *  childs are not if not we swap parents with child.
     * @param k we always pass 1 as a parameter to this function.
     * complexity of this method is logN.
     */
    public void sink(int k) {
        while (2*k <= size) {
            int j = 2 * k;
            if (j < size && pq[j] < pq[j+1]) {
                j++;
            }
            if (pq[k] > pq[j]) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }
}