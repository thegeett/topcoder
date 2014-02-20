package practiceroom.tournament.sub1_25.sub2.pro500;

public class Tothello {

	private String[][] grid;
	private String[] emptypeices = new String[64];

	public int bestMove(String[] redPieces, String[] blackPeices, String whoseTurn) {
		grid = createGrid(redPieces, blackPeices);

		return 0;
	}

	public String[][] createGrid(String[] redPieces, String[] blackPeices) {
		String[][] g = new String[8][8];
		int c = 0;
		for (int r = 0; r < redPieces.length; r++) {
			String v = redPieces[r];
			System.out.println(v.charAt(0) - 'A');
			System.out.println(Character.getNumericValue(v.charAt(1)) - 1);
			g[(v.charAt(0) - 'A')][Character.getNumericValue(v.charAt(1)) - 1] = "R";
		}
		for (int b = 0; b < blackPeices.length; b++) {
			String v = blackPeices[b];
			g[(v.charAt(0) - 'A')][Character.getNumericValue(v.charAt(1)) - 1] = "B";
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (g[i][j] == null) {
					System.out.println(i + "" + j + "   " + c);
					emptypeices[c++] = i + "" + j;
				}
			}
		}
		return g;
	}

	public static void main(String[] args) {
		Tothello t = new Tothello();
		String[] redPieces = { "A1" };
		String[] blackPieces = { "C1" };
		t.bestMove(redPieces, blackPieces, "R");
	}
}
