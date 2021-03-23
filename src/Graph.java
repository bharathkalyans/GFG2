import java.util.*;

public class Graph {
    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL = -1;

    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

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

    static final int Vert=4;
    public static int[] dijkstra(int graph[][], int src) {

        int[] dist=new int[Vert];int res=0;
        Arrays.fill(dist,Integer.MAX_VALUE);dist[src]=0;
        boolean[] fin=new boolean[Vert];

        for (int count = 0; count < Vert-1 ; count++)
        {
            int u = -1;
 
            //Finds the minimum value of all vertices
            for(int i=0;i<Vert;i++)
                if(!fin[i]&&(u==-1||dist[i]<dist[u]))
                    u=i;

            //Sets the vertex to visited
            fin[u] = true;

            //Relaxes the Adjacent vertices of the Vertex Selected .
            for (int v = 0; v < Vert; v++)

                if (graph[u][v]!=0 && fin[v] == false)
                    dist[v] = Math.min(dist[v],dist[u]+graph[u][v]);//Relax Operation.
        }
        return dist;
    }

    // A recursive function that find articulation points using DFS
    // u --> The vertex to be visited next
    // visited[] --> keeps tract of visited vertices
    // disc[] --> Stores discovery times of visited vertices
    // parent[] --> Stores parent vertices in DFS tree
    // ap[] --> Store articulation points
    void APUtil(int u, boolean visited[], int disc[],
                int low[], int parent[], boolean ap[])
    {

        // Count of children in DFS Tree
        int children = 0;

        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;

        // Go through all vertices adjacent to this
        Iterator<Integer> i = adj[u].iterator();
        while (i.hasNext())
        {
            int v = i.next();  // v is current adjacent of u

            // If v is not visited yet, then make it a child of u
            // in DFS tree and recur for it
            if (!visited[v])
            {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap);

                // Check if the subtree rooted with v has a connection to
                // one of the ancestors of u
                low[u]  = Math.min(low[u], low[v]);

                // u is an articulation point in following cases

                // (1) u is root of DFS tree and has two or more children.
                if (parent[u] == NIL && children > 1)
                    ap[u] = true;

                // (2) If u is not root and low value of one of its child
                // is more than discovery value of u.
                if (parent[u] != NIL && low[v] >= disc[u])
                    ap[u] = true;
            }

            // Update low value of u for parent function calls.
            else if (v != parent[u])
                low[u]  = Math.min(low[u], disc[v]);
        }
    }

    // The function to do DFS traversal.
    // It uses recursive function APUtil()
    void AP()
    {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        boolean ap[] = new boolean[V]; // To store articulation points

        // Initialize parent and visited, and ap(articulation point)
        // arrays
        for (int i = 0; i < V; i++)
        {
            parent[i] = NIL;
            visited[i] = false;
            ap[i] = false;
        }

        // Call the recursive helper function to find articulation
        // points in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                APUtil(i, visited, disc, low, parent, ap);

        // Now ap[] contains articulation points, print them
        for (int i = 0; i < V; i++)
            if (ap[i] == true)
                System.out.print(i+" ");
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


