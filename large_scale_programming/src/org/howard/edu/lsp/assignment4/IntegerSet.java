

package org.howard.edu.lsp.assignment4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 
 * @author Violet Edwards
 * @version 10/16/23
 */
public class IntegerSet {
    private List<Integer> my_set;
    /**
     * Initializes new set known as my_set to perform operations on
     */
    public IntegerSet() {
        my_set = new ArrayList<Integer>();
    }
    
    /**
     * Creation of an IntegerSetException
     */
    public class IntegerSetException extends Exception {
        private static final long serialVersionUID = 1L;

		/**
		 * Prints error by calling super()
		 * @param error string
		 */
        public IntegerSetException(String error) {
            super(error);
        }
    }
    
    //
    
    /**Clears the internal representation of the set
     * 
     */
    public void clear() {
        my_set.clear();
    }

    /**returns the length of the set
     * 
     * @return size of set
     */
    public int length() {
        return my_set.size();
    }
    
  /**Returns true if the set contains the value, otherwise false
   * 
   * @param a the set given
   * @return bool, are the sets equivalent
   */
    public boolean equals(IntegerSet a) {
        if (my_set.size() != a.length()) {
            return false;
        }
        else {
            return my_set.containsAll(a.my_set);
        }
    }
    
  /**Returns true if the set contains the value, otherwise false
   * 
   * @param value set
   * @return bool of whether set has value
   */
    public boolean contains(int value) {
        return my_set.contains(value);
    }
    
  /**Returns the largest item in the set; Throws a IntegerSetException if the set is empty
   * 
   * @return largest valye in set
   * @throws IntegerSetException if set is empty
   */
    public int largest() throws IntegerSetException {
        if (my_set.isEmpty()) {
            throw new IntegerSetException("The Set is Empty.");
        }
        else {
            int max = my_set.get(0);
            for (int i = 0; i < my_set.size(); i++) {
                if (my_set.get(i) > max) {
                    max = my_set.get(i);
                }
            }
            return max;
        }
    }
    
  /**Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
   * 
   * @return smallest value in set
   * @throws IntegerSetException if set is empty
   */
    public int smallest() throws IntegerSetException {
        if (my_set.isEmpty()) {
            throw new IntegerSetException("The Set is Empty.");
        }
        else {
            int min = my_set.get(0);
            for (int i = 0; i < my_set.size(); i++) {
                if (my_set.get(i) < min) {
                    min = my_set.get(i);
                }
            }
            return min;
        }
    }
    
    /** Adds an item to the set or does nothing it already there
     * 
     * @param item set
     */
    public void add(int item) {
        if (my_set.contains(item) == false) {
            my_set.add(item);
        }
    }
    
    /**Removes an item from the set or does nothing if not there
     * 
     * @param item set
     */
    public void remove(int item) {
        if (my_set.contains(item) == true) {
            my_set.remove(my_set.indexOf(item));
        }
    }
    
    /**Set union
     * 
     * @param b set
     */
    public void union(IntegerSet b) {
        for (int i = 0; i < b.length(); i++) {
            if (my_set.contains(b.my_set.get(i)) == false) {
                my_set.add(b.my_set.get(i));
            }
        }
    }
    
    /**Set intersection, all elements in s1 and s2
     * 
     * @param b set
     */
    public void intersect(IntegerSet b) {
        my_set.retainAll(b.my_set);
    }
    
    /**Set difference, i.e., s1 –s2
     * 
     * @param b set
     * @return difference between the two sets
     */
    public IntegerSet diff(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.set_set(my_set);
        result.diff(b);
        return result;
    }
    
    /**Set complement, all elements not in s1
     * 
     * @param intSetb give set to be used as complement
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> result = new ArrayList<>();
        for (Integer element : my_set) {
            if (!intSetb.contains(element)) {
                result.add(element);
            }
        }
        my_set = result;
    }
    
    /**Returns true if the set is empty, false otherwise
     * 
     * @return bool showing whether set is empty
     */
    public boolean isEmpty() {
        return my_set == null || my_set.isEmpty();
    }

    
    /**Return String representation of your set
     * 
     */
    public String toString() {
        return my_set.toString();
    }
    
    /**get method
     * 
     * @return set to get
     */
    public List<Integer> get_set() {
        return my_set;
    }
    
    /**set method
     * 
     * @param new_set set to set
     */
    public void set_set(List<Integer> new_set) {
        my_set = new_set;
    }
}