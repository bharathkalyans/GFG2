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
         int[] memoizationArray =new int[N];
         Arrays.fill(memoizationArray,-1);
         fibonacciDP(23,memoizationArray);

         for (int i=0;i< n;i++)
            System.out.print( memoizationArray[i]+" ");



    }
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


    public static void main(String[] args) {

        fibDP(4);
    }
}
