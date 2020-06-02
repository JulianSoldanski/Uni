package implementIterator;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<E> implements Iterator{
	private MyList<E> top;
	private MyEntry<E> current;
	
	private int modCountAtCreation;
	
	ListIterator(MyEntry<E> current, MyList<E> top){
		this.current = current;
		this.top = top;
		
		this.modCountAtCreation = top.getModCount();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return current != null;
	}

	@Override
	public E next() {
		if(this.modCountAtCreation != top.getModCount()) {
			throw new ConcurrentModificationException();
		}
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		MyEntry<E> returnValue = current;
		this.current = this.current.next;

		return returnValue.o;
		
	}

}
