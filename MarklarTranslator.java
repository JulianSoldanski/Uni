/**
 * Reads the Input of the Standard InStream and prints it on the Standard OutStream
 * Translates every Word with an upper Case into "Marklar"
 */
package Marklar;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class MarklarTranslator {
	
	
	
	public static void main(String[] args) throws IOException {

		final WriterThread write = new WriterThread(System.in);
		
		
		final ReaderThread read = new ReaderThread(new ReplaceWordWriter(new OutputStreamWriter(System.out),"Marklar"));
		
		//Connects the two Pipes
		try {
			read.connect(write);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//ExceptionHandler for the Threads
		Thread.UncaughtExceptionHandler exceptionHandler = new Thread.UncaughtExceptionHandler() {
			public void uncaughtException(Thread arg0, Throwable arg1) {
				arg1.printStackTrace();
			}
		};
		Thread t1 = new Thread(write);
		Thread t2 = new Thread(read);
		
		t1.setUncaughtExceptionHandler(exceptionHandler);
		t2.setUncaughtExceptionHandler(exceptionHandler);
		
		t1.start();
		t2.start();
		
		
		//Closes the threads when the ShutdownHook gets used
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {                                                   
				try {
					write.close();
					read.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		

	}

}
