import java.util.*;

public class JavaNumberPuzzle {

	public static int s1, s2, s3, s4, s5, s6, s7, s8;
	public static int p1, p2, p3, p4, p5, p6, p7, p8, p9;
	public static int combFound;
	public static int[][] comb = new int[3][3];
	public static long startTime, endTime;

	public static void main(String[] args) {

		startTime = System.currentTimeMillis();

		String str = "123456789";
		ArrayList<String> arrayList = new ArrayList<String>();
		getUniqList(str, 0, str.length() - 1, arrayList);

		for (int i = 0; i < arrayList.size(); i++) {

			arrangeMatrix(arrayList.get(i));
			combFound = validateMatrix();

			if (combFound == 0) {
				break;
			}

		}

		endTime = System.currentTimeMillis();
		System.out.println("\nTotal TIme: " + ((endTime - startTime) / 1000) + " Seconds");

	}

	public static void getUniqList(String s, int a, int b, ArrayList arrayList) {

		if (a == b) {
			arrayList.add(s);
		}

		for (int i = a; i <= b; i++) {
			String newString = swap(s, a, i);
			getUniqList(newString, a + 1, b, arrayList);
		}
	}

	public static String swap(String s, int a, int b) {

		char[] charArray = s.toCharArray();
		char temp;

		temp = charArray[a];
		charArray[a] = charArray[b];
		charArray[b] = temp;

		return String.valueOf(charArray);
	}

	public static int validateMatrix() {

		s1 = comb[0][0] + comb[0][1] + comb[0][2];
		s2 = comb[1][0] + comb[1][1] + comb[1][2];
		s3 = comb[2][0] + comb[2][1] + comb[2][2];

		s4 = comb[0][0] + comb[1][0] + comb[2][0];
		s5 = comb[0][1] + comb[1][1] + comb[2][1];
		s6 = comb[0][2] + comb[1][2] + comb[2][2];

		s7 = comb[0][0] + comb[1][1] + comb[2][2];
		s8 = comb[0][2] + comb[1][1] + comb[2][0];

		if (s1 == 15 && s2 == 15 && s3 == 15 && s4 == 15 && s5 == 15 && s6 == 15 && s7 == 15 && s8 == 15) {
			System.out.println("Combination Found:\n");

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(comb[i][j]);
				}
				System.out.println("");
			}
			return 0;
		}

		return 1;
	}

	public static void arrangeMatrix(String str) {

		p1 = Integer.parseInt(str.substring(0, 1));
		p2 = Integer.parseInt(str.substring(1, 2));
		p3 = Integer.parseInt(str.substring(2, 3));
		p4 = Integer.parseInt(str.substring(3, 4));
		p5 = Integer.parseInt(str.substring(4, 5));
		p6 = Integer.parseInt(str.substring(5, 6));
		p7 = Integer.parseInt(str.substring(6, 7));
		p8 = Integer.parseInt(str.substring(7, 8));
		p9 = Integer.parseInt(str.substring(8, 9));

		comb[0][0] = p1;
		comb[0][1] = p2;
		comb[0][2] = p3;
		comb[1][0] = p4;
		comb[1][1] = p5;
		comb[1][2] = p6;
		comb[2][0] = p7;
		comb[2][1] = p8;
		comb[2][2] = p9;

	}

}
