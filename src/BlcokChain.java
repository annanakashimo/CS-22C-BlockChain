import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

public class BlcokChain {
	public static void main(String[] args) {
		
		int id;
		String first, last, description, tempText;
		String[] tempTextArray;
		String tryAgain = "y";
		
		System.out.println("Welcome to Block Chain!\n");
		
		List<Block> TransactionList = new List<Block>();
		
		File file = new File("BlockChainTransactions.txt");
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			while((tempText = br.readLine()) != null) {
				id = Integer.parseInt(tempText);
				//System.out.println(id);
				
				tempText = br.readLine();
				tempTextArray = tempText.split(" ");
				first = tempTextArray[0];
				//System.out.println(tempTextArray[0]);
				last = tempTextArray[1];
				//System.out.println(tempTextArray[1]);

				tempText = br.readLine();
				description = tempText;
				//System.out.println(tempText);
				
				Block TransactionData = new Block(id, first, last, description);
				
				if(TransactionList.getLength() >= 1) {
					TransactionList.getLast().computeHash(id, first, last);
				} else {
					
				}
				
				TransactionList.addLast(TransactionData);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Total Number of Blocks: " + Block.getNumBlocks() + "\n");
		
		Scanner scan = new Scanner(System.in);

		while(tryAgain.equals("y")) {
			
			System.out.println("Would you like to add another transaction (y/n)?: ");
			tryAgain = scan.nextLine();
			
			switch(tryAgain) {
			case "y":
				System.out.println("Enter the transaction id: ");
				id = scan.nextInt();
				System.out.println("Enter the customer first and last name: ");
				first = scan.next();
				last = scan.next();
				scan.nextLine();
				System.out.println("Enter the transaction description: ");
				description = scan.nextLine();
				
				Block TransactionData = new Block(id, first, last, description);
				
				if(TransactionList.getLength() >= 1) {
					TransactionList.getLast().computeHash(id, first, last);
				} else {
					
				}
				TransactionList.addLast(TransactionData);
				
				System.out.println("\n" + "Total Number of Blocks: " + Block.getNumBlocks() + "\n");
				
			case "n":
				break;
				
			default:
				System.out.println("**Invalied Value - Try agin**");
			}
			
		}
		
		System.out.println("Total Number of Blocks: " + Block.getNumBlocks() + "\n");
		
		System.out.println("Enter the name of the output file: ");
		
		String outputFileName = scan.next();
		scan.close();

		try {
            // FileWriterクラスのオブジェクトを生成する
            FileWriter outputFile = new FileWriter(outputFileName);
            // PrintWriterクラスのオブジェクトを生成する
            PrintWriter pw = new PrintWriter(new BufferedWriter(outputFile));
            
            //ファイルに書き込む
            while(TransactionList.getLength() != 0) {
    			Block temp = TransactionList.getFirst();
    			
                pw.println(temp.toString());
    			
    			TransactionList.removeFirst();
    		}
            
            //ファイルを閉じる
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }	
	
		System.out.println("Goodbye!");

		
		
	}

}
