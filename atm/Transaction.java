/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.Date;

/**
 *
 * @author mahmoud
 */
public class Transaction {
    private double amount ;
    private Date timestamp ;
    private String memo ;
    private Account inAccount ;
    
    public Transaction(double amount , Account inAccount){
        this.amount = amount ;
        this.inAccount = inAccount ;
        this.timestamp = new Date();
        this.memo = "";
    }
   public Transaction(double amount, String memo, Account inAccount) {
		
		this(amount, inAccount);
		this.memo = memo;
		
	}
    
    public double getMoney(){
        return this.amount;
    }
    public void transactionInfo(){
        System.out.println(this.amount + " " +this.inAccount +  " " + this.memo + " "+ this.timestamp);
    }
    
}
