public class BackTracking {

    public static void permutationOfString(String string,String remaining){
        if (string.length() == 0)
            System.out.print(remaining+ " ");

        for (int i=0;i<string.length();i++){
            String newString = remaining + string.charAt(i);
            String remainingString = string.substring(0,i) +
                    string.substring(i+1);

            permutationOfString(remainingString,newString);

        }

    }

    public static void permute(String string){
        permutationOfString(string,"");
    }


    public static void stringNotContainingAString(String str, int l, int r){
    //GFG Solution
        if(l==r){
            if(!str.contains("AB")){
                System.out.print(str+" ");
            }
        }else{
            for(int i=l;i<=r;i++){
                if(isSafe(str,l,i,r)){//BackTracking Solution !!
                    str=new String(swap(str, i, l));
                    stringNotContainingAString(str,l+1,r);
                    str=new String(swap(str, i, l));}
            }
        }
    }
    public static boolean isSafe(String str,int l, int i, int r){
        if(l!=0 && str.charAt(l-1)=='A' && str.charAt(i)=='B')
            return false;
        if(r==(l+1) && str.charAt(i)=='A' && str.charAt(l)=='B')
            return false;
        return true;
    }

    public static char[] swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return ch;
    }


    public static void lexicographic(char[] chars, String res) {
        if (res.length() == chars.length) {
            System.out.print(res + " ");
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            while (i + 1 < chars.length && chars[i] == chars[i + 1])
                i++;

            lexicographic(chars, res + chars[i]);
        }
    }


    public static void stringNotContainingAString(String string,
                                                  String result
                                                  ,String compare){

        if (string.length() == 0){
            if (!result.contains(compare)) {
                System.out.print(result+" ");
            }
        }else{
            if (!result.contains(compare)){//BackTracking Condition ;D
                for (int i=0;i<string.length();i++) {
                    String newResult = result + string.charAt(i);
                    String remainingString = string.substring(0, i) +
                            string.substring(i + 1);

                    stringNotContainingAString(remainingString, newResult, compare);
                }
            }
        }
    }




    static int N;

    static void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print( " " + sol[i][j] + " ");
            System.out.println();
        }
    }

    static boolean isSafe( int maze[][], int i, int j) {
        return (i < N && j < N && maze[i][j] == 1);
    }

    static boolean solveMaze(int maze[][]) {
        int sol[][] = new int[N][N];

        if (!solveMazeRec(maze, 0, 0, sol)) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    static boolean solveMazeRec(int[][] maze, int i, int j, int[][] sol) {
        if (i == N - 1 && j == N - 1 && maze[i][j] == 1) {
            sol[i][j] = 1;
            return true;
        }

        if (isSafe(maze, i, j)) {
            sol[i][j] = 1;

            if (solveMazeRec(maze, i + 1, j, sol))
                return true;

            if (solveMazeRec(maze, i, j + 1, sol))
                return true;

            sol[i][j] = 0;
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] maze = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        N = maze.length;
        solveMaze(maze);
    }
}
