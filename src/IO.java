/**
 * @(#)IO.java
 * This file is designed to allow HCRHS students to collect information from the
 * user during Computer Science 1 and Computer Science 2.
 * @author Mr. Twisler, Mr. Gaylord
 * @version 2.01 2014/12/21
 *		*Updated fix to let \t work for all input/output
 *		*Added input methods to allow for console input
 *		*Allowed all get methods to work with all objects
 *		*Updated format methods to use String.format()
 */

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class IO {

	// Shows a message in a popup window
	public static void showMsg(Object obj) {
		JTextArea text = new JTextArea(obj.toString());
		text.setBorder(null);
		text.setOpaque(false);
		text.setEditable(false);
		//String text = obj.toString().replace("\t", "     ");
		JOptionPane.showMessageDialog(null, text, "HCRHS", 
			JOptionPane.PLAIN_MESSAGE);
	}

/*********************************User Input Methods***************************
 * All user input methods get the data type mentioned in their name and return
 * a default value if the user enters an incorrect responce.
 ******************************************************************************/
	
	// Returns String typed by user, default value is ""
	public static String getString(Object obj) {
		JTextArea text = new JTextArea(obj.toString());
		text.setBorder(null);
		text.setOpaque(false);
		text.setEditable(false);
		//String text = obj.toString().replace("\t", "     ");
		String ans = JOptionPane.showInputDialog(null, text, "HCRHS",
                     	JOptionPane.QUESTION_MESSAGE);
        if(ans == null) {
             return "";
        }
        return ans;
	}
	
	public static String nextString() {
		Scanner scan = new Scanner(System.in);
		String ans = scan.nextLine();
		scan.close();
        if(ans == null) {
             return "";
        }
        return ans;
	}
	
	// Returns int typed by the user, default value is 0
	public static int getInt(Object obj) {
		JTextArea text = new JTextArea(obj.toString());
		text.setBorder(null);
		text.setOpaque(false);
		text.setEditable(false);
		//String text = obj.toString().replace("\t", "     ");
		try {
			return Integer.parseInt(JOptionPane.showInputDialog(null, text, 
					"HCRHS", JOptionPane.QUESTION_MESSAGE));
		} catch (NumberFormatException e) {
			//System.out.println("Not a valid int");	
			return 0;
		}
	}
	
	public static int nextInt() {
		Scanner scan = new Scanner(System.in);
		int ans;
		try {
			ans = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			//System.out.println("Not a valid int");	
			ans = 0;
		}
		scan.close();
		return ans;
	}  
    
    // Returns double typed by the user, default value is 0.0
	public static double getDouble(Object obj) {
		JTextArea text = new JTextArea(obj.toString());
		text.setBorder(null);
		text.setOpaque(false);
		text.setEditable(false);
		//String text = obj.toString().replace("\t", "     ");
		try {
			return Double.parseDouble(JOptionPane.showInputDialog(null, text, 
						"HCRHS", JOptionPane.QUESTION_MESSAGE));
		} catch (NumberFormatException e) {
			//System.out.println("Not a valid double");
			return 0;
		} catch (NullPointerException e) {
			//System.out.println("Not a valid double");
			return 0;
		}
	}
	
	public static double nextDouble() {
		Scanner scan = new Scanner(System.in);
		double ans;
		try {
			ans = Double.parseDouble(scan.nextLine());
		} catch (NumberFormatException e) {
			//System.out.println("Not a valid double");
			ans = 0;
		} catch (NullPointerException e) {
			//System.out.println("Not a valid double");
			ans = 0;
		}
		scan.close();
		return ans;	
	}
	
	// Returns char typed by the user, default value is ' '
	public static char getChar(Object obj) {
		JTextArea text = new JTextArea(obj.toString());
		text.setBorder(null);
		text.setOpaque(false);
		text.setEditable(false);
		//String text = obj.toString().replace("\t", "     ");
        try {
			return JOptionPane.showInputDialog(null, text, "HCRHS", 
						JOptionPane.QUESTION_MESSAGE).charAt(0);
		} catch (NullPointerException e) {
			//System.out.println("Not a valid char");
			return ' ';
		} catch (StringIndexOutOfBoundsException e) {
			//System.out.println("Not a valid char");
			return ' ';
		}
	}
	
	public static char nextChar() {
		Scanner scan = new Scanner(System.in);
		char ans;
        try {
			ans = scan.nextLine().charAt(0);
		} catch (NullPointerException e) {
			//System.out.println("Not a valid char");
			ans = ' ';
		} catch (StringIndexOutOfBoundsException e) {
			//System.out.println("Not a valid char");
			ans = ' ';
		}
		scan.close();
		return ans;
	}
	
	// Returns boolean typed by the user, default value is false
	public static boolean getBoolean(Object obj) {
		JTextArea text = new JTextArea(obj.toString());
		text.setBorder(null);
		text.setOpaque(false);
		text.setEditable(false);
		//String text = obj.toString().replace("\t", "     ");
		int n = JOptionPane.showOptionDialog(null, text, "HCRHS", 
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
					null, new Object[]{"True", "False"}, 1);
		return (n == 0);
	}
	
	public static boolean nextBoolean() {
		Scanner scan = new Scanner(System.in);
		String bool = scan.nextLine().toLowerCase();
		scan.close();
		return bool.equals("true") || bool.equals("t") || bool.equals("1");
	}

/******************************Formatting Methods******************************
 * Format is overloaded to accept Strings/int/double/char/boolean
 ******************************************************************************/

	public static String format(char just, int maxWidth, String s)	{
		if (just == 'l' || just == 'L') {
			return String.format("%-" + maxWidth + "." + maxWidth + "s", s);
		} else if (just == 'r' || just == 'R') {
			return String.format("%" + maxWidth + "." + maxWidth + "s", s);
		} else if (just == 'c' || just == 'C') {
			return format('l', maxWidth, format('r', 
							(((maxWidth - s.length()) / 2) + s.length()), s));
		} else {
			return s;
		}
	}

	public static String format(char just, int maxWidth, int i) {
		return format(just, maxWidth, String.format("%d", i));
	}

	public static String format(char just, int maxWidth, double d, int dec) {
		return format(just, maxWidth, String.format("%,." + dec + "f", d));
	}	
		
	public static String format(char just, int maxWidth, char c) {
		return format(just, maxWidth, String.format("%c", c));
	}
	
	public static String format(char just, int maxWidth, boolean b) {
		return format(just, maxWidth, String.format("%b", b));
	}

/*********************************Fancy Expirmental Methods********************/

	public static String choice(String... options) {
        String s = (String)JOptionPane.showInputDialog(null, 
        				"Pick one of the following", "HCRHS", 
        				JOptionPane.PLAIN_MESSAGE, null, options, null);
		//If a string was returned, say so.
		if ((s != null) && (s.length() > 0)) {
    		return s;
		}
		return "";   
    } 
    	
    public static String readFile(String fileName) {
    	String ans ="";
    	try {
    		Scanner scanner = new Scanner(new File(fileName));
    		scanner.useDelimiter(System.getProperty("line.separator")); 
    		while (scanner.hasNext()) {
    			ans += scanner.next()+"\n";
    		}
    		scanner.close();
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	return ans;
    }
    
	public static void writeFile(String fileName, String data) {
		try {
			FileWriter fw = new FileWriter(fileName, true);
			fw.write(data);
			fw.close();
		} catch(java.io.IOException e) {
			e.printStackTrace();
		}
	}
}