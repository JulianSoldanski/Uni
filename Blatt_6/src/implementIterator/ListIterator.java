/**
 * author: Julian Soldanski, Bo-Ji Wong
 * Iterator which is able to run through and delete elements in a List
 */

package implementIterator;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<E> implements Iterator{
	/**
	 * list
	 * 		the Object of the List which is uses by this Iterator
	 */
	
	private MyList<E> list;
	
	/**
	 * current
	 * 			the current used element in the List
	 */
	private MyEntry<E> current;
	
	/**
	 * nextCount
	 * 			checks if E next() got used before using remove()
	 */
	private boolean nextCount;
	
	/**
	 * modCountAtCreation
	 * 						Count of modifications before the iterator runs
	 */
	
	private int modCountAtCreation;
	
	/**
	 * Creates the iterator of the List
	 * @param current
	 * 					the current element of the List
	 * @param list
	 * 					the object of the List where the Iterator runs through
	 */
	
	ListIterator(MyEntry<E> current, MyList<E> list){
		this.current = current;
		this.list = list;
		
		this.modCountAtCreation = list.getModCount();
	}

	/**
	 * Checks if the next element in a List exists
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return current != null;
	}
	/**
	 * Goes to the next Element of the List and enables remove()
	 * @throws ConcurrentModificationException()
	 * 											if the List got modified while the Iterator is running
	 * @throws NoSuchElementException() 		
	 * 									if the List doesn't a next element
	 * @return returnValue.o
	 * 						returns the Value of the current Element
	 */

	@Override
	public E next() {
		this.nextCount = true;
		if(this.modCountAtCreation != list.getModCount()) {
			throw new ConcurrentModificationException();
		}
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		MyEntry<E> returnValue = current;
		this.current = this.current.next;

		return returnValue.o;
		
	}
	/**
	 * If E next() got used before this, removes an Element from the List
	 * Can't be used twice in a row, next needs to be used again after removing before removing again
	 * @throws ConcurrentModificationException()
	 * 											if the List got modified
	 * @throws IllegalStateException()
	 * 									if the element is null
	 */
	public void remove() {
		if(this.modCountAtCreation != list.getModCount()) {
			throw new ConcurrentModificationException();
		}
		
		if(this.nextCount) {
			this.current = null;
		}else {
			throw new IllegalStateException();
		}
		this.nextCount = false;
	}
	
	
}
