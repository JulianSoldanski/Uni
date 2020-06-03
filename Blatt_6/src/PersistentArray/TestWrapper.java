package PersistentArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class TestWrapper {
	public static void main(String[] args) {
		File text = new File("array.txt");
		
		int[] arr = {1,4,6,2};
		
		if(!text.exists()) {
			try {
				text.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		/*
		RandomAccessFile a = null;
		try {
			a = new RandomAccessFile(text, "rw");
			a.writeChar(v);;
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(a != null) {
				try {
					a.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}*/
		try(RandomAccessFile RaFile = new RandomAccessFile("array.txt", "rw")){
			RaFile.seek(0);
			for(int i = 0 ; i < arr.length ; i++) {
				RaFile.writeInt(arr[i]);
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(RandomAccessFile readFile = new RandomAccessFile("array.txt", "rw")){
			readFile.seek(0);
			for(int i = 0 ; i < arr.length ; i++) {
				System.out.println(readFile.readInt());
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	


}
