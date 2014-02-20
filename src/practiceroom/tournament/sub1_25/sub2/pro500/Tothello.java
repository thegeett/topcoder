package practiceroom.tournament.sub1_25.sub2.pro500;

public class Tothello {

	private String[][] grid;
	private String[] emptypeices = new String[64];

	public int bestMove(String[] redPieces, String[] blackPeices, String whoseTurn) {
		grid = createGrid(redPieces, blackPeices);
		if (whoseTurn.equals("Red")) {
			whoseTurn = "R";
		} else {
			whoseTurn = "B";
		}
		solve(whoseTurn);
		return 0;
	}

	private void solve(String whoseTurn) {
		String find = whoseTurn.equals("R") ? "B" : "R";
		for (int i = 0; i < emptypeices.length; i++) {
			int a = Character.getNumericValue(emptypeices[i].charAt(0));
			int b = Character.getNumericValue(emptypeices[i].charAt(1));
			int x = a, y = b;

			if (++y > -1 && y < 8) {
				int count = 0;
				String con = grid[x][y];
				if (grid[x][y].equals(find)) {
					while (y < 8 && grid[x][y].equals(find)) {
						y++;
						count++;
					}
					if (grid[x][y].equals(whoseTurn)) {
						for (int j = a + 1; j < y; j++) {
							grid[x][j] = whoseTurn;
						}
					}
				}
			}
			printGrig(grid);
		}
	}

	public String[][] createGrid(String[] redPieces, String[] blackPeices) {
		String[][] g = new String[8][8];
		int c = 0;
		for (int r = 0; r < redPieces.length; r++) {
			String v = redPieces[r];
			System.out.println(v.charAt(0) - 'A');
			System.out.println(Character.getNumericValue(v.charAt(1)) - 1);
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
					System.out.println(i + "" + j + "   " + c);
					emptypeices[c++] = i + "" + j;
				}
			}
		}
		printGrig(g);
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
		String[] redPieces = { "D1" };
		String[] blackPieces = { "B1", "C1" };
		t.bestMove(redPieces, blackPieces, "Red");
	}
}
