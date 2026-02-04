package Task3;

import java.util.HashSet;
import java.util.Scanner;

public class HS {
    static void main() {
        Scanner sc = new Scanner(System.in);

        HashSet<Integer>studentIds=new HashSet<>();
        int n = sc.nextInt(); // to add n number of ids
        for (int i =0;i<n;i++){
            int id = sc.nextInt();

            boolean addId = studentIds.add(id);
            if (!addId){
                System.out.println("Duplicate id: "+id);
            }
        }
        System.out.println("Display all Id's :");

        if (studentIds.isEmpty()){
            System.out.println("not Id's found");
        }else {
            for (int Id : studentIds){
                System.out.println(" "+Id);
            }
        }

        System.out.println("Checking Ids :");
        int check = sc.nextInt();

        if (studentIds.contains(check)){
            System.out.println("Id already exists!");
        }else {
            System.out.println("New Id :"+check);
        }
    }
}
