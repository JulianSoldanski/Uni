/**
 * author: Julian Soldanski, Bo-Ji Wong
 * 
 * Tests an Iterator of a List
 * Tests it's methods and if the exceptions work correctly
 */

package implementIterator;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
 

public class TestIterator {

	public static void main(String[] args) {
		TestIterator test = new TestIterator();
		System.out.println("Starting tests...");
		
		test.testNoSuchElementException();
		test.testConcurrentModificationException();
		test.testRun();
		test.testRemove();
		
		System.out.println("End Tests ...");
	}
	/**
	 * Tests the NoSuchElementException(), by looking for the next input, if there aren't any,
	 * which is thrown, if there are no more Elements in the List
	 */
	
	public void testNoSuchElementException() {
		MyList<Integer> s = new MyList<Integer>();
		s.add(3);
		s.add(4);
		Iterator<Integer> iter = s.iterator();
		while(iter.hasNext()) {
			iter.next();
		}
		
		try {
			iter.next();
		}
		catch(NoSuchElementException e) {
			System.out.println("NoSuchElementException works...");
		}
		
	}
	/**
	 * Tests the ConcurrentModificationException(),
	 * which is thrown, if the List gets modified while the Iterator is running 
	 */
	public void testConcurrentModificationException() {
		MyList<Integer> s = new MyList<Integer>();
		
		Iterator<Integer> iter = s.iterator();
		
		s.add(3);
		
		try {
			iter.next();
		}catch(ConcurrentModificationException e) {
			System.out.println("Modification Exception works ...");
		}
	}
	/**
	 * Tests  if the Iterator runs through the whole List,
	 * by comparing the length of the Iterator length
	 * and the List length
	 * 
	 * @param iterNextCount = -1 
	 * 			is one less because the List starts at null which isn't a 
	 * 			number
	 */
	public void testRun() {
		MyList<Integer> s = new MyList<Integer>();
		int iterNextCount = -1;
		int iCount = 0;
		
		for(int i = 0; i < 5; i++) {
			s.add(i);
			iCount++;
		}
		Iterator<Integer> iter = s.iterator();
		
		while(iter.hasNext()) {
			iter.next();
			
			iterNextCount++;
		}
		assert(iCount==iterNextCount);
		
		System.out.println("Runthrough works...");
		
		
		
	}
	/**
	 * Tests if the iterator is able to remove elements from the List,
	 * by deleting the only Element in a List and checking if it is at the End already
	 * 
	 * Also tests if IllegalStateException() is working, by trying to 
	 * remove a non existing element
	 * 
	 * IllegalStateException is thrown if a method has been invoked at an illegal or inappropriate time,
	 * In this case deleting what isn't there
	 * 
	 */
	public void testRemove() {
		MyList<Integer> s = new MyList<Integer>();
		s.add(4);
		
		Iterator<Integer> iter = s.iterator();
		
		iter.next();
		
		iter.remove();
		
		assert(!iter.hasNext());
		System.out.println("Removing an item works...");
		
		try {
			iter.remove();
		}catch(IllegalStateException e) {
			System.out.println("IllegalStateException works...");
		}
	
		
		
	}

}
