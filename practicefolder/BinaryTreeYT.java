import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeYT {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
        public void preOrder(Node root){
            if(root==null){
                System.out.print(" -1 ");
                return;
            }
            System.out.print(" "+root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public void inOrder(Node root){
            if(root==null){
                System.out.print(" -1 ");
                return;
            }
            inOrder(root.left);
            System.out.print(" "+root.data+" ");
            inOrder(root.right);
        }
        public void postOrder(Node root){
            if(root==null){
                System.out.print(" -1 ");
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(" "+root.data+" ");
        }
        public static int countNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftcount=countNodes(root.left);
            int rightcount=countNodes(root.right);
            return leftcount+rightcount+1;
        }
        public static int sumNodes(Node root){
            if(root==null){
                return 0;
            }
            int leftsum=sumNodes(root.left);
            int rightsum=sumNodes(root.right);
            return leftsum+rightsum+root.data;
        }
        public static int height(Node root){
            if(root==null){
                return 0;
            }
            int leftheight=height(root.left);
            int rightheight=height(root.right);
            return Math.max(leftheight,rightheight)+1;
        }
        public static int diameter(Node root){
            if(root==null){
                return 0;
            }
            int ld=diameter(root.left);
            int rd=diameter(root.right);
            int totalheight=height(root.left)+height(root.right)+1;
            return Math.max(totalheight,Math.max(ld,rd));
        }
        static class TreeInfo{
            int ht;
            int diam;
            public TreeInfo(int ht,int diam){
                this.ht=ht;
                this.diam=diam;
            }
        }
        public static TreeInfo diameter2(Node root){
            if(root==null){
                return new TreeInfo(0, 0);
            }
            TreeInfo left=diameter2(root.left);
            TreeInfo right=diameter2(root.right);
            int myHeight=Math.max(left.ht,right.ht)+1;
            int dim1=left.diam;
            int dim2=right.diam;
            int dim3=left.ht+right.ht+1;
            int myDiam=Math.max(Math.max(dim1,dim2),dim3);
            TreeInfo myInfo=new TreeInfo(myHeight, myDiam);
            return myInfo;
        }
        public static int levelOrder(Node root,int k,int sum){
            if(root==null){
                return 0;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            int count=1;
            while (!q.isEmpty()) {
                Node curr=q.remove();
                if(curr==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        count++;
                        q.add(null);
                    }
                }else{
                    // System.out.print(curr.data+" ");
                    if(count==k){
                        sum+=curr.data;
                    }
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                }
            }
            return sum;
    }

    }
    public static void main(String[] args) {
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes);
        System.out.print("Root Node is :"+root.data);
        System.out.println();
        System.out.print("Preorder traversal is :");
        tree.preOrder(root);
        System.out.println();
        System.out.print("Inorder traversal is :");
        tree.inOrder(root);
        System.out.println();
        System.out.print("Postorder traversal is :");
        tree.postOrder(root);
        System.out.println();
        System.out.print("LevelOrder traversal is :");
        System.out.println(tree.levelOrder(root,3,0));
        System.out.println("No of nodes in tree are :"+tree.countNodes(root));
        System.out.println("Sum of nodes in tree are :"+tree.sumNodes(root));
        System.out.println("Height of tree is :"+tree.height(root));
        System.out.println("Diameter of tree is :"+tree.diameter(root));
        System.out.println("Diameter@ of tree is :"+tree.diameter2(root).diam);
    }
}
