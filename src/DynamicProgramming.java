import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

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

    public static int coinChangeRecursive(int[] coins,int n,int sum){
        if (sum == 0) return 1;
        if (n == 0) return 0;

        int res = coinChangeRecursive(coins,n-1,sum);
        if (coins[n-1] <= sum)
            res += coinChangeRecursive(coins,n,sum - coins[n-1]);


        return res;
    }

    public static int coinChangeDP(int[] coins, int n, int sum) {
        int[][] dp = new int[sum+1][n+1];

        for(int i=0;i<=n;i++)
            dp[0][i]=1;



        for(int i=1;i<=sum;i++)
            for(int j=1;j<=n;j++) {
                dp[i][j] = dp[i][j-1];

                if(coins[j-1]<=i)
                    dp[i][j]+=dp[i-coins[j-1]][j];
            }


        return dp[sum][n];

    }


    public static int editDistance(String s1, String s2, int m, int n) {

        if (m == 0 )
            return  n;
        if (n == 0 )
            return  m;

        if (s1.charAt(m-1) == s2.charAt(n-1))
            return editDistance(s1,s2,m-1,n-1);

        else
            return 1 + Math.min(editDistance(s1,s2,m-1,n-1), Math.min(editDistance(s1,s2,m-1,n),
                            editDistance(s1,s2,m,n-1))
            );

    }

    public static int editDistanceDP(String s1, String s2, int m, int n){

        int DP[][] = new int[m+1][n+1];


        for (int i=0;i<=m;i++)
            DP[i][0] = i;

        for (int j=0;j<=n;j++)
            DP[0][j] = j;


        for (int i=1; i<=m;i++)
            for (int j=1;j<=n;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    DP[i][j] = DP[i-1][j-1];
                else {
                    DP[i][j] = 1 + Math.min(DP[i-1][j-1],
                                   Math.min(DP[i][j-1],DP[i-1][j])
                                    );
                }
            }

        return DP[m][n];
    }

    public static void SubSequence(String instr, StringBuffer outstr, int index) {
        for (int i = index; i < instr.length(); i++) {

            outstr.append(instr.charAt(i));
            System.out.println(outstr);
            SubSequence(instr, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
    }

    public static int LongestIncreasingSubSequence(int[] arr,int n){

        int [] lis = new int[n];

        lis[0] = 1;
        for (int i=1;i<n;i++){
            lis[i] = 1;
            for (int j = 0;j<i;j++)
                if (arr[i]>arr[j])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
        }

        int result = lis[0];
        for (int i = 1 ;i < n;i++){
            System.out.print(lis[i]+" ");
            result = Math.max(result,lis[i]);
        }
        System.out.println();
        return result;

    }

    //Efficient Way of Solving the Above Function in O(nLog n) time.
    public static int LongestIncreasingSubSequenceEff(int[] arr,int n){

        int tail[] =new int[n];

        tail[0] = arr[0];
        int len =1;

        for (int i=1;i<n;i++){
            if (arr[i]> tail[len -1]){
                tail[len] = arr[i];
                len++;
            }else {
                int c =ceilIndex(tail,0,len -1,arr[i]);
                tail[c] =arr[i];
            }
        }
        return len;
    }

    public static int ceilIndex(int[] tail,int l,int r,int x){
        while (r>l){
            int mid = l + (r-l)/2 ;
            if (tail[mid] >= x)
                r= mid;
            else
                l= mid+1;
        }
        return r;
    }


    //Below Function Time Complexity is O(n^3)!
    public static int maxCutsRecursive(int n, int a, int b, int c){
        if (n < 0 ) return -1;
        if (n ==0 ) return 0;

        int res = Math.max(maxCutsRecursive(n-a,a,b,c),
                Math.max(maxCutsRecursive(n-b,a,b,c), maxCutsRecursive(n-c,a,b,c)));

        if (res == -1)
            return -1;

        return res;
    }

    //DP Solution is below
    public static int maxCuts(int n,int a,int b,int c){

        int DP[] =new int[n+1];

        DP[0] = 0;

        for (int i=1;i<n;i++){
            DP[i]  = -1;
            if (i - a >= 0)
                DP[i] = Math.max(DP[i],DP[i-a]);
            if (i - b >= 0)
                DP[i] = Math.max(DP[i],DP[i-b]);
            if (i - c >= 0)
                DP[i] = Math.max(DP[i],DP[i-c]);


            if (DP[i]!=-1)
                DP[i] = DP[i] + 1;

        }


        return DP[n];
    }


    public static int minimumCoinsRecursive(int [] coins,int n,int value){

        if (value == 0) return 0;

        int result = Integer.MAX_VALUE;

        for (int i=0;i<n;i++){
            if (coins[i] <= value){
                int sub_res = minimumCoinsRecursive(coins,n,value - coins[i]);

                if (sub_res!= Integer.MAX_VALUE)
                    result = Math.min(result,sub_res);
            }
        }

      return result;
    }

    public static void main(String[] args) {



    }
}

