public class SudokuProblem {


    public static boolean isSafe(int[][] board,int row, int col, int num) {
        for (int d = 0; d < board.length; d++)
            if (board[row][d] == num)
                return false;


        for (int r = 0; r < board.length; r++)
            if (board[r][col] == num)
                return false;



        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++)
            for (int d = boxColStart; d < boxColStart + sqrt; d++)
                if (board[r][d] == num)
                    return false;

        return true;
    }

    public static boolean solveSudoku(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }

            if (!isEmpty) break;
        }

        if (isEmpty) return true;

        for (int num = 1; num <= n; num++)
        {
            if (isSafe(board, row, col, num))
            {
                board[row][col] = num;
                if (solveSudoku(board, n))
                {
                    // print(board, n);
                    return true;
                }
                else
                {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(int[][] board, int N)
    {
        for (int r = 0; r < N; r++)
        {
            for (int d = 0; d < N; d++)
            {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)Math.sqrt(N) == 0)
            {
                System.out.print("");
            }
        }
    }

    public static void main(String args[])
    {

        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        int N = board.length;

        if (solveSudoku(board, N))
        {
            print(board, N);
        }
        else {
            System.out.println("No solution");
        }
    }
//
//    public static boolean isSafe(int i,int j,int n){
//
//        for (int k=0;k< N;k++)
//            if (board[i][k] == n || board[j][k] == n)
//                return false;
//
//        //Searching in the NxN Grid for same Elements.
//
//        int size = (int) Math.sqrt(N);
//
//        int rs = i - i%size;//Starting row index of that Grid
//        int cs = j - j%size;//Starting column index of that Grid
//
//        for (int p=0;p< size;p++)
//            for (int q=0;q < size ;q++)
//                if (board[p + rs][q + cs] == n)
//                    return false;
//
//
//        return true;
//    }
//
//
//    public static boolean solveRec(){
//
//
//        int i,j = 0;
//        for ( i=0;i< N;i++)
//            for ( j=0;j< N;j++)
//                if (board[i][j] == 0)
//                    break;
//
//
//        if (i == N && j == N)
//            return true;
//
//        //Assigning all numbers and Checking whether they can Satisfy Condition
//        for (int n = 1; n <= N; n++){
//            if (isSafe(i,j,n)){
//                board[i][j] =n;
//
//                if (solveRec())
//                    return true;
//
//                board[i][j] = 0;
//            }
//        }
//        return false;
//    }
//
//
//    public static void solve(){
//        if (!solveRec())
//            System.out.println("No Solution Available");
//        else{
//            printBoard();
//        }
//
//    }
//
//    public static void printBoard(){
//        for (int[] ints : board)
//            for (int j = 0; j < board[0].length; j++) {
//                System.out.print(ints[j] + " ");
//            }
//        System.out.println();
//    }
//
////    public static int N = 4;
////    public static int[][] board = new int[N][N];
//
//   public static int[][] board = new int[][] {
//            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
//            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
//            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
//            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
//            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
//            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
//            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
//            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
//            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
//    };
//    static int N = board.length-1;
//    public static void main(String[] args) {
//        solve();
//
//    }
}
