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
                str=new String(swap(str, i, l));

                stringNotContainingAString(str,l+1,r);

                str=new String(swap(str, i, l));
            }
        }
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
        }

        for (int i=0;i<string.length();i++){
            String newResult = result + string.charAt(i);
            String remainingString = string.substring(0,i) +
                    string.substring(i+1);

            stringNotContainingAString(remainingString,newResult,compare);

        }
    }



    public static void main(String[] args) {

        System.out.println("Normal Permutation");
        permute("ABC");
        System.out.println();

        System.out.println("GFG Solution");
        stringNotContainingAString("ABC",0,2);

        System.out.println();
        System.out.println("My Own Solution");
        stringNotContainingAString("ABC","","AB");
    }
}
