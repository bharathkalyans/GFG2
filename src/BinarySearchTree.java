import javax.swing.plaf.metal.MetalButtonUI;
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


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

    }


    public boolean searchKey(Node head,int key){
        if (head == null)
            return false;
        if (head.key == key)
            return true;
        else if (head.key >key){
            return searchKey(head.left,key);
        }
        else if (head.key < key){
            return searchKey(head.right,key);
        }
        return false;
    }
}
