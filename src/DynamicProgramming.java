import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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


    public static int LongestCommonSubSequence(String s1,String s2,int m,int n){
        if (m ==0 || n==0)
            return 0;

        if (s1.charAt(m-1) == s2.charAt(n-1))
            return 1 + LongestCommonSubSequence(s1,s2,m-1,n-1);
        else
            return Math.max(LongestCommonSubSequence(s1,s2,m-1,n),
                    LongestCommonSubSequence(s1,s2,m,n-1));
    }

    static int[][] memo;

    static int lcs(String s1, String s2, int n, int m) {
        if(memo[n][m]!=-1)
            return memo[n][m];

        if(n==0 || m==0)
            memo[n][m]=0;

        else {
            if(s1.charAt(n-1)==s2.charAt(m-1))
                memo[n][m] = 1 + lcs(s1,s2,n-1,m-1);
            else
                memo[n][m] = Math.max(lcs(s1,s2,n-1,m),lcs(s1,s2,n,m-1));
        }

        return memo[n][m];

    }

    public static void printMemoTable(){
        for (int i=0;i< memo.length;i++){
            for (int j=0;j< memo[i].length;j++)
                System.out.print(memo[i][j]+" ");
            System.out.println();
        }
    }

    public static Set<String> printLCS(String X, String Y, int m, int n) {
        Set<String> s = new HashSet<>();

        if (m == 0 || n == 0) {
            s.add("");
            return s;
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {

            Set<String> tmp = printLCS(X, Y, m - 1, n - 1);


            for (String str : tmp)
                s.add(str + X.charAt(m - 1));
        }

        else {
            if (memo[m - 1][n] >= memo[m][n - 1])
                s = printLCS(X, Y, m - 1, n);

            if (memo[m][n - 1] >= memo[m - 1][n]) {
                Set<String> tmp = printLCS(X, Y, m, n - 1);

                s.addAll(tmp);
            }
        }
        return s;
    }
    public static void main(String[] args) {

        String s1="ABC", s2= "BCD";

        int n = s1.length();
        int m = s2.length();

        memo= new int[n+1][m+1];

        for(int[] i: memo)
            Arrays.fill(i,-1);


        System.out.println(lcs(s1,s2,n,m));
        printMemoTable();
        Set<String > s = printLCS(s1,s2,n,m);

        for (String ss: s)
            System.out.println(ss);
    }
}
