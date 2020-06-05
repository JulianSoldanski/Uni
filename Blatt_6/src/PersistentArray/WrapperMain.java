package PersistentArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WrapperMain {

	public static void main(String[] args){
		Wrapper wrap = new Wrapper();
		
		File file = new File("array.txt");
		int[] arr = {3,5,7};
		
		System.out.println("Starting tests..");
		
		wrap.createFile(file);
		
		assert(file.exists());
		
			wrap.writeArr(arr, "test");

			
		
		
		
		
		//File exception = new File("");
		
		//wrap.createFile(exception);
			
		}
	}


