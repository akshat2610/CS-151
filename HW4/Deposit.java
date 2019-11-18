/**
 * Models a deposit class that implements runnable
 * @author Akshat Bansal
*/
public class Deposit implements Runnable{

  /**
   * Constructs an instance of the Deposit class
   * @param bankAccount bank account
   * @param amount amount to deposit
  */
  public Deposit(BankAccount bankAccount, int amount){
    this.bankAccount  = bankAccount;
    deposit = amount;
  }


  @Override
  public void run(){
    for(int i = 0; i <= NUM_TRANSACTIONS; i++){
      try{
        bankAccount.deposit(deposit);
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
  private int deposit;
}
