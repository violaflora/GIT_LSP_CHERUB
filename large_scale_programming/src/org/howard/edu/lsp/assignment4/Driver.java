package org.howard.edu.lsp.assignment4;

import org.howard.edu.lsp.assignment4.IntegerSet.IntegerSetException;
import java.util.List;

public class Driver {

	public static void main(String[] args) throws IntegerSetException {
		// TODO Auto-generated method stub
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);

		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Smallest value in Set1 is: " + set1.smallest());
		System.out.println("Largest value in Set1 is: " + set1.largest());

		IntegerSet set2 = new IntegerSet();
		set2.add(4);
		set2.add(5);

	
		System.out.println("Union of Set1 and Set2: ");
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		set1.union(set2);	// union of set1 and set2
		System.out.println("Result of union of Set1 and Set2: ");
		set1.toString();	// result of union of set1 and set2
		System.out.println("New value of set1 is: " + set1.toString());
		System.out.println("Length of Set1 is: " + set1.length());
		System.out.println("Is Set1 equivalent to Set2? " + set1.equals(set2));
		set1.remove(5);
		set1.intersect(set2);
		System.out.println("Intersection between Set1 and Set2: " + set1.toString());
		//System.out.println(set1.toString() + set2.toString());
		set2.complement(set1);
		System.out.println("Complement of s2: " + set2.toString());
		System.out.println("Set 1 is empty: " + set1.isEmpty());
	}

}
