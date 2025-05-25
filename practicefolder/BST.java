import java.util.ArrayList;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left, val);
        }
        if(root.data<val){
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left, key);
        }
        return search(root.right, key);
    }
    public static void printInRange(Node root,int x,int y){
        if(root==null){
            return;
        }
        if(root.data>=x&&root.data<=y){
            printInRange(root.left, x, y);
            System.out.print(root.data+" ");
            printInRange(root.right, x, y);
        }
        else if(root.data>=y){
            printInRange(root.left, x, y);
        }
        else{
            printInRange(root.right, x, y);
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }
    public static void printRoot2Leaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null&&root.right==null){
            printPath(path);
        }
        else{
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
    }
    path.remove(path.size()-1);
    }
    public static Node delete(Node root,int key){
        if(root==null){
            return null;
        }
        if(root.data>key){
            root.left=delete(root.left, key);
        }else if(root.data<key){
            root.right=delete(root.right, key);
        }
        else{
            if(root.left==null&&root.right==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            Node IS=inorderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right, IS.data);
        }
        return root;
    }
    public static Node inorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        int values[]={8,5,3,6,10,11,14};
        Node root=null;
        for(int i:values){
            root=insert(root, i);
        }
        inOrder(root);
        System.out.println();
        System.out.println(search(root, 6));
        delete(root, 5);
        inOrder(root);
        System.out.println();
        System.out.println("print in range");
        printInRange(root, 2, 7);
        System.out.println();
        System.out.println("paths");
        printRoot2Leaf(root, new ArrayList<>());
    }
}
