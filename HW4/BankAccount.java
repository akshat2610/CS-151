/**
 * Models a bank account class
 * @author Akshat Bansal
*/

public class BankAccount{

  /**
   * Constructs an instance of the bank account
  */
  public BankAccount(){
    balance = 0;
  } 

  /**
   * Constructs an instance of the bank account with the given balance
   * @param bal balance
  */
  public BankAccount(int bal){
    balance = bal;
  }

  /**
   * Withdraws amount from the bank account
   * @param amount amount to be withdrawn
  */
  public void withdraw(int amount){
    balance = balance - amount;
    System.out.println("\nWithdrawing " + amount);
    System.out.println("Balance after withdrawal is " + balance);
  }

  /**
   * Deposits amount to the bank amount
   * @param amount amount to deposit
  */
  public void deposit(int amount){
    balance = balance + amount;
    System.out.println("\nDepositing " + amount);
    System.out.println("Balance after deposit is " + balance);
  }
  
  private int balance;
}
