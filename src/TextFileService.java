/*
* Text File Service Class
*/
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileService {
	private static final String SPACE_DELIMITER = " ";

	public static void writeFile(String fileName, double[] numbers) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
			for (int i = 0; i < numbers.length; i++) {
				bufferedWriter.write(numbers[i] + " ");
			}
			bufferedWriter.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writeFile(String fileName, int[] numbers) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
			for (int i = 0; i < numbers.length; i++) {
				bufferedWriter.write(numbers[i] + " ");
			}
			bufferedWriter.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static double[] readFile(String fileName) {
		List<Double> numbersFile = new ArrayList<>();

		try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
			String input;
			while ((input = file.readLine()) != null) {
				String[] datas = input.split(SPACE_DELIMITER);
				for (String data : datas) {
					numbersFile.add(Double.parseDouble(data));
				}
			}
		} catch (IOException io) {
			io.printStackTrace();
		}

		double[] numbers = new double[numbersFile.size()];
		for (int i = 0; i < numbersFile.size(); i++) {
			numbers[i] = numbersFile.get(i);
		}
		return numbers;

//		try {
//			FileReader fileReader = new FileReader(fileName);
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			int row = 0;
//			String line = "";
//			// Nhap du lieu cho mang tu noi dung cua file (theo tung dong)
//			while ((line = bufferedReader.readLine()) != null) {
//				if (arrayCol == 2) {
//					arrData[row][0] = line.substring(0, 3);
//					arrData[row][1] = line.substring(4);
//				} else if (arrayCol == 3) {
//					arrData[row][0] = line.substring(0, 2);
//					arrData[row][1] = line.substring(3, 4);
//					arrData[row][2] = line.substring(5);
//				}
//				row++;
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("Loi: Khong tim thay file.");
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

	// Kiem tra xem file co ton tai hay khong
	public static boolean isFileExisted(String fileName) {
		File f = new File(fileName);
		if (f.exists()) {
			return true;
		} else {
			return false;
		}
	}
}


