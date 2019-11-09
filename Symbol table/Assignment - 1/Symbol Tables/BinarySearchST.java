import java.util.*;
/**
 * class binaray searchst to create a binary search symbol table.
 * reference algs4.
 * @author Ankith.
 * @param <Key> generic type.
 * @param <Value> generic type.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    /**
     * @param INTI_CAPACITY the size.
     * @param keys key type array.
     * @param vals value t\ype array.
     * @param n size .
     */
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int n = 0;
    /**
     * constructor for class.
     */
    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    /**
     * parametric constru ctor for class.
     * @param capacity the capacity of table.
     */
    public BinarySearchST(int capacity) { 
        keys = (Key[]) new Comparable[capacity]; 
        vals = (Value[]) new Object[capacity]; 
    }   
    /**
     * resizing method to resize the array when needed.
     * complexity is N.
     * @param capacity the capacity that is to be consider.
     */
    private void resize(int capacity) {
        assert capacity >= n;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }

    /**
     * method size for return size.
     * @return size of table.
     * constant complexity,
     */
    public int size() {
        return n;
    }

    /**
     * method isempty to check the table is empty or not.
     * @return true if size is zero.
     * constant complexity.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * contains method to check whether the table containing tnhat key or not.
     * @param key the key that is to be check.
     * @return key if not null.
     * complexity is constant.
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * get method to obtain the value of the key that is passsed.
     * @param key that key that is to be search.
     * @return value of that key.
     * complexity is logN.
     */

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null"); 
        if (isEmpty()) return null;
        int i = rank(key); 
        if (i < n && keys[i].compareTo(key) == 0) return vals[i];
        return null;
    } 

    /**
     * the rank method to check the where th key fits.
     * @param key the key that is to be check.
     * @return key position.
     * complexity is logN as we use binary search.
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null"); 

        int lo = 0, hi = n-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2; 
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1; 
            else if (cmp > 0) lo = mid + 1; 
            else return mid; 
        } 
        return lo;
    } 

    /**
     * put method to inserrt an eleement in bsst.
     * @param key the key that is to be put.
     * @param val the value that is to be fit.
     * complexity is N.
     */

    public void put(Key key, Value val)  {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null"); 

        if (val == null) {
            delete(key);
            return;
        }

        int i = rank(key);

        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        if (n == keys.length) resize(2*keys.length);

        for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    } 


    /** delete method to delete a key from table.
     * @param key the key that is to be delete.
     * complexity is N
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        if (isEmpty()) return;

        int i = rank(key);

        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        n--;
        keys[n] = null;
        vals[n] = null;

        if (n > 0 && n == keys.length/4) resize(keys.length/2);

    } 

    /**
     * deletemin method to delete the minimum key.
     * complexity is constant.
     */
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(min());
    }

    /**
     * min method to get the minimum key.
     * @return ,im key.
     */

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return keys[0]; 
    }

    /**
     * max method to return the max method.
     * @return maximum key.
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return keys[n-1];
    }

    /**
     * floor method which returns the same elemet if it is present else lesser avaialable key.
     * @param key the key that is to be consider.
     * @return key.
     * complexity is N as we use rank method.
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null"); 
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i-1];
    }

    /**
     * methhod iterable to iterate through the table.
     * @return queue with keys.
     * complexity is N.
     */
    public Iterable keys() {
        Queue<Key> q = new Queue<Key>();
        for (int i = 0; i < n; i++) {
            q.enqueue(keys[i]);
        }
        return q;
    }

}