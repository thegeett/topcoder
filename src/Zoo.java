import java.util.Arrays;

public class Zoo {

	public long theCount(int[] answers) {
		final int length = answers.length;

		Arrays.sort(answers);
		int i = 0;
		int count = 0;
		while (i + 1 < length && answers[i] == count && answers[i + 1] == count) {
			count++;
			i += 2;
		}

		final int countFirst = count;
		while (i < length && answers[i] == count) {
			i++;
			count++;
		}
		if (i != length)
			return 0;
		long result = 1 << countFirst;
		if (countFirst != count)
			result <<= 1;
		return result;

	}

	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		int a[] = { 0, 1, 2, 3, 4 };
		System.out.println(zoo.theCount(a));
	}

}
