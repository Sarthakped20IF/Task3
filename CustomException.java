package Task3;

class CustomException extends Exception {
    public CustomException (String msg){
        super(msg);
    }

    public class custException {
        static void main() {
            try {
                checkElegibilty(12);
                System.out.println("eligible to vote");
            }catch (CustomException e){
                System.out.println(e.getMessage());
            }
        }
    }
    static void checkElegibilty (int age)throws CustomException{
        if (age<18){
            throw new CustomException("You are not eligible to vote !"+age);
        }
    }
}
