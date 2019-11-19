import java.util.NoSuchElementException;
import java.util.*;
/**
 * claass BSST which contains put, get, resize methods.
 * @param <Key> generic type keys.
 * @param <Value> generic type values.
 * @author Ankith.
 */
public class BSST<Key extends Comparable<Key>, Value> {

    /**
     * @param keys keys array.
     * @param values values array.
     * @param n size.
     */
	Key[] keys;
	Value[] values;
    int n = 0;
    
    /**
     * constructor for BSST class to create a binary search symbol table with given capacity.
     * @param capacity the capacity of symbol table.
     */
	public BSST (int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Object[capacity];
    }
    

    /**
     * rank method to find the number of keys before the given key.
     * @param key key which ran is to find.
     * @return return integer rank.
     * complexity is logN.
     */
	public int rank (Key key) {
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
     * resize method to resize the sizes of keys and values arrays.
     * complexity is O(N).
     */
	private void resize(int capacity) {
        assert capacity >= n;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

    /**
     * method delete to delete a key value pair from the symbol table.
     * @param key key that is to deleted.
     * complexity is O(N).
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        if (n == 0) return;
        int i = rank(key);
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            values[j] = values[j+1];
        }
        n--;
        keys[n] = null;
        values[n] = null;
        if (n > 0 && n == keys.length/4) resize(keys.length/2);
    } 

    /**
     * get method to get a vakue of a given key.
     * @param key key  which value we have to get.
     * @return value of the key given.
     */
    public Value get (Key key) {
    	if (key == null) throw new IllegalArgumentException("argument to get() is null"); 
        if (n == 0) return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) return values[i];
        return null;
    }

    /**
     * put method to insert a key value pair into symbol table.
     * @param key key that is to be inserted.
     * @param value value that is to be inserted.
     * complexity is O(N);
     */
	public void put (Key key, Value value) {
		if (key == null) throw new IllegalArgumentException("key can't be null");
		if (value == null) {
			delete(key);
			return;
		}
		if (n == keys.length) resize(2*keys.length);

		if (n == 0) {
			keys[n] = key;
			values[n] = value;
			n++;
			return;
		}
		if (key.compareTo(keys[n - 1]) > 0) {
			keys[n] = key;
			values[n] = value;
			n++;
			return;
		}
		int i = rank(key);
		if (key.compareTo(keys[i]) == 0) {
			values[i] = value;
			return;
		}

        for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }
    
    /**
     * toString method to display the output.
     */
	public String toString() {
		return "Key[] " + Arrays.toString(keys) + "\n" + "value[]  " + Arrays.toString(values);
	}
}