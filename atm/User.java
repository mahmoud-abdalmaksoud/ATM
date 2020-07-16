
package atm;

import java.security.MessageDigest;
import java.util.ArrayList;


/**
 *
 * @author mahmoud
 */
public class User {
    private String firstName ;
    private String lastName ;
    private String uuid ;
    private byte pinHash[];
    private ArrayList<Account> accounts ;
   
    

public User (String firstName , String lastName , String pin , Bank theBank){
    this.firstName = firstName ;
    this.lastName = lastName ;
     
        try {
           MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());

        } catch (Exception e) {
            System.out.println("error , caught exception:"+ e.getMessage());
            System.exit(1);
        }
        this.uuid = theBank.getNewUserUUID();
        this.accounts = new ArrayList <Account> ();
        
        System.out.printf("New user %s, %s with ID %s created.\n", 
				lastName, firstName, this.uuid);

}



public boolean validatePin(String apin){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(apin.getBytes()), this.pinHash);
        } catch (Exception e) {
            System.out.println("error , no such algorithm found");
            System.exit(1);
        }
        
        return false ;

    
    
    
}

    String getUUID() {
            return this.uuid ;

    }

    public void addAccount(Account newAccount) {
        this.accounts.add(newAccount);
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    public void printAccountsSummary(){
       System.out.printf("\n\n%s's accounts summary\n", this.firstName);

        for (int a =0 ; a <this.accounts.size() ; a++){
            String line = this.accounts.get(a).getSummaryLine();
            System.out.println(line);
        }
    }
    public int numAccounts() {
		return this.accounts.size();
    }
    public double getAcctBalance(int acctIdx) {
		return this.accounts.get(acctIdx).getBalance();
	}
    public String getAcctUUID(int acctIdx) {
		return this.accounts.get(acctIdx).getUUID();
	}
    
    public void addAcctTransaction(int acctIdx, double amount, String memo) {
		this.accounts.get(acctIdx).addTransaction(amount, memo);
	}
    
    public void printAcctTransHistory(int acc){
        this.accounts.get(acc).showTransactions();
        
    }
	
    

   }