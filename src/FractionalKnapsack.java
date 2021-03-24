import java.util.Arrays;

public class FractionalKnapsack {

    static class Item implements Comparable<Item> {
        int weight;
        int value;

        Item(int w, int v) {
            weight = w;
            value = v;
        }

        public int compareTo(Item i) {
            return weight * i.value - value * i.weight;
        }

    }


//        Arrays.sort(pairs, new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                return o2.value/o2.weight - o1.value/o1.weight;
//            }
//        });

        static double fractionalKnapSack(Item arr[], int n, int W){
            Arrays.sort(arr);

            double  res = 0.0;

            for(int i = 0; i < n; i++)
                if (arr[i].weight <= W) {
                    res += arr[i].value;
                    W = W - arr[i].weight;
                } else {
                    res += arr[i].value * ((double) W / arr[i].weight);

                    break;
                }


            return res;
    }


    public static void main(String args[]) {
        Item arr[] = {new Item(10, 60),
                new Item(40, 40),
                new Item(20, 100),
                new Item(30, 120)};

        int n = 4, W = 50;

        System.out.println(fractionalKnapSack(arr, n, W));

    }
}
