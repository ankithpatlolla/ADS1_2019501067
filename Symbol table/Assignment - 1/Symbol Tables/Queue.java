import java.util.*;

/**
 * public class queue to implement keyy to unse it in iterator method.
 * @author Ankith.
 * @param <Item> the generic type.
 */
public class Queue<Item> implements Iterable<Item> {
    /**
     * @param q the queue which is to be implemented.
     */
    public Item[] q;
    /**
     * @param n the size of the queue.
     */
    public int n;
    /**
     * @param first the starting pointer.
     * @param last the ending pointer.
     */
    public int first;
    public int last;

    /**
     * constructor for queue class.
     */
    public Queue() {
        this.q = (Item[]) new Object[2];
        this.n = 0;
        this.first = 0;
        this.last = 0;
    }
    /**
     * boolean isempty method to check whether the queue is empty or not.
     * @return boolean.
     * complexity is constant.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * method size to \check the size.
     * @return \size of the queue.
     * complexity is constant.
     */
    public int size() {
        return n;
    }

    /**
     * resize method to resize the queue.
     * @param capacity the size to be consider.
     * the complexioty of the method is N.
     */
    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        first = 0;
        last  = n;
    }

    /**
     * method enqueue to insert an item into queue. 
     * @param item that is to be inserted into  the queue.
     * complexity is N because we use resoize method.
     */
    public void enqueue(Item item) {
        if (n == q.length) resize(2*q.length);
        q[last++] = item;
        if (last == q.length) last = 0;
        n++;
    }

    /**
     * dequeue method to remove an element from  queue.
     * @return deleted element.
     * complexity is N.
     */
    public Item dequeue() {
        Item item = q[first];
        q[first] = null;
        n--;
        first++;
        if (first == q.length) first = 0;
        if (n > 0 && n == q.length/4) resize(q.length/2); 
        return item;
    }

    /**
     * method iterator to iterarte through the queue.
     */
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    /**
     * class ArrayIterator to perform iterator on queue.
     */
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext()  { return i < n;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }
    /**
     * toString method to dispaly the output.
     * complexity is N.
     */
    public String toString(){
        String st = "";
        int i;
        for (i = 0; i < last ; i++) {
            st += q[i] + " ";
        }
        return st;
    }
}