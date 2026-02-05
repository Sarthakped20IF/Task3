package Task3;

import static java.lang.Character.getName;

class Myrunnable implements Runnable{
    private String taskName ;

    Myrunnable(String taskName){
        this.taskName=taskName;
    }

//    Thread.currentThread().getName() this give the name of current running thread
    public void run (){
        System.out.println(taskName+"Started by "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(taskName+"Completed by "+Thread.currentThread().getName());
    }
}

public class Waitthread {
    static void main() throws InterruptedException {
        Thread t1 = new Thread(new Myrunnable("Task1"),"t1");
        Thread t2 = new Thread(new Myrunnable("Task2"),"t2");

        t1.start(); // starts t1 thread
        t1.join(); // tells threads to wait until t1 is ccompleted
        t2.start();// t2 start only after t1 is completed


    }

}
