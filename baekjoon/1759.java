import java.util.*;
import java.io.*;

class Main {
    static int L;
    static int C;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[] alpha = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            alpha[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpha);

        backtrack(alpha,1,new ArrayList(),0,0,0);

        System.out.println(sb.toString());

    }
    public static void backtrack(char[] alpha,int depth,List<Character> list,int vowels,int consonants,int start){
        if(depth==L+1 && vowels>=1 && consonants>=2){
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i));
            }
            sb.append('\n');
            return;
        }

        for(int i=start; i<C; i++){
            if(isVowels(alpha[i])){
                vowels += 1;
            }else{
                consonants += 1;
            }
            list.add(alpha[i]);
            backtrack(alpha,depth+1,list,vowels,consonants,i+1);
            list.remove(list.size()-1);
            if(isVowels(alpha[i])){
                vowels -= 1;
            }else{
                consonants -= 1;
            }
        }
    }

    public static boolean isVowels(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}