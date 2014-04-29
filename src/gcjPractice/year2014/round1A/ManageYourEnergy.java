package gcjPractice.year2014.round1A;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ManageYourEnergy {
	public static void main(String[] args) {
		String base = "C:\\programs\\GCJ\\ManageYourEnergy\\";
		String input = base + "input.in";
		String output = base + "output.out";
		Scanner sc = null;
		PrintWriter pw = null;

		try {
			sc = new Scanner(new FileReader(input));
			pw = new PrintWriter(output);

			int t = sc.nextInt();
			sc.nextLine();
			int count = 1;
			while (sc.hasNextLine()) {
				String line[] = sc.nextLine().split(" ");
				int E = Integer.parseInt(line[0]);
				int R = Integer.parseInt(line[1]);
				int N = Integer.parseInt(line[2]);
				String v[] = sc.nextLine().split(" ");
				long totalGain = solve(E, R, N, v);
				pw.println("Case #" + (count++) + ": " + totalGain);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sc != null)
				sc.close();
			if (pw != null)
				pw.close();
		}
	}

	private static long solve(int e, int r, int n, String[] v) {
		int i = 0;
		int currE = e;
		long totalGain = 0;
		while (i < v.length - 1) {
			int next = Integer.parseInt(v[i + 1]);
			int curr = Integer.parseInt(v[i]);
			if (e == r) {
				totalGain += curr * currE;
			} else {
				int ge = decide(currE, r, curr, next);
				totalGain += curr * ge;
				currE = currE - ge + r;
				if (currE > e)
					currE = e;
			}
			i++;	
		}
		int curr = Integer.parseInt(v[i]);
		totalGain += curr * currE;
		System.out.println(totalGain);
		return totalGain;
	}

	private static int decide(int e, int r, int curr, int next) {
		int currE = 0;
		if (next > curr) {
			currE = e - ((e - r) == 0 ? 1 : e - r);
		} else {
			currE = e;
		}
		return currE;
	}
}
