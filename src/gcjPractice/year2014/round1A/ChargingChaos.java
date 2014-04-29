package gcjPractice.year2014.round1A;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class ChargingChaos {

	public static void main(String[] args) {
		String base = "C:\\programs\\GCJ\\ChargingChaos\\";
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
			while (t-- > 0) {
				int n = sc.nextInt();
				int l = sc.nextInt();
				int outlet[] = new int[n];
				int device[] = new int[n];
				HashSet<Integer> set = new HashSet<Integer>();
				for (int i = 0; i < n; i++) {
					outlet[i] = Integer.parseInt(sc.nextInt() + "", 2);
				}
				for (int i = 0; i < n; i++) {
					device[i] = Integer.parseInt(sc.nextInt() + "", 2);
					set.add(device[i]);
				}

				int result = l + 1;
				for (int i = 0; i < n; i++) {
					int shift = outlet[0] ^ device[i];
					boolean flg = true;
					for (int j = 0; j < n; j++) {
						if (flg) {
							int value = outlet[j] ^ shift;
							if (!set.contains(value)) {
								flg = false;
								break;
							}
						}
					}
					if (flg) {
						result = Math.min(Integer.bitCount(shift), result);
					}
				}

				if (result != l + 1) {
					pw.println("Case #" + (count++) + ": " + result);
					System.out.println(result);
				} else {
					pw.println("Case #" + (count++) + ": " + "NOT POSSIBLE");
					System.out.println("NOT POSSIBLE");
				}

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
}
