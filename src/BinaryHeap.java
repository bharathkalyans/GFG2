import org.jetbrains.annotations.NotNull;

import java.util.*;

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


    static class Triplet implements Comparable<Triplet>{

        int val,aPos,vPos;
        Triplet(int v,int ap,int vp){
            val=v;
            aPos =ap;
            vPos=vp;
        }


        public int compareTo(Triplet t){
            if (val<=t.val)
                return -1;
            else
                return 1;
        }
    }
    public static List<Integer> mergeKArrays(List<List<Integer>> arr){
         List<Integer> res =new ArrayList<>();

         PriorityQueue<Triplet> pq=new PriorityQueue<>();

         for (int i=0;i<arr.size();i++) pq.add(new Triplet(arr.get(i).get(0), i, 0));

         while (!pq.isEmpty()){

             Triplet curr = pq.poll();
             res.add(curr.val);
             int ap = curr.aPos;
             int vp=curr.vPos;

             if (vp+1 < arr.get(ap).size())
                pq.add(new Triplet(arr.get(ap).get(vp+1),ap,vp+1));

         }
         return res;
    }


    public static void printMedianOfStream(int [] arr){
         PriorityQueue<Integer> s =new PriorityQueue<>(Collections.reverseOrder());
         PriorityQueue<Integer> g =new PriorityQueue<>();

         s.add(arr[0]);
         System.out.println(arr[0]);
         for (int i=1;i<arr.length;i++){
             int x=arr[i];
             if (s.size() > g.size()){
                 if ( s.peek() > x){
                     g.add(s.poll());
                     s.add(x);
                 }else g.add(x);
                 System.out.println((double) (s.peek()+g.peek())/2);
             }
             else {
                 if (s.peek() >= x){
                     s.add(x);
                 }
                 else{
                     g.add(x);
                     s.add(g.poll());
                 }
                 System.out.println(s.peek());
             }
         }
    }


    public static void main(String []args)
     {
         MinHeap h= new MinHeap(11);
         h.insert(3);
         h.insert(2);
         h.insert(15);
         h.insert(20);

         List<List<Integer>> l= new ArrayList<>();

         ArrayList<Integer> s1=new ArrayList<>();
         ArrayList<Integer> s2=new ArrayList<>();
         ArrayList<Integer> s3=new ArrayList<>();
         s1.add(5);s1.add(10);
         s2.add(9);s2.add(4);s2.add(90);
         s3.add(6);

        l.add(s1);
        l.add(s2);
        l.add(s3);

         System.out.println(mergeKArrays(l));


     }
}

