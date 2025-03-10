import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String S = st.nextToken();
        int[] result = new int[26];

        char[] sArray = S.toCharArray();

        for(char a : sArray){
            result[(int)a - 97] += 1;
        }

        for(int i=0; i<result.length; i++){
            sb.append(result[i]);
            sb.append(" ");
        }

        System.out.print(sb.toString());
    }
}