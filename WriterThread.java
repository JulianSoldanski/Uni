/**
 * Writes the given Input 
 */
package Marklar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedWriter;

public class WriterThread extends PipedWriter implements Runnable{
	
	private InputStream in;
	
	public WriterThread(InputStream in) {
		this.in = in;
	}

	@Override
	
	public void run() {
		BufferedReader buf = new BufferedReader(new InputStreamReader(this.in));
		String text;
		try{
			while((text = buf.readLine()) != null) {
				this.write(text + System.getProperty("line.seperator"));
				this.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
