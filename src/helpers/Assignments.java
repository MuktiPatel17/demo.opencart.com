package helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignments {

	public Assignments() {
	}

	public static String randomString(String charSet, int lenght) {
		int charSetLenght = charSet.length();
		char[] output = new char[lenght];
		byte[] inputArray = charSet.getBytes();
		for (int i = 0; i < lenght; i++) {
			output[i] = (char) inputArray[(int) ((Math.random() * charSetLenght) % charSetLenght)];
		}
		return String.valueOf(output);
	}

	public static int charCount(String str, char c) {
		int count = 0;
		byte[] strByte = str.getBytes();
		for (int i = 0; i < strByte.length; i++) {
			char compareChar = (char) strByte[i];
			if (0 == Character.compare(Character.toLowerCase(compareChar), Character.toLowerCase(c))) {
				count++;
			}
		}
		return count;
	}

	public static int vowelCount(String str) {
		int count = 0;
		count += charCount(str, 'a');
		count += charCount(str, 'e');
		count += charCount(str, 'i');
		count += charCount(str, '0');
		count += charCount(str, 'u');

		return count;
	}

	public static int letterCount(String s) {
		String[] words = s.split(" ");
		int length = 0;
		for (String word : words) {
			// System.out.println(word);
			length += word.length();
		}
		return length;
	}

	public static String reverse(String s) {
		char[] inputArray = new char[s.length()];

		s.getChars(0, s.length(), inputArray, 0);
		for (int i = 0; i < s.length() / 2; i++) {
			char temp = inputArray[i];
			inputArray[i] = inputArray[s.length() - i - 1];
			inputArray[s.length() - i - 1] = temp;
		}
		return String.copyValueOf(inputArray);
	}

	public static boolean isValidEmail(String email) {
		Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$");
		Matcher m = emailPattern.matcher(email);
		if (m.find() && m.group().equals(email)) {
			return true;
		}
		return false;
	}

	public static boolean isValidPhone(String phone) {
		Pattern phonePattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$");
		Matcher m = phonePattern.matcher(phone);
		if (m.find() && m.group().equals(phone)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCount("Capgemini india a a a a"));
		System.out.println(reverse("Pushkar"));
		System.out.println(charCount("Sriparna bhattacharjee", 'S'));
		System.out.println(randomString(
				"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_-+=[]{}|;:/?>< \\", 30));
	}
}
