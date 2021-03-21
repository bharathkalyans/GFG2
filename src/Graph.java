import java.util.*;

public class Graph {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
//        adj.get(v).add(u); //Only for Undirected Graphs...
    }


    public static void printGraph(ArrayList<ArrayList<Integer>> adj){

        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "+adj.get(i).get(j));
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
    public static void inDegreeOfGraph(ArrayList<ArrayList<Integer>> adj,int vertices){
        int [] inDegree =new int[vertices];
        for (int i=0;i<vertices;i++) inDegree[i] =0;

        for (ArrayList<Integer> x: adj)
            for (int element : x)
                inDegree[element] += 1;


        for (int x: inDegree)
            System.out.println(x);
    }

    static final int V=4;
    public static int[] dijkstra(int graph[][], int src) {

        int[] dist=new int[V];int res=0;
        Arrays.fill(dist,Integer.MAX_VALUE);dist[src]=0;
        boolean[] fin=new boolean[V];

        for (int count = 0; count < V-1 ; count++)
        {
            int u = -1;
 
            //Finds the minimum value of all vertices
            for(int i=0;i<V;i++)
                if(!fin[i]&&(u==-1||dist[i]<dist[u]))
                    u=i;

            //Sets the vertex to visited
            fin[u] = true;

            //Relaxes the Adjacent vertices of the Vertex Selected .
            for (int v = 0; v < V; v++)

                if (graph[u][v]!=0 && fin[v] == false)
                    dist[v] = Math.min(dist[v],dist[u]+graph[u][v]);//Relax Operation.
        }
        return dist;
    }

    public static void TopologicalSort(ArrayList<ArrayList<Integer>> adj,int v){
        Boolean visited[]= new Boolean[v];
        Arrays.fill(visited,false);




    }


    public static void main(String[] args) {

        int vertices = 5;
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


        addEdge(adj,0, 2);
        addEdge(adj,0, 3);
        addEdge(adj,1, 3);
        addEdge(adj,1, 4);
        addEdge(adj,2, 3);


        }
    }


