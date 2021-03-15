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

    /*
    *  public static void BFS(ArrayList<ArrayList<Integer>> adj,int v,int s,Boolean[] visited){

        Queue<Integer> q=new LinkedList<>();

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
    * */

    public static void BFSDiscontinuedGraph(ArrayList<ArrayList<Integer>> adj,int  v){
        Boolean [] visited =new Boolean[v+1];
        for (int i=0;i<v;i++){
            visited[i] = false;
        }

        for (int i=0;i<v;i++){
            if (visited[i] == false){
//                BFS(adj,v,i,visited); Create a new function with extra parameter Boolean Visited.
            }
        }


    }


    /*Print no. of Islands in a Graph Problem :::

     public static void BFS(ArrayList<ArrayList<Integer>> adj,int v,int s,Boolean[] visited){

        Queue<Integer> q=new LinkedList<>();

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


    public static int  BFSDiscontinuedGraph(ArrayList<ArrayList<Integer>> adj,int  v){
        Boolean [] visited =new Boolean[v+1];
        for (int i=0;i<v;i++)
            visited[i] = false;

        int count =0;

        for (int i=0;i<v;i++){
            if (visited[i] == false){
                BFS(adj,v,i,visited); Create a new function with extra parameter Boolean Visited.
                count++;

            }
        }

        return count; //count --> No. of Islands!

    } */


    public static void DFS(ArrayList<ArrayList<Integer>> adj,int v,int s){

        Boolean visited[] =new Boolean[v];
        for (int i=0;i<v;i++) visited[i] = false;

        DFSRECURSIVE(adj,s,visited);

    }


    public static void DFSRECURSIVE(ArrayList<ArrayList<Integer>> adj ,int s,Boolean[] visited){

        visited[s] =true;
        System.out.print(s+ " " );

        for (int x: adj.get(s))
            if (!visited[x])
                DFSRECURSIVE(adj, x, visited);

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
        System.out.println();
        DFS(adj,vertices,0);

    }
}
