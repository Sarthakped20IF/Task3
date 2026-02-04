package Task3;

public class Excephandling {
    public static void main() {

    }
    public static void Handleindexexpect(){
        int [] arr = {10,20,30};
        try {
            System.out.println("accessing index 5"+arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
