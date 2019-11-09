import java.util.*;
/**
 * class queue to implement the symbol table.
 * reference algs4.
 * @param <Item> generic type item.
 */
public class Queue<Item> implements Iterable<Item> {
    /**
     * @param first,last,n first node, last node and size.
     */
    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * constructor for queue class.
     */
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    /**
     * boolean isempty method to check whether the queue is empty or not.
     * @return boolean.
     * complexity is constant.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * method enqueue to insert an item into queue. 
     * @param item that is to be inserted into  the queue.
     * complexity is N worst case.
     */
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    /**
     * dequeue method to remove an element from  queue.
     * @return deleted element.
     * complexity is N.
     */
    public Item dequeue() {

        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
    }
    /**
     * tostring method to displ output.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    } 

    /**
     * iterator method to iterate through the table.
     */
    public Iterator<Item> iterator()  {
        return new ListIterator(first);  
    }

    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }
        public boolean hasNext()  { return current != null;                     }
        public Item next() {
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

}