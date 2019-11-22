/**
 * class LinearProbingHashST to create a linearprobing hasshtable.
 * @param <Key> generic type key.
 * @param <Value> generic type value.
 * @author Ankith.
 */
public class LinearProbingHashST<Key, Value> {

    private static final int INIT_CAPACITY = 4; //initial capacity  to intialise an array.
    private int n; // number of key value pairs.
    private int m; // array size.
    private Key[] keys; // keys type array.
    private Value[] vals; // value type array.

    /**
     * constructoir for linear probing hash table class.
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * parametric constructor for class linear probing hash tabale.
     * @param capacity the capacity  that is to be consider.
     */
    public LinearProbingHashST(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }

    /**
     * method hash to calculate the hash code for a key.
     * @param key key that is to be consider.
     * @return hashcode of a key.
     * complexity is constant.
     */
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    
    /**
     * method resize to resize an array.
     * @param capacity capacity that is to be consider.
     * complexity is O(N).
     */
    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }

    /**
     * method contains to check whether that key is present in taable or not.
     * @param key key that is to be consider.
     * @return boolean true or false.
     * constant complexity.
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * get method to get the value of a key.
     * @param key key that is to be consider.
     * @return value of the key.
     * complexity is 3 - 5 * in avg case.
     */
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }


    /**
     * method put to insert a key value pair into hashtabale.
     * @param key key that is to be consider.
     * @param val value that is to be consider.
     * complexity is 3-5* in avg case. 
     */
    public void put(Key key, Value val) {
        if (n >= m/2) resize(2*m);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
}