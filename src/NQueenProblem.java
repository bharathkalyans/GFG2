
public class NQueenProblem {

    static final int N = 20;
    static int[][] board =new  int[N][N];


    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

    static boolean isSafe(int row, int col) {
        int i, j;

        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    static boolean solveRec(int col) {
        if (col == N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;

                if (solveRec(col + 1))
                    return true;

                board[i][col] = 0;
            }
        }
        return false;
    }

    static void solve() {

        if (!solveRec(0)) {
            System.out.print("Solution does not exist");
            return;
        }

        printSolution(board);
    }

    public static void main(String[] args) {
        solve();
    }
}
