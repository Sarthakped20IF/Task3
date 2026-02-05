package Task3;

class Myrunthreads implements Runnable{
    @Override
    public void run() {
//        took refernce to print the name of the threads
        System.out.println(Thread.currentThread().getName()+"Thread is running");
    }
}
public class Runthreads {
    static void main() {
        Runnable processes = new Myrunthreads();
        Thread t1 = new Thread(processes,"T1");
        Thread t2 = new Thread(processes,"T2");
        Thread t3 = new Thread(processes,"T3");

        t2.start();
        t1.start();
        t3.start();
    }
}

