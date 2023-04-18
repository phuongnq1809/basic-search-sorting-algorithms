/*
* Main Class
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DBAAsm02 {

	private static Scanner sc = new Scanner(System.in);
	private static final int[] keyNumbersMainMenu = {0, 1, 2, 3, 4, 5, 6, 7};
	private static double[] inputArr;

	// Main Menu
	private static void showMainMenu() {
		System.out.println("+---------MENU--------+");
		System.out.println("| 1. Manual Input	  |");
		System.out.println("| 2. File Input		  |");
		System.out.println("| 3. Bubble sort	  |");
		System.out.println("| 4. Selection sort	  |");
		System.out.println("| 5. Insertion sort	  |");
		System.out.println("| 6. Search > value	  |");
		System.out.println("| 7. Search = value	  |");
		System.out.println("| 0. Exit			  |");
		System.out.println("+---------------------+");
	}

	// 1. Manual Input
	private static void manualInput() {
		System.out.println("Choice 1: Manual Input");
		System.out.print("Please enter input number of elements (n <= 20): ");
		int n = Integer.parseInt(Utilities.getKeyStringNumber(sc.nextLine(), sc)); // valid number input

		double[] numbers = new double[n];
		System.out.print("Please enter input elements: ");
		for (int i = 0; i < n; i++) {
			numbers[i] = Utilities.getDouble(sc); // valid double input
		}
		sc.nextLine();

		System.out.print("Input array: ");
		printArray(numbers);

		// Luu du lieu mang da nhap vao file 'INPUT.txt'
		TextFileService.writeFile("INPUT.txt", numbers);
		System.out.println("Input array has written to file 'INPUT.txt'");
	}

	// 2. File Input
	private static void fileInput() {
		System.out.println("Choice 2: File input");
		System.out.print("Please enter the file path: ");
		String filePath = sc.nextLine();

		// Valid the file path = "INPUT.txt"
		while (!filePath.equals("INPUT.txt")) {
			System.out.print("Please enter the valid file path: ");
			filePath = sc.nextLine();
		}

		// Read file, return an array
		inputArr = TextFileService.readFile(filePath);

		StringBuilder fileInput = new StringBuilder("");
		for (int i = 0; i < inputArr.length; i++) {
			fileInput.append(inputArr[i]).append(" ");
		}
		System.out.println("Input array: " + fileInput);

	}

	// Function to print an array
	private static void printArray(double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// 3. Bubble Sort
	private static void bubbleSort() {
		System.out.println("Choice 3: Bubble sort");
		if (inputArr != null) {

			// Luu du lieu tu mang da co trong file sang 1 mang moi de sap xep
			double[] arrToSort = Arrays.copyOf(inputArr, inputArr.length);
			int n = arrToSort.length;

			int i, j;
			double temp;
			boolean swapped;

			// Duyet mang va so sanh 2 phan tu canh nhau
			for (i = 0; i < n - 1; i++) {
				swapped = false;
				for (j = 0; j < n - i - 1; j++) {
					if (arrToSort[j] > arrToSort[j + 1]) {
						// neu phan tu truoc lon hon phan tu sau thi doi cho cho nhau
						temp = arrToSort[j];
						arrToSort[j] = arrToSort[j + 1];
						arrToSort[j + 1] = temp;
						swapped = true;
					}
					printArray(arrToSort); // goi ham in ra mang sau moi buoc
				}

				// Neu ko con 2 phan tu can doi cho, thoat khoi vong lap
				if (!swapped) {
					break;
				}

			}

			// In ket qua cua mang da sap xep (buoc cuoi cung) vao file OUTPUT1.txt
			TextFileService.writeFile("OUTPUT1.txt", arrToSort);
			System.out.println("The result has written to file 'OUTPUT1.txt'");

		} else {
			System.out.println("Please get data (input array) from file first!");
		}
	}

	// 4. Selection sort
	private static void selectionSort() {
		System.out.println("Choice 4: Selection sort");
		if (inputArr != null) {

			// Luu du lieu tu mang da co trong file sang 1 mang moi de sap xep
			double[] arrToSort = Arrays.copyOf(inputArr, inputArr.length);
			int n = arrToSort.length;

			// Duyet mang, bat dau tu vi tri dau tien
			for (int i = 0; i < n - 1; i++) {
				// Tim phan tu nho nhat trong mang chua duoc sap xep
				int min_index = i;

				for (int j = i + 1; j < n; j++) {
					if (arrToSort[j] < arrToSort[min_index]) {
						min_index = j;
					}
				}

				// Doi phan tu nho nhat voi phan tu o vi tri thu i
				double temp = arrToSort[min_index];
				arrToSort[min_index] = arrToSort[i];
				arrToSort[i] = temp;

				printArray(arrToSort); // in ra mang sau moi step

			}

			// In ket qua cua mang da sap xep (buoc cuoi cung) vao file OUTPUT2.txt
			TextFileService.writeFile("OUTPUT2.txt", arrToSort);
			System.out.println("The result has written to file 'OUTPUT2.txt'");

		} else {
			System.out.println("Please get data (input array) from file first!");
		}
	}

	// 5. Insertion sort
	private static void insertionSort() {
		System.out.println("Choice 5: Insertion sort");
		if (inputArr != null) {

			// Luu du lieu tu mang da co trong file sang 1 mang moi de sap xep
			double[] arrToSort = Arrays.copyOf(inputArr, inputArr.length);
			int n = arrToSort.length;

			// Duyet mang tu vi tri thu 2
			for (int i = 1; i < n; i++) {
				double key = arrToSort[i];
				int j = i - 1;

				//Di chuyen cac phan tu lon hon key den vi tri truoc vi tri hien tai cua chung
				//dam bao danh sach da duoc sap xep tang dan van giu nguyen tu phan tu dau tien
				//(chen phan tu vao vi tri thich hop)
				while (j >= 0 && arrToSort[j] > key) {
					arrToSort[j + 1] = arrToSort[j];
					j--;
				}

				arrToSort[j + 1] = key;
				printArray(arrToSort); // in mang sau moi step
			}

			// In ket qua cua mang da sap xep (buoc cuoi cung) vao file OUTPUT3.txt
			TextFileService.writeFile("OUTPUT3.txt", arrToSort);
			System.out.println("The result has written to file 'OUTPUT3.txt'");

		} else {
			System.out.println("Please get data (input array) from file first!");
		}
	}

	// 6. Linear search
	private static void linearSearch() {
		System.out.println("Choice 6: Linear Search");
		if (inputArr != null) {

			// Hien thi mang duoc lay tu file
			System.out.print("Input array: ");
			printArray(inputArr);

			// Luu du lieu tu mang da co trong file sang 1 mang moi de tim kiem
			double[] arrInput = Arrays.copyOf(inputArr, inputArr.length);
			int n = arrInput.length;

			System.out.print("Please enter searched input value: ");
			double searchNumber = Utilities.getDouble(sc);

			ArrayList<Integer> indexsFound = new ArrayList<>();

			// Duyet mang tuan tu, neu co phan tu lon hon input thi them index vao danh sach
			for (int i = 0; i < n; i++) {
				if (arrInput[i] > searchNumber) {
					indexsFound.add(i);
				}
			}

			if (!indexsFound.isEmpty()) { // Neu tim thay phan tu lon hon gia tri can tim kiem

				// Convert from ArrayList to array
				int[] results = new int[indexsFound.size()];
				for (int i = 0; i < indexsFound.size(); i++) {
					results[i] = indexsFound.get(i);
				}

				System.out.print("Larger position: ");
				for (int result : results) {
					System.out.print(result + " ");
				}
				System.out.println();

				// In ket qua tim kiem (vi tri phan tu lon hon) vao file OUTPUT4.txt
				TextFileService.writeFile("OUTPUT4.txt", results);
				System.out.println("The searched result has written to file 'OUTPUT4.txt'");

			} else {
				System.out.println(searchNumber + " is larger than elements in array.");
			}

			sc.nextLine();

		} else {
			System.out.println("Please get data (input array) from file first!");
		}

	}

	// 7. Bianary search algorithm
	private static int binarySearchAlgorithm(double[] arr, int l, int r, double value) {
		if (r >= l) {
			// Tinh gia tri index trung binh o khoang giua cua mang
			int mid = l + (r - l) / 2;

			// So sanh gia tri phan tu tai index trung binh voi gia tri tim kiem
			if (arr[mid] == value) { // neu bang, tra ve index trung binh
				return mid;
			}

			if (arr[mid] > value) { // neu lon hon, goi de quy de tim kiem voi nua mang ben trai
				return binarySearchAlgorithm(arr, l, mid - 1, value);
			}

			// Nguoc lai, goi de quy de tim kiem voi nua mang ben phai
			return binarySearchAlgorithm(arr, mid + 1, r, value);
		}

		// Neu khong tim thay, return -1
		return -1;
	}

	// 7. Binary search
	private static void binarySearch() {
		System.out.println("Choice 7: Binary Search");
		if (inputArr != null) {

			// Hien thi mang duoc lay tu file
			System.out.print("Input array: ");
			printArray(inputArr);

			// Luu du lieu tu mang da co trong file sang 1 mang moi de sap xep
			double[] arrToSort = Arrays.copyOf(inputArr, inputArr.length);
			int n = arrToSort.length;

			// Sap xep mang theo thu tu tang dan (thuat toan sap xep chon)
			for (int i = 0; i < n - 1; i++) {
				// Tim phan tu nho nhat trong mang chua duoc sap xep
				int min_index = i;
				for (int j = i + 1; j < n; j++) {
					if (arrToSort[j] < arrToSort[min_index]) {
						min_index = j;
					}
				}
				// Doi phan tu nho nhat voi phan tu o vi tri thu i
				double temp = arrToSort[min_index];
				arrToSort[min_index] = arrToSort[i];
				arrToSort[i] = temp;
			}

			// Hien thi mang da duoc sap xep theo thu tu tang dan
			System.out.print("Sorted array: ");
			printArray(arrToSort);

			System.out.print("Please enter searched input value: ");
			double value = Utilities.getDouble(sc);

			int result = binarySearchAlgorithm(arrToSort, 0, arrToSort.length - 1, value);

			if (result != -1) {
				System.out.print("The right position: " + result);
				System.out.println();
			} else {
				System.out.println("Element not present!");
			}
			sc.nextLine();

		} else {
			System.out.println("Please get data (input array) from file first!");
		}

	}

	public static void main(String[] args) {
		boolean isQuit = false;
		while (!isQuit) {
			showMainMenu();
			System.out.print("Please enter key menu: ");

			String keyMainInput = Utilities.getKeyStringNumber(sc.nextLine(), sc); // input number valid
			int keyMainValid = Integer.parseInt(Utilities.getKeyValid(keyMainInput, keyNumbersMainMenu, sc));

			if (keyMainValid != 0) {
				switch (keyMainValid) {
					case 1: // 1. Manual input
						manualInput();
						break;
					case 2: // 2. File input
						fileInput();
						break;
					case 3: // 3. Bubble sort
						bubbleSort();
						break;
					case 4: // 4. Selection sort
						selectionSort();
						break;
					case 5: // 5. Insertion sort
						insertionSort();
						break;
					case 6: // 6. Search > value
						linearSearch();
						break;
					case 7: // 7. Search = value
						binarySearch();
						break;
					default:
						break;
				}
			} else { // 0. Exit
				isQuit = true;
				System.out.println("Thanks!!!");
			}
		}
	}
}
