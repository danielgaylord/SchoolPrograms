
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Randomizer {
	public static void main (String[] args) {
		String[] A1 = {"Jesse", "Maria", "Andrew", "Nick", "Allana", "Alyssa K", "Will", "Lino", "Emma", "Soham", "Zach", "Danielle", "Liz", "Alec", "Trent", "Eric", "Sarah", "Alyssa G", "Tara", "Jaime", "Gwen", "Jackie", "Kayla", "Lauren"};
		String[] A2 = {"John", "Chris", "Mark", "Austin", "Niki", "Hank", "Ryan", "Mike", "Eamonn", "Tom", "Andrew", "Bennett", "Alex", "Katie", "Chad", "Matt", "Becky", "Lauren", "Jason", "Erin", "Erika"};
		String[] A3 = {"Sri", "Liam", "Brandon", "Ken", "Dylan", "Jon", "Kara", "Ben", "Julia", "Feo", "Steve Gr", "Matt", "Dominic", "Steve Go", "Ryan C", "Andrew", "Ryan V", "Alex"};
		String[] B2 = {"Dan", "Alex", "Eric", "Frank", "Justin S", "Justin D", "Matt Z", "Matt K", "Tom", "Kevin", "Sven", "Trevor", "Laura", "Lindsay", "Ashley", "Jake", "Atmika", "Jack", "Dave", "Soham", "Dilan", "Will"};

		ArrayList<String> list = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		String cont = "";
		
		while (!cont.equalsIgnoreCase("done")) {
			Collections.addAll(list, A1);
			
			while (!cont.equalsIgnoreCase("done") && list.size() > 0) {
				System.out.printf("%s & ", (String)list.remove((int)(Math.random() * list.size())));
				System.out.printf("%s", (String)list.remove((int)(Math.random() * list.size())));
				cont = scan.nextLine();
			}
		}
	}
}