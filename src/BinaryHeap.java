import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class BinaryHeap {
     public static class MinHeap{
         int [] arr;
         int size;
         int capacity;

         MinHeap(int c){
             size = 0;
             capacity = c;
             arr = new int[c];
         }

         int left(int i) { return (2*i + 1); }
         int right(int i) { return (2*i + 2); }
         int parent(int i) { return (i-1)/2; }


         public void getHeap(){
             for (int x: arr)
                 System.out.println(x);
         }

         public void insert(int x) {
             if (size == capacity)return;
             size++;
             arr[size-1]=x;

             for (int i=size-1;i!=0 && arr[parent(i)]>arr[i];)
             {
                 swap(arr,i,parent(i));
                 i = parent(i);
             }
         }

         public void extractHeap(int i){
             if (size == 0)
                return;

             if (size == 1){
                 size --;
                 return;
             }


             swap(arr,i,size );
             arr[size --] =0  ;
             heapifyHeap(i);

         }

         public void decreaseKey(int i,int value){
             if(i > size)
                 return;
             arr[i]=value;

             while (i!=0 && arr[parent(i)] > arr[i]){
                 swap(arr,parent(i),i);
                 i=parent(i);
             }

         }

         public void heapifyHeap(int i){
            int lt=left(i),rt =right(i);

            int smallest =i;
            if (lt < size && arr[lt]<arr[i]){
                smallest = lt;
            }
            if (rt < size && arr[rt] < arr[smallest]){
                smallest = rt;
            }

           if (smallest!=i){
               swap(arr,smallest,i);
               heapifyHeap(smallest);
           }

         }

          public void swap(int []arr,int i,int j){
             int temp = arr[i];
             arr[i] = arr[j];
             arr[j] = temp;
         }

     }


    public static void printKClosestElementsNaive(int[] arr,int x,int k,int n){
             Boolean []b=new Boolean[n];
             Arrays.fill(b,false);

             for (int  i=0;i<k;i++){
                 int min_diff= Integer.MIN_VALUE;
                 int min_diff_index = 1 ;

                 for (int j=0;j<n;j++){
                     if (!b[j] && Math.abs(arr[j]-x)<=min_diff){
                         min_diff = Math.abs(arr[j] - x);
                         min_diff_index = j;
                     }
                 }
                 System.out.println(arr[min_diff_index]);
                 b[min_diff_index] = true;
             }
    }

    public static void printKthClosestElements(int [] arr,int k,int x){
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                new Comparator<Pair>()
                {
                    public int compare(Pair p1, Pair p2)
                    {
                        return p2.getValue().compareTo(
                                p1.getValue());
                    }
                });

        for (int i=0;i<k;i++){
            pq.add(new Pair(Math.abs(arr[i] - x), i));
        }

        for (int i=k;i<arr.length;i++){
            int diff = Math.abs(arr[i] - x);
            if (pq.peek().value > diff){
                pq.poll();
                pq.add(new Pair(diff, i));
            }
        }
        for (int i=0;i<k;i++) System.out.println(pq.poll() + " ");

    }
    static class Pair
    {
        Integer key;
        Integer value;

        public Pair(Integer key, Integer value)
        {
            this.key = key;
            this.value = value;
        }
        public Integer getKey()
        {
            return key;
        }
        public void setKey(Integer key)
        {
            this.key = key;
        }
        public Integer getValue()
        {
            return value;
        }
        public void setValue(Integer value)
        {
            this.value = value;
        }
    }



    public static void main(String []args)
     {
         MinHeap h= new MinHeap(11);
         h.insert(3);
         h.insert(2);
         h.insert(15);
         h.insert(20);

        int[] arr={10,30,5,40,38,80,70};
         printKthClosestElements(arr,3,35);
     }
}

