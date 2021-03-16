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

            for (int x: adj.get(u))
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
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
            if (!visited[i]){
//                BFS(adj,v,i,visited); Create a new function with extra parameter Boolean Visited.
            }
        }


    }


    /*Print no. of Islands in a Graph Problem :::

     public static void BFS(ArrayList<ArrayList<Integer>> adj,int s,Boolean[] visited){

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
                BFS(adj,i,visited); Create a new function with extra parameter Boolean Visited.
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



    public static void shortestPathFromSource(ArrayList<ArrayList<Integer>> adj,int v,int s){

        Queue<Integer> q=new LinkedList<>();

        int Distance[] = new int[v];
        for (int i=0;i<v;i++)  Distance[i]=Integer.MAX_VALUE;

        Distance[s] = 0;

        Boolean visited[] = new Boolean[v];
        for (int i=0;i<v;i++) visited[i] = false;

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()){
            int u=q.poll();

            for (int x: adj.get(u)){
                if (!visited[x]){
                    visited[x] = true;
                    q.add(x);
                    Distance[x] = Distance[u] +1;
                }
            }

        }

        for (int x: Distance)
            System.out.print(x+" ");

    }

    public static boolean detectCycleInGraphUnDirected(ArrayList<ArrayList<Integer>> adj, int vertices){
        Boolean [] visited = new Boolean[vertices];
        for (int i=0;i<vertices;i++) visited[i] = false;

        for (int i=0;i<vertices;i++){
            if (!visited[i]){
                if (detectCycle(adj, visited, i, -1))
                    return true;
            }
        }

        return false;
    }
    public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj,
                                      Boolean[] visited,
                                      Integer source,
                                      Integer parent) {
        visited[source] = true;
        for (int x:adj.get(source)){
            if (!visited[x]){
                if (detectCycle(adj,visited,x,source))
                    return true;
                else if (x!= parent)
                    return true;
            }
        }
        return false;
    }


    public static boolean detectCycleDirected(ArrayList<ArrayList<Integer>> adj,int vertices){
        Boolean [] visited = new Boolean[vertices];
        for (int i=0;i<vertices;i++) visited[i] = false;

        Boolean [] recursionStack = new Boolean[vertices];
        for (int i=0;i<vertices;i++) recursionStack[i] = false;


        for (int i=0;i<vertices;i++)
            if (visited[i] == false)
                if (detectCycleInGraphDirected(adj, i, visited, recursionStack))
                    return true;

        return false;
    }
    public static boolean detectCycleInGraphDirected(ArrayList<ArrayList<Integer>> adj ,
                                                     int source,
                                                     Boolean[] visited,
                                                     Boolean [] recursionStack){

        visited[source] =true;
        recursionStack[source] =true;

        for (int x: adj.get(source)){
            if (visited[x] == false && detectCycleInGraphDirected(adj,x,visited,recursionStack))
                return true;
            else if( recursionStack[x] == true)
                return true;
        }
        recursionStack[source] = false;
        return false;
    }

    public static void main(String[] args) {

        int vertices = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i=0;i<vertices;i++)
            adj.add(new ArrayList<>());

        /*      //For Undirected Graph
                addEdge(adj,0,1);
                addEdge(adj,0,2);
                addEdge(adj,1,2);
                addEdge(adj,2,3);
                addEdge(adj,1,3);
                addEdge(adj,3,4);
                addEdge(adj,2,4);*/


        addEdge(adj,0,1);
        addEdge(adj,2,1);
        addEdge(adj,2,3);
        addEdge(adj,3,4);
        addEdge(adj,4,5);
        addEdge(adj,5,3);
        System.out.println(detectCycleDirected(adj,vertices));
    }
}
