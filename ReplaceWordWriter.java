/**
 * Replaces every Word, which starts with an upper Case to "String replacement"
 */
package Marklar;

import java.io.BufferedWriter;
import java.io.Writer;
import java.io.IOException;

public class ReplaceWordWriter extends BufferedWriter {
	
	/**
	 * @param replacement
	 * 						String which replaces the given String str, if first case is upper Case
	 */
	private String replacement;
	public ReplaceWordWriter(Writer out) {
		super(out);
	}
	public ReplaceWordWriter(Writer out, String replacement) {
		super(out);
		this.replacement= replacement;
	}
	/**
	 * Checks if the first Case is an Upper Case and replaces the String with the replacement, given in the Constructor
	 * @param str
	 * 				String to check if, the first Character is upper Case
	 */
	@Override
	public void write(String str) throws IOException {
		char firstChar = str.charAt(0);
		if(Character.isUpperCase(firstChar)) {
			super.write(this.replacement);
		}else {
			super.write(str);
		}
	}
}
