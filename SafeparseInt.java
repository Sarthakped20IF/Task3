package Task3;

public class SafeparseInt {
    static void main() {
        String s = "123";
        String r = "123e";
        parseInt(s);
        parseInt(r);
    }
    static Integer parseInt (String s){
        try {
            return Integer.parseInt(s);
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }return null;
    }
}
