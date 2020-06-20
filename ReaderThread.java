/**
 * Reads the output of the WriterThread
 */
package Marklar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.Writer;

public class ReaderThread extends PipedReader implements Runnable{
	
	private Writer snk;

	public ReaderThread(Writer snk) {
		this.snk = snk;
	}
  
	@Override
	public void run() { 
		BufferedReader buf = new BufferedReader(this);
		while(true) {
			String text;
			try{
				while((text = buf.readLine()) != null) {
					this.snk.write(text);
					this.snk.write(System.getProperty("line.seperator"));
					this.snk.flush();
				}
			}catch (IOException e) {
			e.printStackTrace();
			}
		}
	}
	
}