import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String s = st.nextToken();
        char[] sArr = s.toCharArray();
        int[] result = new int[10];


        for(int i=0; i<s.length(); i++){
            result[(int)sArr[i] - 48] += 1;
        }

        Integer max = Integer.MIN_VALUE;

        for(int i=0; i<result.length; i++){
            if(i==6 || i==9) continue;
            if(max<result[i]){
                max = result[i];
            }
        }
        int sixAndNine = (int)Math.ceil((double)(result[6] + result[9])/2.0);

        System.out.println(max>sixAndNine ? max : sixAndNine);

    }
}