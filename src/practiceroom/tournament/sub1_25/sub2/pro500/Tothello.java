package practiceroom.tournament.sub1_25.sub2.pro500;

public class Tothello {

	private String[][] grid;
	private String[][] mainGrid = new String[8][8];
	private String[] emptypeices = new String[64];

	public int bestMove(String[] redPieces, String[] blackPeices, String whoseTurn) {
		grid = createGrid(redPieces, blackPeices);
		printGrig(grid);
		mainGrid = grid.clone();
		// System.arraycopy(grid, 0, mainGrid, 0, grid.length);

		if (whoseTurn.equals("Red")) {
			whoseTurn = "R";
		} else {
			whoseTurn = "B";
		}
		int count = solve(redPieces, blackPeices, whoseTurn);
		// printGrig(grid);
		// printGrig(mainGrid);
		return count;
	}

	private int solve(String[] redPieces, String[] blackPeices, String whoseTurn) {
		String find = whoseTurn.equals("R") ? "B" : "R";
		int count = 0;
		String c = null;
		for (int i = 0; i < emptypeices.length; i++) {
			c = emptypeices[i];
			if (emptypeices[i] != null) {
				int a = Character.getNumericValue(emptypeices[i].charAt(0));
				int b = Character.getNumericValue(emptypeices[i].charAt(1));

				getCount(a, b, find, whoseTurn);
				int resultCount = 0;
				// printGrig(grid);
				String[] wt = findWhoseTurn(whoseTurn);
				for (String l : wt) {
					if (l != null) {
						getCount(Character.getNumericValue(l.charAt(0)), Character.getNumericValue(l.charAt(1)), find, whoseTurn);

					}
				}
				for (int k = 0; k < 8; k++) {
					for (int m = 0; m < 8; m++) {
						if (grid[k][m] == whoseTurn) {
							resultCount++;
						}
					}
				}

				resultCount++;
				// System.out.println(resultCount);
				if (resultCount > count) {
					count = resultCount;
				}

				grid = createGrid(redPieces, blackPeices);
				// System.out.println(c + " is  " + count);
				// printGrig(grid);
			}

		}
		return count;

	}

