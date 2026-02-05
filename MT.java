package Task3;

public class MT  {
    static void main() {

        System.out.println("Print message using multiple threads");
        Thread t1 = new Thread(()->{
            System.out.println("This is t1 thread");
        });
        Thread t2 = new Thread(()->{
            System.out.println("This is t2 thread");
        });

        t1.start();
        t2.start();
    }
}
