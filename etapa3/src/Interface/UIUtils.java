/*
 * Created on 6 Jan 2014 14:49:07 
 */
package Interface;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @author ingrid
 * 
 */
public class UIUtils {

	public static final UIUtils INSTANCE = new UIUtils();

	private final BufferedReader reader;

	private UIUtils() {
		this.reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public void handleUnexceptedError(Exception e) {
		System.out.println("Unhandled exception");
		e.printStackTrace();
		System.exit(-1);
	}

	public Double readDouble(String field) {
		Double value = null;
		while (value == null) {
			try {
				System.out.print(field + ": ");
				value = new Double(reader.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Entrada inválida");
			} catch (Exception e) {
				handleUnexceptedError(e);
			}
		}
		return value;
	}

	public Integer readInteger(String field) {
		Integer value = null;
		while (value == null) {
			try {
				if (field != null)
					System.out.print(field + ": ");
				value = new Integer(reader.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Entrada inválida");
			} catch (Exception e) {
				handleUnexceptedError(e);
			}
		}
		return value;
	}

	public Integer readInteger(String field, int min, int max) {
		Integer value = null;
		while (value == null) {
			value = readInteger(field);
			if (value < min || value > max) {
				value = null;
				System.out.println("O valor deve estar entre " + min + " e " + max);
			}
		}
		return value;
	}

	public String readString(String field) {
		String value = null;
		while (value == null) {
			try {
				if (field != null)
					System.out.print(field + ": ");
				value = reader.readLine();
			} catch (Exception e) {
				handleUnexceptedError(e);
			}
		}
		return value;
	}

}
