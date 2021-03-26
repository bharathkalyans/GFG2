import java.util.Arrays;

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

    public static void main(String[] args) {

        permute("ABC");
        System.out.println();
    }
}
