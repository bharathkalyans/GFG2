import java.util.*;

public class CollectionsInJava {
    public static void main(String[] args) {

        HashMap<String,Integer>  map = new HashMap<>();

        map.put("Bharath",123);

        System.out.println(map.get("123"));
        System.out.println(map.getOrDefault("Ananth",999));

        Scanner sc=new Scanner(System.in);
        HashSet<Integer> table=new HashSet<>();

        for (int i=0;i<4;i++) {
            table.add(sc.nextInt());
        }

        for (Integer integer : table) {
            System.out.println(integer);
        }

        LinkedList<Integer> l=new LinkedList<>();
        l.addFirst(12);
        l.addFirst(13);
        l.addFirst(14);
        l.addLast(100);

        for (Integer integer:
             l) {
            System.out.println(integer);
        }




    }
}
