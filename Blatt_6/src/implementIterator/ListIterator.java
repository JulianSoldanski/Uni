package implementIterator;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<E> implements Iterator{
	private MyList<E> list;
	private MyEntry<E> current;
	
	private int nextCount;
	
	private int modCountAtCreation;
	
	ListIterator(MyEntry<E> current, MyList<E> list){
		this.current = current;
		this.list = list;
		
		this.modCountAtCreation = list.getModCount();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return current != null;
	}

	@Override
	public E next() {
		this.nextCount++;
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
	
	public void remove() {
		if(this.modCountAtCreation != list.getModCount()) {
			throw new ConcurrentModificationException();
		}
		
		if(this.nextCount > 0) {
			this.current = null;
		}else {
			throw new IllegalStateException();
		}
		this.nextCount = 0;
	}
	
	
}
