import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * class Deque.
 */
public class Deque<Item> implements Iterable<Item>{
    private Node<Item> head;
    private Node<Item> tail;
    private int size;
    /**
     * node class.
     * @param <Item> generic type.
     */
    private class Node<Item> {
    Item item;
    Node<Item> next;
    Node<Item> previous;
    /**
     * constructor.
     * @param item item that is to be added.
     */
    Node(Item item) {
        this.item = item;
    }
}

// constructor.
    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }
// is empty method to check whether deque is empty or not.
    public boolean isEmpty() {
        return size == 0;
    }
// size method to get size of deque.
    public int size() {
        return size;
    }
// addfirst method to add an element at first.
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("empty deque");
        }
        Node<Item> node = new Node<Item>(item);
        if (isEmpty()) {
            head = node;
            tail = head;
            size++;
            return;
        } else {
            Node<Item> temp = head;
            head = node;
            head.next = temp;
            size++;
        }
    }
// addlast method to add an item at end.
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("empty deque");
        }
        Node<Item> node = new Node<Item>(item);
        if (isEmpty()) {
            tail = node;
            head = tail;
            size++;
            return;
        } else {
            Node<Item> temp = tail;
            tail = node;
            tail.previous = temp;
            size++;
        }
    }
// removefirst method to remove an item from first.
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty deque");
        } else if (size == 1) {
            Node<Item> temp = head;
            head = null;
            size--;
            return temp.item;
        } else {
            Node<Item> temp = head;
            head = head.next;
            size--;
            return temp.item;
        }
    }
// remove last method to remove an item from end.
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty deque");
    } else if (size == 1) {
        Node<Item> temp = tail;
        tail = null;
        size--;
        return temp.item;
    } else {
        Node<Item> temp = tail;
        tail = tail.previous;
        size--;
        return temp.item;
    }
}
// iterateor.
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node<Item> current = head;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            if (current == null) {
                throw new NoSuchElementException();
            } else {
                Item value = current.item;
                current = current.next;
                return value;
            }
        }
    }
    
    public static void main(String[] args) {
        // Deque<Integer> d = new Deque<Integer>();
        // d.addFirst(2);
        // d.addLast(4);
        // d.addFirst(3);
        // d.addLast(8);
        // System.out.println(d.removeFirst());
        // System.out.println(d.removeLast());
    }
}