	public String[] findWhoseTurn(String whoseTurn) {
		String[] wt = new String[64];
		int c = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (grid[i][j] == whoseTurn) {
					wt[c++] = i + "" + j;
				}
			}
		}
		return wt;
	}

	private void getCount(int a, int b, String find, String whoseTurn) {
		int count = 0;
		int x = a, y = b;

		// right horizontal
		if (++y > -1 && y < 8) {
			String con = grid[x][y];
			if (grid[x][y].equals(find)) {
				int tempCount = 0;
				while (y < 8 && grid[x][y].equals(find)) {
					y++;
					tempCount++;
				}
				if (grid[x][y].equals(whoseTurn)) {
					tempCount++;
					for (int j = b + 1; j < y; j++) {
						grid[x][j] = whoseTurn;
					}
				}
				count += tempCount;
			}
		}
		// right diagonal bottom
		x = a;
		y = b;
		if (++x < 8 && ++y < 8) {
			String con = grid[x][y];
			if (grid[x][y].equals(find)) {
				int tempCount = 0;
				while (x < 8 && y < 8 && grid[x][y].equals(find)) {
					y++;
					x++;
					tempCount++;
				}
				if (grid[x][y].equals(whoseTurn)) {
					tempCount++;
					for (int j = a + 1, k = b + 1; j < x && k < y; j++, k++) {
						grid[j][k] = whoseTurn;
					}
				}
				count += tempCount;
			}
		}

		// straight bottom
		x = a;
		y = b;
		if (++x < 8) {
			if (grid[x][y].equals(find)) {
				int tempCount = 0;
				while (x < 8 && grid[x][y].equals(find)) {
					x++;
					tempCount++;
				}
				if (grid[x][y].equals(whoseTurn)) {
					tempCount++;
					for (int j = a + 1; j < x; j++) {
						grid[j][y] = whoseTurn;
					}
				}
				count += tempCount;
			}
		}
		// left diagonal bottom
		x = a;
		y = b;
		if (++x < 8 && --y > -1) {
			String con = grid[x][y];
			if (grid[x][y].equals(find)) {
				int tempCount = 0;
				while (x < 8 && y > -1 && grid[x][y].equals(find)) {
					y--;
					x++;
					tempCount++;
				}
				if (grid[x][y].equals(whoseTurn)) {
					tempCount++;
					for (int j = a + 1, k = b - 1; j < x && k > y; j++, k--) {
						grid[j][k] = whoseTurn;
					}
				}
				count += tempCount;
			}
		}
		// left Horizontal
		x = a;
		y = b;
		if (--y > -1) {
			String con = grid[x][y];
			if (grid[x][y].equals(find)) {
				int tempCount = 0;
				while (y > -1 && grid[x][y].equals(find)) {
					y--;
					tempCount++;
				}
				if (grid[x][y].equals(whoseTurn)) {
					tempCount++;
					for (int j = b - 1; j > y; j--) {
						grid[x][j] = whoseTurn;
					}
				}
				count += tempCount;
			}
		}
		// left diagonal top
		x = a;
		y = b;
		if (--x > -1 && --y > -1) {
			String con = grid[x][y];
			if (grid[x][y].equals(find)) {
				int tempCount = 0;
				while (x > -1 && y > -1 && grid[x][y].equals(find)) {
					y--;
					x--;
					tempCount++;
				}
				if (grid[x][y].equals(whoseTurn)) {
					tempCount++;
					for (int j = a - 1, k = b - 1; j > x && k > y; j--, k--) {
						grid[j][k] = whoseTurn;
					}
				}
				count += tempCount;
			}
		}
		// straight top
		x = a;
		y = b;
		if (--x > -1) {
			if (grid[x][y].equals(find)) {
				int tempCount = 0;
				while (x > -1 && grid[x][y].equals(find)) {
					x--;
					tempCount++;
				}
				if (grid[x][y].equals(whoseTurn)) {
					tempCount++;
					for (int j = a - 1; j > x; j--) {
						grid[j][y] = whoseTurn;
					}
				}
				count += tempCount;
			}
		}
		// right diagonal top
		x = a;
		y = b;
		if (--x > -1 && ++y < 8) {
			String con = grid[x][y];
			if (grid[x][y].equals(find)) {
				int tempCount = 0;
				while (x > -1 && y < 8 && grid[x][y].equals(find)) {
					y++;
					x--;
					tempCount++;
				}
				if (grid[x][y].equals(whoseTurn)) {
					tempCount++;
					for (int j = a - 1, k = b + 1; j > x && k < y; j--, k++) {
						grid[j][k] = whoseTurn;
					}
				}
				count += tempCount;
			}
		}
		// printGrig(grid);
		// return count;
	}

	public String[][] createGrid(String[] redPieces, String[] blackPeices) {
		String[][] g = new String[8][8];
		int c = 0;
		for (int r = 0; r < redPieces.length; r++) {
			String v = redPieces[r];
			g[Character.getNumericValue(v.charAt(1)) - 1][(v.charAt(0) - 'A')] = "R";
		}
		for (int b = 0; b < blackPeices.length; b++) {
			String v = blackPeices[b];
			g[Character.getNumericValue(v.charAt(1)) - 1][(v.charAt(0) - 'A')] = "B";
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (g[i][j] == null) {
					g[i][j] = "-";
					emptypeices[c++] = i + "" + j;
				}
			}
		}
		// printGrig(g);
		return g;
	}

	public void printGrig(String[][] g) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(g[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("=====================");
	}

	public static void main(String[] args) {
		Tothello t = new Tothello();
		// C2,C3,C4,C5,D4,E4,F2,F3,F4,F5,G6
		// B1,E1,G1,C6,H7,G4
		// String[] redPieces = { "D1", "D4", "A7" };
		// String[] blackPieces = { "B1", "C1", "B2", "C3", "B6" };
		/*String[] redPieces = { "C2", "C3", "C4", "C5", "D4", "E4", "F2", "F3", "F4", "F5", "G6" };
		String[] blackPieces = { "B1", "E1", "G1", "C6", "H7", "G4" };
		t.bestMove(redPieces, blackPieces, "Black");*/
		String[] redPieces = { "A1", "B8", "C6", "C8", "D8" };
		String[] blackPieces = { "B2", "C2", "C3", "C4", "C5" };
		int count = t.bestMove(redPieces, blackPieces, "Red");
		System.out.println(count);
	}
}
