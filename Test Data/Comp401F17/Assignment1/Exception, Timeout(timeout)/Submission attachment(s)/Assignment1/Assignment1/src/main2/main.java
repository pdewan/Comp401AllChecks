package main2;

public class main {

	public static void main(final String[] args) {

	}

	public static void indexOf(String s, char ch, int n) {
		int index = 0;
		while (index < s.length()) {
			if (n < s.length() && s.charAt(n) == ch) {
				System.out.println(s.charAt(n));

			}
			index++;
		}
	}

	public static void indexOfNot(String s, char ch, int n) {
		int index = 0;
		while (index < s.length()) {
			if (n < s.length() && s.charAt(n) != ch) {
				System.out.println(s.charAt(n));

			}
			index++;
		}
	}

	private static void scanString(String input) {
		System.out.println("Upper Case Letters:");
		int index2 = 0;
		while (index2 < input.length()) {
			char nextLetter = input.charAt(index2);
			if (nextLetter >= 0 && nextLetter <= 9) {
				System.out.print(nextLetter);
			}
		}
		index2++;

	}

	private static void processInput() {

	}

}
