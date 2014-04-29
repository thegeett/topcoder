package gcjPractice.year2014.round1A;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Bullseye {

	public static void main(String[] args) {
		String base = "C:\\programs\\GCJ\\FairAndSquare\\";
		String input = base + "input.in";
		String output = base + "output.out";
		try {
			Scanner sc = new Scanner(new FileReader(input));
			PrintWriter pw = new PrintWriter(output);

			int t = sc.nextInt();
			sc.nextLine();
			while (sc.hasNextLine()) {
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
