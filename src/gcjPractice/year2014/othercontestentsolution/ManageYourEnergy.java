package gcjPractice.year2014.othercontestentsolution;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ManageYourEnergy {
	final static String WORK_DIR = "C:\\programs\\GCJ\\ManageYourEnergy_OtherContestent_Mystic\\";

	class Pair implements Comparable<Pair> {
		long value;
		int pos;

		public Pair(long value, int pos) {
			this.value = value;
			this.pos = pos;
		}

		public int compareTo(Pair other) {
			if (this.value < other.value)
				return 1;
			if (this.value > other.value)
				return -1;
			return 0;
		}
		
		@Override
		public String toString() {
			
			return "("+value+"  "+pos+")";
		}
	}

	void solve(Scanner sc, PrintWriter pw) {
		long E = sc.nextLong();
		long R = sc.nextLong();
		if (R > E)
			R = E;
		int N = sc.nextInt();
		long[] v = new long[N];
		Pair[] p = new Pair[N];
		for (int i = 0; i < N; i++) {
			v[i] = sc.nextLong();
			p[i] = new Pair(v[i], i);
		}
		boolean[] was = new boolean[N];
		long[] from = new long[N];
		long[] to = new long[N];
		Arrays.sort(p);
		long ans = 0;
		for (int i = 0; i < N; i++) {
			int pos = p[i].pos;
			from[pos] = E;
			for (int j = 0; j < pos; j++)
				if (was[j])
					from[pos] = Math.min(from[pos], to[j] + (pos - j) * R);
			to[pos] = 0;
			for (int j = pos + 1; j < N; j++)
				if (was[j])
					to[pos] = Math.max(to[pos], from[j] - (j - pos) * R);
			ans += (from[pos] - to[pos]) * p[i].value;
			was[pos] = true;
		}
		pw.println(ans);
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileReader(WORK_DIR + "input.in"));
		PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR + "output.in"));
		int caseCnt = sc.nextInt();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			pw.print("Case #" + (caseNum + 1) + ": ");
			new ManageYourEnergy().solve(sc, pw);
		}
		pw.flush();
		pw.close();
		sc.close();
	}
}
