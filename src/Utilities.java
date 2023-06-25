/*
* Utilities class
*/

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utilities {

	// Ham tra ve string la 1 chuoi so
	public static String getKeyStringNumber(String strInput, Scanner sc) {
		// Goi ham kiem tra chuoi nhap vao co phai la so hay khong
		while (!isStringNumber(strInput)) {
			System.out.print("Please enter a number: ");
			strInput = sc.nextLine();
		}
		return strInput;
	}

	// Ham kiem tra input nhap vao co phai la so hay khong
	public static boolean isStringNumber(String strInput) {
		Pattern pattern = Pattern.compile("[0-9]+");
		return pattern.matcher(strInput).matches();
	}

	// Ham tra ve string la 1 chuoi ky tu
	public static String getKeyStringAlpha(String strInput, Scanner sc) {
		// Goi ham kiem tra chuoi nhap vao co phai la ki tu hay khong
		while (!isStringAlpha(strInput)) {
			System.out.print("Vui long nhap ky tu: ");
			strInput = sc.nextLine();
		}
		return strInput;
	}

	// Ham kiem tra input nhap vao co phai la chuoi ki tu hay khong
	public static boolean isStringAlpha(String strInput) {
		Pattern pattern = Pattern.compile("[a-z A-Z]+");
		return pattern.matcher(strInput).matches();
	}

	// Ham tra ve 1 so nhap vao la double
	public static double getDouble(Scanner sc) {
		while (true) {
			try {
				return sc.nextDouble();
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.print("Please enter a number: ");
			}
		}
	}

	// Ham tra ve phim chuc nang dung theo menu
	public static String getKeyValid(String keyInput, int[] numbers, Scanner sc) {
		boolean isInvalid = true;
		while (isInvalid) {
			for (int i = 0; i < numbers.length; i++) {
				if (Integer.parseInt(keyInput) == numbers[i]) {
					isInvalid = false;
				}
			}
			if (!isInvalid) {
				break;
			} else {
				System.out.print("Please enter right key menu: ");
				keyInput = getKeyStringNumber(sc.nextLine(), sc);
			}
		}
		return keyInput;
	}

}
