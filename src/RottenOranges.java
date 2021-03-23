import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {


    static int R = 3;
    static int C = 5;

    //Naive Approach
    static boolean isSafe(int i, int j) {
        return i >= 0 && i < R &&
                j >= 0 && j < C;
    }

    static int rottenOranges(int[][] v) {

        boolean changed = false;
        int no = 2;

        while (true) {
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    // Rot all other oranges present at
                    // (i+1, j), (i, j-1), (i, j+1), (i-1, j)
                    if (v[i][j] == no) {

                        if (isSafe(i + 1, j) &&
                                v[i + 1][j] == 1)
                        {
                            v[i + 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (isSafe(i, j + 1) &&
                                v[i][j + 1] == 1)
                        {
                            v[i][j + 1] = v[i][j] + 1;
                            changed = true;
                        }
                        if (isSafe(i - 1, j) &&
                                v[i - 1][j] == 1)
                        {
                            v[i - 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (isSafe(i, j - 1) &&
                                v[i][j - 1] == 1)
                        {
                            v[i][j - 1] = v[i][j] + 1;
                            changed = true;
                        }
                    }
                }
            }

            // If no rotten orange found it means all
            // oranges rotted now
            if (!changed)
                break;

            changed = false;
            no++;
        }

        for(int i = 0; i < R; i++)
            for(int j = 0; j < C; j++)
                if (v[i][j] == 1)
                    return -1;


        // Because initial value for a rotten
        // orange was 2
        return no - 2;
    }


    //Efficient
   public  static class Cell {
        int x = 0;
        int y = 0;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isValid(int i, int j) {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }

    static boolean isDelimiter(Cell temp) {
        return (temp.x == -1 && temp.y == -1);
    }

    // Function to check whether there is still a fresh orange remaining
    static boolean checkAll(int arr[][]){
        for (int i=0; i<R; i++)
            for (int j=0; j<C; j++)
                if (arr[i][j] == 1)
                    return true;
        return false;
    }

    static int rotOranges(int arr[][]) {

        Queue<Cell> Q=new LinkedList<>();
        Cell temp;
        int ans = 0;

        // Store all the cells having rotten orange in first time frame
        for (int i=0; i < R; i++)
            for (int j=0; j < C; j++)
                if (arr[i][j] == 2)
                    Q.add(new Cell(i,j));

        //Delimiter Added
        Q.add(new Cell(-1,-1));

        while(!Q.isEmpty()) {
            // This flag is used to determine whether even a single fresh
            // orange gets rotten due to rotten oranges in the current time
            // frame so we can increase the count of the required time.
            boolean flag = false;

            // Process all the rotten oranges in current time frame.
            while(!isDelimiter(Q.peek())) {

                temp = Q.peek();

                // Check right adjacent cell that if it can be rotten
                if(isValid(temp.x+1, temp.y) && arr[temp.x+1][temp.y] == 1) {
                    if(!flag) {
                        // if this is the first orange to get rotten, increase count and set the flag.
                        ans++;
                        flag = true;
                    }
                    // Make the orange rotten
                    arr[temp.x+1][temp.y] = 2;

                    // push the adjacent orange to Queue
                    temp.x++;
                    Q.add(new Cell(temp.x,temp.y));
                    // Move back to current cell
                    temp.x--;
                }

                // Check left adjacent cell that if it can be rotten
                if (isValid(temp.x-1, temp.y) && arr[temp.x-1][temp.y] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }

                    arr[temp.x-1][temp.y] = 2;
                    temp.x--;
                    Q.add(new Cell(temp.x,temp.y));
                    temp.x++;
                }

                // Check top adjacent cell that if it can be rotten
                if (isValid(temp.x, temp.y+1) && arr[temp.x][temp.y+1] == 1) {
                    if(!flag) {
                        ans++;
                        flag = true;
                    }

                    arr[temp.x][temp.y+1] = 2;
                    temp.y++;
                    Q.add(new Cell(temp.x,temp.y));
                    temp.y--;
                }

                // Check bottom adjacent cell if it can be rotten
                if (isValid(temp.x, temp.y-1) && arr[temp.x][temp.y-1] == 1)
                {
                    if (!flag){
                        ans++;
                        flag = true;
                    }

                    arr[temp.x][temp.y-1] = 2;
                    temp.y--;
                    Q.add(new Cell(temp.x,temp.y));
                }
                Q.remove();

            }
            // Pop the delimiter
            Q.remove();

            // If oranges were rotten in current frame than separate the
            // rotten oranges using delimiter for the next frame for processing.
            if (!Q.isEmpty())
            {
                Q.add(new Cell(-1,-1));
            }

        }

        // Return -1 if all arranges could not rot, otherwise ans
        return (checkAll(arr))? -1: ans;

    }

    public static void main(String[] args) {

        int basket[][] = { {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        int ans = rotOranges(basket);
        if(ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + ans);

    }
}
