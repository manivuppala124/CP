// Program to implement Disjoint Set Data Structure.

/*
5 = number of friends
3 = number of relationships
2 = number of friendship check
input=5
3
0 2
4 2
3 1
2
4 0
1 0
output=4 is a friend of 0
1 is not a friend of 0

*/
import java.io.*;
import java.util.*;

class DisjointUnionSets {
	int[] rank, parent;
	int n;

	public DisjointUnionSets(int n){
		rank = new int[n];
		parent = new int[n];
		this.n = n;
		makeSet();
	}
	// Creates n sets with single item in each
	void makeSet(){
		for(int i=0;i<n;i++){
		    parent[i]=i;
		}
	}

	// Returns representative of x's set
	int find(int x){
		if(parent[x]==x){
		    return x;
		}
		parent[x]=find(parent[x]);
		return parent[x];
		
	}

	// Unites the set that includes x and the set that includes x
	void union(int x, int y){
	    int xRoot=find(x),yRoot=find(y);
	    if(rank[xRoot]>rank[yRoot]){
	        parent[yRoot]=xRoot;
	    }else if(rank[xRoot]<rank[yRoot]){
	        parent[xRoot]=yRoot;
	    }else{
	        parent[yRoot]=xRoot;
	        rank[xRoot]++;
	    }
	}
}

class test {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		    int n=sc.nextInt();
		    DisjointUnionSets d=new DisjointUnionSets(n);
		    int r=sc.nextInt();
		    for(int i=0;i<r;i++){
		        int src=sc.nextInt();
		        int dest=sc.nextInt();
		        d.union(src,dest);
		    }
		    int c=sc.nextInt();
		    int[] src=new int[c];
		    int[] dest=new int[c];
		    for(int i=0;i<c;i++){
		        int src[i]=sc.nextInt();
		        int dest[i]=sc.nextInt();
		    }
		    for(int i=0;i<c;i++){
		        if(d.find(src[i])==d.find(dest[i])){
		            System.out.println(src[i]+" is a friend of "+dest[i]);
		        }else{
		            System.out.println(src[i]+" is not a friend of "+dest[i]);
		        }
		    }
		}		
	}
}



