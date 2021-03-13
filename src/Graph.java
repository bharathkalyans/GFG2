import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    public static void printGraph(ArrayList<ArrayList<Integer>> adj){

        for (ArrayList<Integer> integers : adj) {

            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int vertices = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

/*
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Vertices :: ");
        vertices = sc.nextInt();
*/

        for (int i=0;i<vertices;i++)
            adj.add(new ArrayList<>());


        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,3,4);
        printGraph(adj);






    }
}
