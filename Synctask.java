package Task3;
class BankAccount {
    private double balance = 2000.0; // minimun balance to check the sync report / result

    public synchronized void deposite (double amount){
        balance += amount;
    }

    public synchronized void withDraw(double amount){
        if (balance<amount){
            System.out.println("Insufficient Balance");
        }else {
            balance -= amount;
        }
    }
    public synchronized double getBalance(){
        return balance;
    }
}
public class Synctask {
    static void main() throws InterruptedException {
        BankAccount acc1 = new BankAccount();

        Thread depositer = new Thread(()->{
            for (int i =1;i<=1000;i++){
                acc1.deposite(i); // adding money in the account using thread depositer
            }
        });

        Thread withdrawer = new Thread(()->{
            for (int i =1 ; i<=1000 ; i++){
                acc1.withDraw(i);// this withdraws money
            }
        });

        depositer.start();
        withdrawer.start();

        depositer.join();
        withdrawer.join();
//        Note : to use join() method in threads we must need to throw InterruptedExpection in main class or in the class we are using that method

        System.out.println(acc1.getBalance());// this must return the minimum or the pre-defined balance i.e 2000.0
//        to check the difference we can run the loop for different values or else add different value while calling the methods
    }
}
