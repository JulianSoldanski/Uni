package visitor;
/**
 * Tests the visitors, running through the whole List and stopping at a specific Point  
 * 
 * @author julian soldanski, Bo-Ji Wong
 *	
 */



public class TestVisitor{
	
	/**
	 * Tests 2 different behaving Visitors for MyList..
	 * Visitor vis moves through the whole List and Copies every Element
	 * Visitor stopVis moves through the List until a specific Integer (5)
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting tests...");
		
		TestVisitor test = new TestVisitor();
		
		MyList<Integer> l = new MyList<Integer>();
		MyList<Integer> copyLis = new MyList<Integer>();
		MyList<Integer> copyLisOrdered = new MyList<Integer>();
		MyList<Integer> copyStop = new MyList<Integer>();
 		
		l.add(1);
		l.add(3);
		l.add(5);
		l.add(1);
		l.add(2);
		l.add(4);
		//Vis moves through the whole List
		Visitor<Integer> vis = new Visitor<Integer>() {
			/**
			 * Visitor which runs through the whole List
			 * Copies the List to check if it works
			 */
			@Override
			public boolean visit(Integer o) {
				copyLis.add(o);
				return true;
			}
			
		};
		
		//stopVis stops at a specific Integer(5)
		Visitor<Integer> stopVis = new Visitor<Integer>() {
			/**
			 * Visitor that stops at a specific Integer
			 */
			@Override
			public boolean visit(Integer o) {
				  if(o == null) {
					  return true;
				  }else if(o == 5) {
					  return false;
				  }else {
					  copyStop.add(o);
					  return true;
				  }
			}
		};
		l.accept(vis);
		//To compare the copied List I need to order it first
		
		while(!copyLis.endpos()) {
			copyLisOrdered.add(copyLis.elem());
			copyLis.advance();
		}
		copyLisOrdered.reset();
		copyLisOrdered.advance();
		l.reset();
		
		//Compares l and copyLisOrdered by comparing every element in it
		System.out.println("Test accept without stopping...");
		while(!l.endpos()) {
			assert(copyLisOrdered.elem()==l.elem());
			copyLisOrdered.advance();
			l.advance();
		}
		l.reset();
		
		
		System.out.println("Test accept with stopping");
		l.accept(stopVis);
		
		assert(!test.checkIfIn(5, copyStop));
	
		System.out.println("End tests...");

	}
	
	/**
	 * Method to check if an specific Integer is in a List
	 * Utilizing this to check if the visitor stopVis actually stops at a given Variable
	 * @param searchedInt
	 * 				The searched Integer
	 * @param lst
	 * 				The List where you search in
	 * @return true
	 * 	 			if the Integer is in
	 */
		public boolean checkIfIn(int searchedInt, MyList<Integer> lst) {
			lst.reset();
			while(!lst.endpos()) {
				if(lst.elem() == searchedInt) {
					return true;
				}
				lst.advance();
			}
			return false;
		}
}