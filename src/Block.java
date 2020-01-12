/**

 * Block.java

 * @author

 * @author

 * CIS 22C Lab 1

 */

public class Block implements Transaction{

    private int transactionId;

    private String firstName;

    private String lastName;

    private String description;

    private long timeStampMillis;

    private long hashNextBlock;

    private static int numBlocks = 0;

    

    /**

     * Constructor for a Block

     * @param id the transaction id

     * @param first the customer first name

     * @param last the customer last name

     * @param description the transaction description

     * Calls System's currentTimeMillis() method

     * to assign the timeStampMillis

     * Increases the numBlocks

     */

    public Block(int id, String first, String last, String transactionDescription) {
    	transactionId = id;
    	firstName = first;
    	lastName = last;
    	description = transactionDescription;
    	
    	timeStampMillis = System.currentTimeMillis();
    	hashNextBlock = 0;
        numBlocks++;
    }
    
    
    /**

     * Returns the transaction id

     * @return the id of the transaction

     */
    public int getTransactionId() {
    	return transactionId;
    }


    /**

     * Returns the customer's first name

     * @return the first name

     */

    public String getFirstName() {
    	return firstName;
    }


    /**

     * Returns the customer's last name

     * @return the last name

     */

    public String getLastName() {
    	return lastName;
    }


    /**

     * Returns the transaction description

     * @return the description

     */ 

    public String getDescription() {
    	return description;
    }


    /**

     * Returns the current number of blocks

     * @return the number of blocks

     */

    public static int getNumBlocks() {

        return numBlocks;

    }

    

    /**

     * Calculates the hash for the next

     * block

     * @param id the next block's id

     * @param firstName the customer first

     * name for the next block

     * @param lastName the customer last

     * name of the next block

     */

    public void computeHash(int id, String firstName, String lastName) {

        String name = firstName + lastName;

        int sum = 0;

        for (int i = 0; i < name.length(); i++) {

            sum += name.charAt(i);

        }

        hashNextBlock = sum * 10000 + id;

    }

    

    /**

    * toString for the Block class

    * @return a String of Block object

    *

    */

    @Override public String toString() {
    	String result = "";
    	
    	result += "ID: " + transactionId + "\n";
    	result += "Name: " + firstName + " " + lastName + "\n";
    	result += "Description: " + description + "\n";
    	result += "Time Stamp: " + timeStampMillis + "\n";
    	result += "Hash of Next Block: " + hashNextBlock + "\n";


        return result + "\n";

    }

    

}