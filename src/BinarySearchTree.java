import java.util.Scanner;

class Node{

    int key;
    Node left;
    Node right;

    Node(int key){
        this.key = key;
    }
}

public class BinarySearchTree {

    //Time Complexity is O(h+1) ~~O(h)
    //Auxiliary Space is O(h) for iterative approach it's O(1) Space!

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Node root=new Node(10);
        root.left=new Node(2);
        root.right=new Node(11);
        root.left.left=new Node(1);
        root.left.right=new Node(3);
        root.right.right=new Node(23);
        root.right.right.right=new Node(39);

        insertIntoBST(root,sc.nextInt());
        System.out.println(returnMax(root,0));
        inorderTraversal(root);
    }


    public static int returnMax(Node head,int max){
        if (head == null)
            return max;
        if (head.key > max)
            max = head.key;

        return (Math.max(returnMax(head.left,max),returnMax(head.right,max)));

    }

    public static void inorderTraversal(Node head){
        if (head!=null){
            inorderTraversal(head.left);
            System.out.println(head.key);
            inorderTraversal(head.right);
        }
    }

    public static  Node  insertIntoBST(Node head,int key){
        if (head == null)
            return new Node(key);

        if (head.key >key)
            head.left = insertIntoBST(head.left,key);
        else
            head.right = insertIntoBST(head.right,key);

        return head;
    }
    
    public static boolean searchKey(Node head,int key){
        if (head == null)
            return false;
        if (head.key == key)
            return true;
        else if (head.key >key)
            return searchKey(head.left,key);
        else
            return searchKey(head.right,key);
    }
}
