/**
 * class LinearProbingHashST.
 *used to create a hashtable using key and value type generics.
 *reference algs4.
 *@author Ankith.
 * @param <Key> generic type keys.
 * @param <Value> generic type value. 
 */
public class LinearProbingHashST<Key, Value> {
    /**
     * @param INTIT_CAPACITY the size.
     * @param m size of an array.
     * @param keys the array of keys.
     * @param vals the array of values.
     */
    private static final int INIT_CAPACITY = 4;
    private int n;
    private int m;
    private Key[] keys;
    private Value[] vals;

    /**
     * constructoer with out parameters.
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * constructor with parameters.
     * @param capacity the capacity that is to be consider.
     */

    public LinearProbingHashST(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }

    /**
     * method contains to check whether the key is present in the table or not.
     * @param key the key that is tobe searched.
     * @return key.
     * constant time complpexity.
     */

    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * hash method to calculate key hash value.
     * @param key the key that is to be calculate.
     * @return hashcode of a key.
     * conastant time complpexity.
     */
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    /**
     * resize meethod to resix=ze the array when we need.
     * @param capacity the size of the array that to be create.
     * N complexity.
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
     * put method to insert the key value pair into the hash table.
     * @param key the key that  to be consider.
     * @param val the value that is to be consider.
     * O(N) is complexity.
     */
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
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

    /**
     * get method to get the vale of a key which is passed.
     * @param key the key that is to be passed.
     * @return value of the key.
     * complexity is O(N).
     */
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    /**
     * delete method to delete a key from a hashtable.
     * @param key the key that is tobe deleted.
     * complexity is O(N).
     */

    public void delete(Key key) {
        if (!contains(key)) return;

        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        keys[i] = null;
        vals[i] = null;

        i = (i + 1) % m;
        while (keys[i] != null) {
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;

        if (n > 0 && n <= m/8) resize(m/2);
    }

    // /**
    //  * main method. the execution of the program will stats from here.
    //  * @param args args.
    //  */
    // public static void main(String[] args) { 
    //     LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
    //     st.put("a", 1);
    //     System.out.println(st.get("a"));
    // }
}