package practiceroom.tournament.sub1_25.sub3.pro250;

import java.util.Arrays;
import java.util.List;

public class Checkers {

	public static void main(String[] args) {
		/*String startPos = "1,0";
		String[] pieces = { "2,1", "0,3", "4,3", "5,6", "4,2" };*/
		String startPos = "4,1";
		String[] pieces = { "2,4", "3,4", "4,4", "5,4", "2,6", "3,6", "4,6", "5,6" };
		int result = compute(startPos, pieces);
		System.out.println(result);
	}

	public static int compute(String startPos, String[] p) {
		int moveCount = 0;
		List<String> pieces = Arrays.asList(p);
		moveCount = compute(startPos, pieces, false);

		return moveCount;
	}

	private static int compute(String startPos, List<String> pieces, boolean b) {
		int moveCount = -1;
		int x = Integer.parseInt(startPos.split(",")[0]);
		int y = Integer.parseInt(startPos.split(",")[1]);
		if (x > 0 && y < 7) {
			String checkForBRight = (x + 1) + "," + (y + 1);
			String checkForBLeft = (x - 1) + "," + (y + 1);
			String checkForEmptyRight = (x + 2) + "," + (y + 2);
			String checkForEmptyLeft = (x - 2) + "," + (y + 2);

			if (x + 2 <= 7 && y + 2 <= 7 && pieces.contains(checkForBRight) && !pieces.contains(checkForEmptyRight)) {
				moveCount = 1;
				x = x + 2;
				y = y + 2;
				int count = compute(x + "," + y, pieces, true);
				if (b)
					count--;
				moveCount += count;
			} else if (x - 2 >= 0 && y + 2 <= 7 && pieces.contains(checkForBLeft) && !pieces.contains(checkForEmptyLeft)) {
				moveCount = 1;
				x = x - 2;
				y = y + 2;
				int count = compute(x + "," + y, pieces, true);
				if (b)
					count--;
				moveCount += count;
			} else if (x + 1 <= 7 && y + 1 <= 7 && !pieces.contains((x + 1) + "," + (y + 1))) {
				moveCount = 1;
				x = x + 1;
				y = y + 1;
				int count = compute(x + "," + y, pieces, false);
				moveCount += count;
			} else if (x - 1 >= 0 && y + 1 <= 7 && !pieces.contains((x - 1) + "," + (y + 1))) {
				moveCount = 1;
				x = x - 1;
				y = y + 1;
				int count = compute(x + "," + y, pieces, false);
				moveCount += count;
			}
		} else {
			moveCount = 0;
		}
		return moveCount;
	}
}
