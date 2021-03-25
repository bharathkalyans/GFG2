import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencing {

    char id;
    int deadline, profit;

    public JobSequencing(){}

    public JobSequencing(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    public void printJobScheduling(ArrayList<JobSequencing> arr,int t){

        int n=arr.size();

        Collections.sort(arr, (a,b) -> b.profit -a.profit);

        boolean[] result = new boolean[t];

        char[] job = new char[t];

        // Iterate through all given jobs
        for (int i = 0; i < n; i++)
            for (int j = Math.min(t - 1, arr.get(i).deadline - 1); j >= 0; j--)
                if (!result[j]) {
                    result[j] = true;
                    job[j] = arr.get(i).id;
                    break;
                }

        for (char jb : job) System.out.print(jb + " ");

        System.out.println();

    }


    public static void main(String[] args) {
        ArrayList<JobSequencing> arr = new ArrayList<JobSequencing>();

        arr.add(new JobSequencing('a', 2, 100));
        arr.add(new JobSequencing('b', 1, 19));
        arr.add(new JobSequencing('c', 2, 27));
        arr.add(new JobSequencing('d', 1, 25));
        arr.add(new JobSequencing('e', 3, 15));


        System.out.println("Following is maximum "
                + "profit sequence of jobs");



        new JobSequencing().printJobScheduling(arr, 3);
    }
}
