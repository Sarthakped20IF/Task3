package Task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hm {
    static void main() {
        Scanner sc = new Scanner(System.in);

        HashMap<String,Double>map = new HashMap<>();
        //adding employees

        map.put("Amit", 55000.0);
        map.put("Neha", 62000.0);
        map.put("Zara", 70000.0);


        display(map);

        System.out.println("update Salary");
        String updateName = sc.next().trim();
        if (!map.containsKey(updateName)){
            System.out.println("Employee Not found!");
        }else {
            double salary = sc.nextDouble();
            map.put(updateName,salary);
            System.out.println("updated");
        }
        display(map);
        System.out.println("remove employee");

        String removeName = sc.next().trim();
        if (!map.containsKey(removeName)){
            System.out.println("Employee does not exists");
        }else {
            map.remove(removeName);
        }
        display(map);
    }


//    Display all entries
    static void display (HashMap<String,Double>map){
        if (map.isEmpty()){
            System.out.println("No entries found!");
        }else {
            for (Map.Entry<String,Double>entry: map.entrySet()){
                System.out.println(entry.getKey()+"->"+entry.getValue());
            }
        }
    }
}
