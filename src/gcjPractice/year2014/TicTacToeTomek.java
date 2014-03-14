package gcjPractice.year2014;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TicTacToeTomek {

	private static int[][] h = { { 0, 1, 2, 3 }, { 4, 5, 6, 7 }, { 8, 9, 10, 11 }, { 12, 13, 14, 15 }, { 0, 4, 8, 12 }, { 1, 5, 9, 13 }, { 2, 6, 10, 14 },
			{ 3, 7, 11, 15 }, { 0, 5, 10, 15 }, { 3, 6, 9, 12 } };

	private static int xwon1 = 'X' + 'X' + 'X' + 'X';
	private static int xwon2 = 'T' + 'X' + 'X' + 'X';
	private static int owon1 = 'O' + 'O' + 'O' + 'O';
	private static int owon2 = 'T' + 'O' + 'O' + 'O';

	public static void main(String[] args) {
		String basePath = "C:\\programs\\GCJ\\TicTacToeTomek\\";
		int i = 1;

		try {
			Scanner sc = new Scanner(new File(basePath + "A-large-practice.in"));
			BufferedWriter writer = new BufferedWriter(new FileWriter(basePath + "output.txt"));
			int t = sc.nextInt();
			sc.nextLine();
			String data = "";
			int l = 1;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				data += line;
				if (l == 4) {
					String result = solve(data);
					writer.write("Case #" + i++ + ": " + result);
					writer.newLine();
					data = "";
					l = 0;
				} else {
					l++;
				}

			}
			sc.close();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String solve(String data) {
		int[] game = new int[16];
		boolean complete = true;
		int i = 0;
		for (int c : data.toCharArray()) {
			if (c == '.') {
				complete = false;
			}
			game[i++] = c;
		}

		for (int[] d : h) {
			int count = game[d[0]] + game[d[1]] + game[d[2]] + game[d[3]];
			if (count == xwon1 || count == xwon2) {
				return "X won";
			}
			if (count == owon1 || count == owon2) {
				return "O won";
			}

		}

		if (!complete) {
			return "Game has not completed";
		} else {
			return "Draw";
		}
	}
}
