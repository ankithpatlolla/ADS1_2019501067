/**
 * class ThreeArrays to devolope a bst based on 3 arrays.
 * reference Vamsikrishnanunna
 * @author Ankith.
 * @param <Key> generic type.
 * @param <Value> generic type.
 */
public class ThreeArrays<Key extends Comparable<Key>, Value> {
    /**
     * @param keys arraay of keys.
     * @param values array of values.
     * @param lIdx left side array.
     * @param rIdx right side array.
     *@param sizes size.
     * 
     */
    Key[] keys;
    Value[] values;
    int[] lIdx;
    int[] rIdx;
    int[] sizes;
    /**
     * constructor
     */
    ThreeArrays() {
        this.keys = (Key[]) new Comparable[20];
        this.values = (Value[]) new Object[20];
        this.lIdx = new int[20];
        this.rIdx = new int[20];
        this.sizes = new int[20];

        for (int i = 0; i < 20; i++) {
            lIdx[i] = -1;
            rIdx[i] = -1;
        }
    }
   
   /**
    * size method to  get  the size.
    * @return size.
    */
    public int size() {
        return sizes[0];
    }

    public int size(int idx) {
    if (idx == -1) {
    return 0;
    } 
    else {
    return sizes[idx];
    }
    }
    /**
     * contain methiod to  chec whether the key is present in the table or not.
     * @param key the key that is to be check.
     * @return true or false if key contains in it
     * complexity is N.
     */
    public boolean contains(Key key) {
        for (Key eachKey : keys) {
            if(eachKey.compareTo(key) == 0) {
                return true;
            }
        }
        return false;
    }
    /**
     *
     * @param key the key that is to be pass.
     * @return the value of a key.
     */
    public Value get(Key key) {
        return get(0, key);
    }
    /**
     * get the value with idx
     * @param idx thata index that is passed from  get method.
     * @param key the  key that is to be consider.
     * @return value of idx
     * complexity is N.
     */
    public Value get(int idx, Key key) {

        if (idx < 0) {
            return null;
        }

        int cmp = key.compareTo(keys[idx]);

        if (cmp < 0) {
            
            return get(lIdx[idx], key);

        } else if (cmp > 0) {
            
            return get(rIdx[idx], key);

        } else {
            return values[idx];
        }
    }
    /**
     * put method to minsert an opair to table.
     * @param key the key.
     * @param val the value.
     * complexity is  N.
     */
    public void put(Key key, Value val) {
        put(0, key, val);
    }

    /**
     * put method to insert an element at given index
     * @param idx the index.
     * @param key the key.
     * @param val the value.
     * @return indexx to another put method.
     */
    public int put(int idx, Key key, Value val) {
        if (idx  == -1 || keys[idx] == null) {

            idx = size();
            keys[idx] = key;
            values[idx] = val;
            sizes[idx] = 1;

            return idx;
        }

        int cmp = key.compareTo(keys[idx]);
        if(cmp < 0) {
            lIdx[idx] = put(lIdx[idx],  key, val);       
        } else if (cmp > 0) {
            rIdx[idx] = put(rIdx[idx], key, val);
        }
         else {

            values[idx] = val;
        }

        sizes[idx] = size(lIdx[idx]) + size(rIdx[idx]) + 1; 

        return idx;
    }
    /**
     * tostring method to display the output.
     * @return output.
     */

    public String printThreeArrays() {

        String out = "Key : Val\tLeft\tRight\n__________________________________ \n";

        for (int i = 0; i < size(); i++) {
            String key = (String)keys[i];
            String leftKey = "-";
            String rightKey = "-";
            if (lIdx[i] != -1) {
                leftKey = (String) keys[lIdx[i]];
            }

            if(rIdx[i] != -1) {
                rightKey = (String) keys[rIdx[i]];
            }

            out += key + " : " + (Integer) values[i] + "\t\t"  + leftKey +"\t" + rightKey + "\n";
        }

        return out;
    }

    /**\
     * main method my program execution will start from  here.
     * we create a threearray object and will insert all the key
     * value pairs into the table using put method.
     */
    public static void main(String[] args) {
        ThreeArrays<String, Integer> bst = new ThreeArrays<String, Integer>();

        bst.put("h",0);
        bst.put("a",1);
        bst.put("r",2);
        bst.put("r",3);
        bst.put("y",4);
        bst.put("p",5);
        bst.put("o",6);
        bst.put("t",7);
        bst.put("t",8);
        bst.put("e",9);
        bst.put("r",10);
        bst.put("x",11);

        System.out.println(bst.printThreeArrays());
    }
}