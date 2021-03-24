import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GreedyAlgorithms {

    public static int minCoins(Integer[] coins ,Integer n, Integer amount){
        int res =0;
        int[] countOfCoins = new int[n];

        Arrays.fill(countOfCoins,0);
        Arrays.sort(coins, Collections.reverseOrder());

        for (int i=0;i< n;i++){
            if (coins[i] <= amount){
                int c = (int) Math.floor(amount/coins[i]);
                countOfCoins[i] = c;
                res += c;
                amount = amount - c * coins[i];
            }
            if (amount ==0)
                break;
        }

        for (int i=0;i<n;i++)
            if (countOfCoins[i] != 0) System.out.println(countOfCoins[i] + " Coin of " + coins[i] + " are Needed!");

        return res;
    }


    public static int maxCoins(Integer[] coins ,Integer n, Integer amount){
        int res =0;
        int[] countOfCoins = new int[n];

        Arrays.fill(countOfCoins,0);
        Arrays.sort(coins);

        for (int i=0;i< n;i++){
            if (coins[i] <= amount){
                int c = (int) Math.floor(amount/coins[i]);
                countOfCoins[i] = c;
                res += c;
                amount = amount - c * coins[i];
            }
            if (amount ==0)
                break;
        }

        for (int i=0;i<n;i++)
            if (countOfCoins[i] != 0) System.out.println(countOfCoins[i] + " Coin of " + coins[i] + " are Needed!");

        return res;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter amount :: ");
        System.out.println("Total Coins (MIN) :: ---> "+
                minCoins(new Integer[]{1,2,5,10},4,sc.nextInt()));
        System.out.println("Enter amount :: ");
        System.out.println("Total Coins (MAX) :: ---> "+
                maxCoins(new Integer[]{1,2,5,10},4,sc.nextInt()));


    }
}
