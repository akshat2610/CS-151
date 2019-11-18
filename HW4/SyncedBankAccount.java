/**
 * Models a synchronized bank account
 * @author Akshat Bansal
*/

public class SyncedBankAccount extends BankAccount{
  private int balance;
  /**
   * Constructs an instance of the bank account
  */
  public SyncedBankAccount(){
    balance = 0;
  } 

  /**
   * Constructs an instance of the SyncedBankAccount
   * @param bal initial balance
  */
  public SyncedBankAccount(int bal){
    balance = bal;
  }

  
  /**
   * Withdraws amount in sync with other threads
   * @param amount amount to withdraw
  */
  public synchronized void withdraw(int amount){
    balance = balance - amount;
    System.out.println("\nWithdrawing " + amount);
    System.out.println("Balance after withdrawal is " + balance);
  }

  /**
   * Deposits amount in sync with other threads
   * @param amount amount to deposit
  */
  public synchronized void deposit(int amount){
    balance = balance + amount;
    System.out.println("\nDepositing " + amount);
    System.out.println("Balance after deposit is " + balance);
  }
}
