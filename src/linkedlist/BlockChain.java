
package linkedlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BlockChain {
	public static void processFile(List<Block> blocks) {
		int tempId = -1;
		String tempFirst = "", tempLast = "", tempDescription = "";
		
		FileReader file = null;
		
		try {
			file = new FileReader("transactions.txt");
		} catch (FileNotFoundException ex) {
			System.out.printf("Error -- %s\n", ex.toString());
			System.exit(1);
		}
		
		int i = 0;
		BufferedReader reader = new BufferedReader(file);
		String line;
		try {
			line = reader.readLine();
			while(line != null) {
				if (i == 3) {
					blocks.addLast(new Block(tempId, tempFirst, tempLast, tempDescription));
					i = 0;
				}
				
				switch (i) {
				case 0: tempId = Integer.parseInt(line);
						break;
				case 1: StringTokenizer tokens = new StringTokenizer(line);
						tempFirst = tokens.nextToken();
						tempLast = tokens.nextToken();
						break;
				case 2: tempDescription = line;
						break;
				default: break;
				
				}
				
				i++;
				line = reader.readLine();
			}
		} catch (IOException ex) {
			System.out.printf("Error -- %s\n", ex.toString());
			System.exit(1);
		}
		
		blocks.addLast(new Block(tempId, tempFirst, tempLast, tempDescription));
		
		try {
			reader.close();
        } 
		catch (IOException ex) {
			System.out.printf("Error -- %s\n", ex.toString());
			System.exit(1);
        }
	}
	
	public static void main (String [] arg) {
		List<Block> blocks = new List<>();
		processFile(blocks);
		
		Scanner user_parser = new Scanner(System.in);
		System.out.println("Welcome to Block Chain!\n");
		System.out.printf("Total Number of Blocks: %d\n\n", blocks.getLength());
		System.out.print("Would you like to add another transaction (y/n)?: ");
		
		String userAnswer = user_parser.nextLine();
		while (userAnswer.equals("y")) {
			int currentNumInput, tempId = -1;
			String currentInput, tempFirst = "", tempLast = "", tempDescription = "";
			
			System.out.print("Enter the transaction id: ");
			while (tempId < 0) {
				try {
					currentNumInput = Integer.parseInt(user_parser.nextLine());
					if (currentNumInput > -1) tempId = currentNumInput;
					else System.out.print("Please reenter the transaction id: ");
				} catch (NumberFormatException ex) {
					System.out.print("Please reenter the transaction id: ");
				}
			}
			
			System.out.print("Enter the customer first and last name: ");
			while (tempFirst.isEmpty() || tempLast.isEmpty()) {
				currentInput = user_parser.nextLine();
				StringTokenizer tokens = new StringTokenizer(currentInput);
				if (tokens.countTokens() == 2) {
					tempFirst = tokens.nextToken();
					tempLast = tokens.nextToken();
				} else {
					System.out.print("Please reenter the customer first and last name: ");
				}
			}
			
			System.out.print("Enter the transaction description: ");
			tempDescription = user_parser.nextLine();
			
			blocks.addLast(new Block(tempId, tempFirst, tempLast, tempDescription));
			
			System.out.printf("\nTotal Number of Blocks: %d\n\nWould you like to add another transaction (y/n)?: ", blocks.getLength());
			
			userAnswer = user_parser.nextLine();
		}
		
		System.out.printf("\nTotal Number of Blocks: %d\n\nEnter the name of the output file: ", blocks.getLength());
		String outputFileName = user_parser.nextLine();
		user_parser.close();
		
		FileWriter file = null;
		
		try {
			file = new FileWriter(outputFileName);
        } 
		catch (IOException ex) {
			System.out.printf("Error -- %s\n", ex.toString());
			System.exit(1);
        }
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(file));
		
		while (blocks.getLength() > 0) {
			writer.println(blocks.getFirst().toString());
			blocks.removeFirst();
		}
		
		writer.close();
		
		System.out.println("Goodbye!");
	}
}
