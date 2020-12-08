package exercise;

import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author JULIO CESAR OLIVA_HERRERA 11/07/2020
 * 
 * This code will calculate the Average of amount of numbers between 1 and 20.
 * The code too will create a file 'testout.txt' and will write some Data.
 * The code too will show or read the content of the file in the scream.
 * But the code will open that created file to user too.
 */

public class Ex2_Julio_Exam_Practical_Ex {

	public static void main(String[] args) {
		System.out.println("TENTAM.#1, This is JULIO CESAR's Pratical Exam example:\n");
		
		boolean running = true;
		double average = 0;
		String filePath = "C:\\Users\\julio\\Documents\\JULIO_INFO"
				+ "\\A_WRITE_AND_READ_FILES_EX_PATH\\testout2.txt";
		
		Scanner input = new Scanner(System.in);
		
		clearMemory(filePath);
		
		while (running) {
			double[] numbers;
			numbers = numbersFromUser(input);
			average = calculateAverage(numbers);
			
			saveResult(average, filePath, numbers);
			showResultInConsole(filePath);
			openCreatedFile(filePath);
			System.out.println("The Average of the numbers is:" + average);
			
			System.out.println("Enter 0 if you want to finish, otheraway enter any number to continue");
			if (input.nextInt() == 0) {
				running = false;
			}
			
		}
		
		System.out.println("Good bye!");
		input.close();
		
	}
	
	/**
	 * Use Desktop class to open the created file 'testout.txt'
	 * @param filePath
	 */
	private static void openCreatedFile(String filePath) {
		
		try {
			
				File fil = new File(filePath);
				
				if (!Desktop.isDesktopSupported()) {
					
					System.out.println("Not supported");
					
					return;
					
				}
				
				Desktop desktop = Desktop.getDesktop();
				
				if (fil.exists())
					
					desktop.open(fil);
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		System.out.println("Now your will see the created file 'testout2.txt'\n\n");
		
	}
	/**
	 * Show the content of 'testout2.txt' file in the Console with help of FileReader method
	 * @param filePath
	 */
	private static void showResultInConsole(String filePath) {
		
		try {
			
				FileReader fr = new FileReader(filePath);
				
				int i;
				System.out.println("DATA IN THE FILE IS: ");
				System.out.println("====================\n\n" + "====================");
				while ((i = fr.read()) != -1)
				System.out.print((char)i);
			    
				fr.close();
				
		}
		
		catch (Exception e) {
			e.fillInStackTrace();
			
		}
		
		System.out.println("====================" + "\nEND OF THE FILE 'testout2.txt'\n\n");
				
	}

	/**
	 * Save the results of average, filePath and numbers in the created file 'testout2.txt'
	 * @param average
	 * @param filePath
	 * @param numbers
	 */
	
	private static void saveResult(double average, String filePath, double[] numbers) {
		
		try {
			
				FileWriter fw = new FileWriter(filePath);
				
				for (double number : numbers) {
					fw.write(number + "\n");
				}
				
				fw.write("Average is: " + average + "\n\n");
				fw.close();
				
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}

	/**
	 * Calculate Average from numbers
	 * @param numbers
	 * @return
	 */
	private static double calculateAverage(double[] numbers) {
		
		double average = 0.0;
		double total = 0;
		int amount = numbers.length;
		
		for (double number : numbers) {			
			total += number;			
		}
		
		average = total / amount;
		
		return average;
	}

	/**
	 * Uses the scanner to get numbers from the user.
	 * 
	 * @param input predefined source from which the user can enter numbers.
	 * @return an array containing the numbers.
	 */
	private static double[] numbersFromUser(Scanner input) {
		
		boolean tryingToGetInput = true;
		int amount = 0;
		
		while (tryingToGetInput) {
			
			System.out.println("How many are the numbers? (1-20): ");
			
			try {
				
					amount = input.nextInt();
				
			} catch (InputMismatchException e) {
				System.err.println("Only Integers, please!: ");
				input.nextLine();
				continue;
			}
			
			if (amount < 0 || amount > 20) {
				System.out.println("Wrong Integer, try again please!: ");
				continue;
			}
			
			tryingToGetInput = false;
			
		}
		
		double[] numbers = new double[amount];
		tryingToGetInput = true;
		
		while (tryingToGetInput) {
			System.out.println("Enter the number, press the entering bottom after please!: ");
			for (int i = 0; i < numbers.length; i++) {
				try {
						numbers[i] = input.nextDouble();
				} catch (InputMismatchException e) {
					System.err.println("Just numbers please!: ");
					input.nextLine();
					i--;
					continue;
				}
			}
			
			tryingToGetInput = false;
			
		}
		
		return numbers;
	}

	/**
	 * Clear the file 'testout2.txt'
	 * @param filePath
	 */

	private static void clearMemory(String filePath) {
		// Creates FileWriter method
		try {
			
			FileWriter fw = new FileWriter(filePath);
			fw.write("");
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
