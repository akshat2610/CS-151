/**
 * Models a withdraw class that implements runnable
 * @author Akshat Bansal
*/
public class Withdraw implements Runnable{

  /**
   * Constructs an instance of the Withdraw class
   * @param bankAccount bank account
   * @param amount amount to withdraw
  */
  public Withdraw(BankAccount bankAccount, int amount){
    this.bankAccount = bankAccount;
    this.amount = amount;
  }

  @Override
  public void run(){
    for(int i = 0; i <= NUM_TRANSACTIONS; i++){
      try{
        bankAccount.withdraw(amount);
        Thread.sleep(SLEEP_TIME);
      }
      catch(InterruptedException e){
        e.printStackTrace();
      }
    }
  }
  private final static int SLEEP_TIME = 100;
  private final static int NUM_TRANSACTIONS = 10;
  private BankAccount bankAccount;
  private int amount;
}
