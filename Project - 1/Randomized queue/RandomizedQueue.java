import java.util.NoSuchElementException;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;
/**
 * class randomizedqueue.
 * @param <Item> generic type.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] arr;
    private int size;
    private int initialCapacity = 2;

    // constructor.
    public RandomizedQueue() {
        arr = (Item[]) new Object[initialCapacity];
    }
    
    // boolean isempty method to check whether the randomized queue is empty or not.
    public boolean isEmpty() {
        return size == 0;
    }
    // size to get size.
    public int size() {
        return size;
    }

    // resize to resize the array.
    private void resize(int capacity) {
        if (capacity >= size) { 
            Item[] temp = (Item[]) new Object[capacity];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
    }
    // enqueue method to insert an item into queue.
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (size == arr.length) {
            resize(size * 2);
        }
        arr[size++] = item;
    }
    // deque method to remove an elelemt from queue.
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int idx = rand();
        // System.out.println(idx);
        Item item = arr[idx];
        arr[idx] = arr[size - 1];
        arr[size - 1] = null;
        size--;
        if (size > 0 && size == arr.length / 4) {
            resize(size / 2);
        }
        return item;
    }

    // rand to generate a random index in given range.
    private int rand() {
        return StdRandom.uniform(0, size);
    }

    // sample to get random item.
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return arr[rand()];
    }

    // iterator.
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext()  {
            return i < size;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return arr[i++];
        }
    }
    public static void main(String[] args) {
        // RandomizedQueue<Integer> q = new RandomizedQueue<>();
        // q.enqueue(4);
        // q.enqueue(6);
        // q.enqueue(5);
        // q.enqueue(10);
        // System.out.println(q.dequeue());
        // System.out.println(q.dequeue());
        // System.out.println(q.dequeue());
    }
}
