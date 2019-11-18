public class hw4{

  public static void main(String[] args){
    BankAccount bankAccount1  = new BankAccount(0);
    SyncedBankAccount bankAccount2 = new SyncedBankAccount(0);

    Withdraw withdrawRunnable1 = new Withdraw(bankAccount1, 1);
    Deposit depositRunnable1 = new Deposit(bankAccount1, 1);
    Thread t1 = new Thread(withdrawRunnable1);
    Thread t2 = new Thread(depositRunnable1);

    Withdraw withdrawRunnable2 = new Withdraw(bankAccount2 , 1);
    Deposit depositRunnable2 = new Deposit(bankAccount2 , 1);
    Thread t3 = new Thread(withdrawRunnable2);
    Thread t4 = new Thread(depositRunnable2);

    System.out.println("\nUnsynchronized: ");
    t1.start();
    t2.start();
    try{
      t1.join();
    }
    catch(InterruptedException e){
      e.printStackTrace();
    }
    try{
      t2.join();
    }
    catch(InterruptedException e){
      e.printStackTrace();
    }


    System.out.println("\nSynchronized: ");
    t3.start();
    t4.start();
    try{
      t3.join();
    }
    catch(InterruptedException e){
      e.printStackTrace();
    }
    try{
      t4.join();
    }
    catch(InterruptedException e){
      e.printStackTrace();
    }
  }
}
