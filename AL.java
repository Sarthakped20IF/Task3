package Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AL {
    static void main() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<5;i++){
            String name = sc.nextLine().trim();
            list.add(name);
        }

        Collections.sort(list);

        String remove = sc.nextLine();
        boolean removed = false;
        for (int i=0;i<list.size();i++){
            if (list.get(i).equalsIgnoreCase(remove)){
                list.remove(remove);
                removed = true;
                break;
            }
        }
        display(list);
    }

    static void display(ArrayList<String>list){
        if (list.isEmpty()){
            System.out.println("empty list");
        }else {
            for (String name : list){
                System.out.println(name+" ");
            }
        }
    }
}
