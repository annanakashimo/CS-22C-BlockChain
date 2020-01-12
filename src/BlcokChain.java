import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class BlcokChain {
	public static void main(String[] args) {
		
		int id;
		String first, last, description, temptext;
		String[] tempTextArray;
		
		System.out.println("Welcome to Block Chain!\n" + "\n");
		
		List<Block> TransactionList = new List<Block>();
		
		File file = new File("BlockChainTransactions.txt");
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			while((temptext = br.readLine()) != null) {
				id = Integer.parseInt(temptext);
				System.out.println(id);
				
				temptext = br.readLine();
				tempTextArray = temptext.split(" ");
				first = tempTextArray[0];
				System.out.println(tempTextArray[0]);
				last = tempTextArray[1];
				System.out.println(tempTextArray[1]);

				temptext = br.readLine();
				description = temptext;
				System.out.println(temptext);
				
				Block TransactionData = new Block(id, first, last, description);
				
				TransactionList.addLast(TransactionData);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Total Number of Blocks: " + TransactionList.getLength() + "\n");

		System.out.println("Would you like to add another transaction (y/n)?: ");

		
		
		
	}

}
