import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    static class Activity{
        int start;
        int end;
        Activity(int s,int e){
            start=s;
            end=e;
        }
    }



    public static int maxActivities(Activity[] activity){

        if (activity.length ==0) return 0;

        int result =1;
        int prev =0;
/*       Arrays.sort(activity, new Comparator<Activity>() {
//            @Override
//            public int compare(Activity o1, Activity o2) {
//                return o1.end - o2.end;
//            }
//        });
        Arrays.sort(activity, (o1, o2) -> o1.end - o2.end);
 */
        Arrays.sort(activity, Comparator.comparingInt(o -> o.end));
//        for (Activity x: activity)   System.out.println("Start  :: "+x.start+" End ::" + x.end);

        for (int current=1;current<activity.length;current++)
            if (activity[current].start >= activity[prev].end) {
                result++;
                prev = current;
            }

        return result;
    }

    public static void main(String[] args) {

        Activity[] activities={new Activity(12,25),
                new Activity(10,20),
                new Activity(20,30),
                new Activity(100,102),
                new Activity(101,101)
        };

        System.out.println("Max Activities are :: "+maxActivities(activities));

    }
}
