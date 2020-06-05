/**
 * author: Bo-Ji Wong, Julian Soldanski
 * 
 * Compares ArrayList, HashSet and LinkedList regarding runtime speed
 */
package CompareCollections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class PerformanceArrayList {

	public static void main(String[] args) {
		Collection <Integer> arrayCollection = new ArrayList<Integer>();
		Collection <Integer> linkedCollection = new LinkedList<Integer>();
		Collection <Integer> hashCollection = new HashSet<Integer>();
		
		Collection[] toTest = new Collection[] {arrayCollection,linkedCollection,hashCollection};
		
		for(Collection <Integer> a : toTest){ //Tests all given Collections
			long start = System.nanoTime();
			for(int i = 0; i < 100000; i++) {
				a.add(i);
			}
			long add = System.nanoTime();
			
			for(int i = 0; i < 100000; i++) {
				a.contains(i);
			}
			long contains = System.nanoTime();
			
			for(int i = 0; i < 100000; i++) {
				a.remove(i);
			}
			long remove = System.nanoTime();
			
			
			System.out.println( a.getClass() +" 'add()': " + ((add - start)/100000) + " 'contains()': " + ((contains-add)/100000) + " 'delete()': " + ((remove-contains)/100000));
			
		}
	}
}

