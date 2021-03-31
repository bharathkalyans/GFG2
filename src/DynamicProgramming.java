import java.util.Arrays;

public class DynamicProgramming {

    //Time Complexity is 2^n
    public static int fibonacci(int n){
        if (n==0 || n==1)
            return n;
        else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    //DP Solution.

    public static void fibDP(int n){
         int N =1000;
         int[] DPArray =new int[N];
         Arrays.fill(DPArray,-1);
         fibonacciDP(23,DPArray);

         for (int i=0;i< n;i++) System.out.print( DPArray[i]+" ");

         System.out.println();
         System.out.println("-----------------------------");

         Arrays.fill(DPArray,0);
         fibonacciDp(n,DPArray);

         for (int i=0;i< n;i++) System.out.print( DPArray[i]+" ");

    }
    //Memoization technique(Top Down Approach)
    public static int fibonacciDP(int n,int[] array){
        if (array[n] == -1 ){
            int res = 0;
            if (n==0 || n == 1)
                res = n;
            else
                res = fibonacciDP(n - 1, array) + fibonacciDP(n - 2, array);

            array[n] = res;
        }
        return array[n];
    }

    //Tabulation technique(Bottom Down Approach)
    public static void fibonacciDp(int n,int [] array){
        array[0] =0;
        array[1] =1;

        for (int i=2;i<=n;i++)
            array[i] = array[i-1]+array[i-2];

    }


   static void SubSequenceOfString(String instr, StringBuffer outstr, int index) {
        for (int i = index; i < instr.length(); i++) {

            outstr.append(instr.charAt(i));
            System.out.println(outstr);
            SubSequenceOfString(instr, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
    }
    public static void main(String[] args) {

    SubSequenceOfString("ABC",new StringBuffer(),0);



    }
}
