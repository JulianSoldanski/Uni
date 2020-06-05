/**
 * Author: Julian Soldanski, Bo-Ji Wong
 * 
 * Tests the persistent saving of an Array and it's Exceptions
 */

package PersistentArray;

import java.io.File;
import java.io.FileNotFoundException;


public class Wrapper {
	public static void main(String[] args) {
		
		System.out.println("Starting tests...");
		
		int[] testArr = {3,6,7,1,3};
		
		System.out.println("Creating a text file and writing an array in it...");
		TestWrapper file1 = new TestWrapper(testArr, "array.txt");
		
		System.out.println("Testing searchIndex(String name, int index) and TestWrapper(int[] arr, String name)");
		assert(file1.searchIndex("array.txt", 3) == 7);
		System.out.println("searchIndex and TestWrapper work");
		
		System.out.println("Test IOException..");
		
		file1.searchIndex("array.txt", 10);
		file1.setReadOnly("readOnly.txt");
		
		System.out.println("Test FileNotFoundException...");
		TestWrapper readOnly = new TestWrapper(testArr, "readOnly.txt");
		
		
		System.out.println("End tests..");
			
		
	}
}
