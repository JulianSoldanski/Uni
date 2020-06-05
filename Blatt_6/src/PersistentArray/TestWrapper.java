package PersistentArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;


/**
 * 
 * @author julian soldanski, bo-ji wong
 *
 * Creates saves and overrides an Array in a txt file. 
 * Reads a specific index from it and can make the file readable only.
 */

public class TestWrapper {
	private int searchedInt ;
	/**
	 * Creates a new File if it doesn't exist and writes the given Array in it
	 * @param arr
	 * 				Writes the array into the file
	 * @param name
	 * 				Creates a file with this name or uses a file with this name 
	 */
	public TestWrapper(int[] arr, String name) {
		File text = new File(name);
		
		
		if(!text.exists()) {
			try {
				text.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	
		try(RandomAccessFile RaFile = new RandomAccessFile(name, "rw")){
			RaFile.seek(0);
			for(int i = 0 ; i < arr.length ; i++) {
				RaFile.writeInt(arr[i]);
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFoundException works..");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the Integer with the given index 
	 * @param name
	 * 				file to search in
	 * @param index
	 * 				index of the integer which gets returned
	 * @return
	 * 				searchedInt Integer with the given Index
	 */
	public int searchIndex(String name, int index) {
		try(RandomAccessFile readFile = new RandomAccessFile(name, "rw")){
			readFile.seek(0);
			readFile.skipBytes((index-1)*4); //Skips all Integers until the Integer under the given index;
			searchedInt = readFile.readInt();
			
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFoundException works...");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException works...");
			e.printStackTrace();
		}
		return searchedInt;
		
	}
	/**
	 * Creates a file with given name or uses the file with the given name and changes to read only
	 * Used to test FileNotFoundException
	 * @param name
	 * 				name of the file
	 */
	public void setReadOnly(String name) {
		File readOnly = new File(name);
		if(!readOnly.exists()) {
			try {
				readOnly.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		readOnly.setReadOnly();
	}
	

	


}
