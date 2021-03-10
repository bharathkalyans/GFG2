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

        if(head.key == key)
            return head;
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


    public static Node deleteInBST(Node head,int key){

        if (head == null)
            return null;
        if (head.key > key){
            head.left=deleteInBST(head.left,key);
        }
        else if(head.key < key){
            head.right=deleteInBST(head.right,key);
        }
        else{
            if (head.left == null)
                return head.right;
            if (head.right == null)
                return head.left;
            else {
                Node source = getSource(head);
                head.key=source.key;
                head.right=deleteInBST(head.right, source.key);
            }
        }
       return head;

    }
    //Finding the closest Successor to the deleting Node by finding in right sub tree of the Node.
    public static Node getSource(Node root){
        Node curr = root.right;

        while (curr!=null && curr.left!=null){
            curr =curr.left;
        }
        return curr;
    }


    public static Node floorOFBST(Node head,int key){
        Node res=null;

        while (head!=null ){
            if (head.key ==key)
                return head;
            else if (head.key > key)
                head=head.left;
            else {
                res=head;
                head =head.right;
            }
        }
        return res;
    }

    public static Node ceilOFBST(Node head,int key){
        Node res = null;
        while (head!=null){
            if (head.key == key)
                return head;
            else if(head.key < key)
                head = head.right;
            else {
                res = head;
                head = head.left;
            }
        }
        return res;
    }
}
