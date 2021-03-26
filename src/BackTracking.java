public class BackTracking {

    public static void permutationOfString(String string,String remaining){
        if (string.length() == 0)
            System.out.println(remaining);

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


    public static void main(String[] args) {

        permute("ABC");
    }
}
