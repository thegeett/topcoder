package gcjPractice.year2014;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*LOGIC
 * ============
 * iterate each element we call it spot
 * 
 * Find Max number from that ith row where the spot is. if that max number is greater than 
 * spot value than it is not possible in that row 
 * 
 *  do same thing for jth column too
 *  
 *  if both are not possible than answer is NO , if at least one is possible then answer 
 *  is YES 
 * 
 * */


public class Lawnmower {
	static String basePath = "C:\\programs\\GCJ\\Lawnmower\\";

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File(basePath + "B-large-practice.in"));
			int t = sc.nextInt();
			sc.nextLine();
			int[][] grid;
			int n = 0, m = 0;
			int testCase = 1;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] nm = separateBySpace(line);
				n = Integer.parseInt(nm[0]);
				m = Integer.parseInt(nm[1]);
				grid = new int[n][m];
				for (int i = 0; i < n; i++) {
					String[] nmLine = separateBySpace(sc.nextLine());
					for (int j = 0; j < m; j++) {
						grid[i][j] = Integer.parseInt(nmLine[j]);
					}
				}
				String result = solve(grid, n, m);

				System.out.println("Case #" + testCase++ + ": " + result);

				/*for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						System.out.print(grid[i][j]);
					}
					System.out.println();
				}
				System.out.println("###########");*/
			}

			sc.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String solve(int[][] grid, int n, int m) {
		boolean rowFlag = true;
		boolean colFlag = true;
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {
				int spot = grid[i][j];
				int max = grid[i][j];

				for (int x = 0; x < m; x++) {
					if (grid[i][x] > max) {
						max = grid[i][x];
					}
				}
				if (max > spot) {
					rowFlag = false;
				}

				max = grid[i][j];
				for (int x = 0; x < n; x++) {
					if (grid[x][j] > max) {
						max = grid[x][j];
					}
				}
				if (max > spot) {
					colFlag = false;
				}

				if (!rowFlag && !colFlag) {
					break;
				} else {
					rowFlag = true;
					colFlag = true;
				}
			}
			if (!rowFlag && !colFlag) {
				return "NO";
			}
		}
		return "YES";
	}

	private static String[] separateBySpace(String line) {
		String[] s = line.split(" ");
		return s;
	}

}
