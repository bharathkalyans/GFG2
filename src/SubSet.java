public class SubSet {




    public static void printSubSet(String str,String curr,int index){
        if (index == str.length()) {
            System.out.println(curr);
            return;
        }
        printSubSet(str,curr,index+1);
        printSubSet(str,curr+str.charAt(index),index+1);
    }
    public static void subSet(String str){
        printSubSet(str,"",0);
    }
    public static void main(String[] args) {
        subSet("ABC");
    }
}
