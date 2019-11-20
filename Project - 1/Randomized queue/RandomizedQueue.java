import java.util.*;
public class RandomizedQueue<Item> implements Iterable<Item> {
	Item[] arr;
	int size;
	int initialCapacity = 2;

	public RandomizedQueue () {
		arr = (Item[]) new Object[initialCapacity];
	}

	public boolean isEmpty () {
		if (size == 0) return true;
		else return false;
	}

	public int size () {
		return size;
	}

	public void resize(int capacity) {
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		arr =temp;
	}
	public void enqueue(Item item) {
		if (item == null) throw new IllegalArgumentException("item can't be null");
		if (size == arr.length) resize(size * 2);

		arr[size++] = item;
	}
	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException("queue empty can't perform dequeue");
		Item item = arr[0];
		arr[0] = arr[size - 1];
		arr[size -1] = null;
		size--;

		if (size > 0 && size = arr.length / 4) return resize(size / 2);
	}

	public Item sample() {
		return arr[0];
	}
		 public Iterator<Item> iterator()  {
        return new ListIterator(head);  
    }
    public class ListIterator implements Iterator<Item> {
        public Node<Item> current;

        public ListIterator(Node<Item> head) {
            current = head;
        }

        public boolean hasNext()  { return current != null;                     }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
	}
}