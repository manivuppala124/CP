import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void printAllPaths(ArrayList<Edge> graph[],int curr,boolean[] vis,String path,int tar){
        if(curr==tar){
            System.out.println(path);
            return;
        }
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                vis[curr]=true;
                printAllPaths(graph, e.dest, vis, path+e.dest, tar);
                vis[curr]=false;
            }
        }
    }
    public static boolean isCycleDirected(ArrayList<Edge> graph[],boolean vis[],int curr,boolean rec[]){
        vis[curr]=true;
        rec[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(rec[e.dest]==true){
                return true;
            }
            else if(!vis[e.dest]){
                isCycleDirected(graph, vis, e.dest, rec);
            }
        }
        rec[curr]=false;
        return false;
    }
    public static void DFS(ArrayList<Edge> graph[], int curr,boolean[] vis){
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
            DFS(graph, e.dest, vis);
            }
        }
    }
    public static void BFS(ArrayList<Edge> graph[], int v,boolean vis[],int src){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(vis[curr]==false){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void topUtil(ArrayList<Edge> graph[],int curr,boolean vis[],Stack<Integer> s){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                topUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }
    public static void topSort(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topUtil(graph, i, vis, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }
    public static boolean isCycleUndirected(ArrayList<Edge> graph[],boolean vis[],int curr,int par){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]&&e.dest!=par){
                return true;
            }
            else if(!vis[e.dest]){
                if(isCycleUndirected(graph, vis, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int n,int d){
            this.node=n;
            this.dist=d;
        }

        @Override
        public int compareTo(Pair o){
            return this.dist-o.dist;//ascending
        }
    }
    //O(E+ElogV)
    public static void dijkstra(ArrayList<Edge> graph[],int src,int v){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int dist[]=new int[v];
        for(int i=0;i<v;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean vis[]=new boolean[v];
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr=pq.remove();
            if(!vis[curr.node]){
                vis[curr.node]=true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    int u=e.src;
                    int V=e.dest;
                    if(dist[u]+e.wt<dist[V]){
                        dist[V]=dist[u]+e.wt;
                        pq.add(new Pair(V,dist[V]));
                    }

                }
            }
        }
        for(int i=0;i<v;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        //directed unweighted graph
// graph[3].add(new Edge(2, 3));
// graph[3].add(new Edge(3, 1));
// graph[4].add(new Edge(4, 0));
// graph[4].add(new Edge(4, 1));
// graph[5].add(new Edge(5, 0));
// graph[5].add(new Edge(5, 2));
//directed weighted graph
graph[0].add(new Edge(0, 1, 2));
graph[0].add(new Edge(0, 2, 4));

graph[1].add(new Edge(1, 3, 7));
graph[1].add(new Edge(1, 2, 1));

graph[2].add(new Edge(2, 4, 3));

graph[3].add(new Edge(3, 5, 1));

graph[4].add(new Edge(4, 3, 2));
graph[4].add(new Edge(4, 5, 5));

        System.out.println("Neighbours of 2");
        for(int i=0;i<graph[2].size();i++){
            Edge e=graph[2].get(i);
            System.out.print(e.dest+" ");
        }
        System.out.println();
        System.out.println("BFS traversal");
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(vis[i]==false){
                BFS(graph, v, vis, i);
            }
        }
        System.out.println();
        System.out.println("DFS traversal");
        vis=new boolean[v];
        for(int i=0;i<v;i++){
            if(vis[i]==false){
                DFS(graph, i, vis);
            }
        }
        System.out.println();
        System.out.println("Path from 0 to 5");
        vis=new boolean[v];
        printAllPaths(graph, 0, vis, "0", 5);
        System.out.println(isCycleDirected(graph,new boolean[v], 0, new boolean[v]));
        topSort(graph);
        System.out.println();
        System.out.println(isCycleUndirected(graph, new boolean[v], 0, -1));
        dijkstra(graph, 0, v);
    }
}
