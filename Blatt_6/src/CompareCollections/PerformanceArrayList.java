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
		
		
		for(Collection<Integer> a : hashCollection) {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			long start = System.nanoTime();
			for(int i = 0; i < 100000; i++) {
				arrayList.add(5);
			}
			long add = System.nanoTime();
			for(int i = 0; i < 100000; i++) {
				arrayList.contains(i);
			}
			long contains = System.nanoTime();
			System.out.println("Time add in nanosec: " + ((add-start)/ 100000));
			System.out.println("Time contains in nanosec: " + ((contains-add)/100000));
				
		}
	}
}

