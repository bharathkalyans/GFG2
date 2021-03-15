import java.lang.reflect.Array;
import java.util.*;

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



    public static void BFS(ArrayList<ArrayList<Integer>> adj,int v,int s){

        Queue<Integer> q=new LinkedList<>();

        Boolean [] visited = new Boolean[v+1];
        for(int i = 0; i < v; i++)
            visited[i] = false;

        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u+" ");

            for (int x: adj.get(u)){
                if (visited [x] == false){
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
    }
    public static void main(String[] args) {

        int vertices = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i=0;i<vertices;i++)
            adj.add(new ArrayList<Integer>());


        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,1,3);
        addEdge(adj,3,4);
        addEdge(adj,2,4);


        BFS(adj,vertices,2);


    }
}
