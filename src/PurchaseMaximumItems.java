import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PurchaseMaximumItems {

    public static void main(String[] args) {

    }

    public static int purchaseItems(int[] a,int sum){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x: a)
            pq.add(x);



        int res=0;
        while (true){
            if (sum > pq.peek()){
                res++;
                sum -= pq.poll();
            }
            else if(sum < pq.peek()){
                return res;
            }
        }

    }
}
