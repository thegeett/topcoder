package gcjPractice.year2014;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FairAndSquare {

	public static void main(String[] args) {
		String base = "C:\\programs\\GCJ\\FairAndSquare\\";
		String input = base + "input.in";
		String output = base + "output.out";

		try {
			Scanner sc = new Scanner(new FileReader(input));
			PrintWriter pw = new PrintWriter(output);

			int t = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < t; i++) {
				String[] line = sc.nextLine().split(" ");
				int startRange = Integer.parseInt(line[0]);
				int endRange = Integer.parseInt(line[1]);
				System.out.println(startRange + "  " + endRange);

				// System.out.println("Test case " + (c + 1) + "...");
				// pw.print("Case #" + (c + 1) + ": ");
				// test(sc, pw);
				// pw.println();
			}

			palindrome(1000);
			pw.println();
			pw.flush();
			pw.close();
			sc.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

	}

	private static void palindrome(int range) {
		int[] table = new int[range];
		int c = 0;
		for (int i = 0; i < 10; i++) {
			table[c++] = i;
		}
		for (int i = 11; i < 100; i += 11) {
			table[c++] = i;
		}
		int count = 2;
		int n = 100;
		for (int i = 101; i < range; i += 10) {
			if (i > n * count) {
				i = (n * count) + count;
				count++;
			}
			table[c++] = i;

		}
		int x = 10;
		int icount = 100;
		count = 2;
		n = 1000;
		for (int i = 1001; i < range; i += (icount + x)) {
//			if (n)
				if (i > n * count) {
					i = (n * count) + count;
					if (count == 10) {
						count = 2;
					} else {
						count++;
					}
				}
			table[c++] = i;
		}

		for (int i = 0; i < range; i++) {
			System.out.print(table[i] + " ");
		}

	}
}
