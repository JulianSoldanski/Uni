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
