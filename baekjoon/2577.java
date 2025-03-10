import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Long sum = 1L;
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            sum *= Long.parseLong(st.nextToken());
        }

        String s = sum.toString();

        int[] result = new int[10];

        for(char c : s.toCharArray()){
            result[(int)c - 48] += 1;
        }

        for(int i : result){
            System.out.println(i);
        }
    }
}