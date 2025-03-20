import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long a  = Long.parseLong(st.nextToken());
        long b  = Long.parseLong(st.nextToken());
        long c  = Long.parseLong(st.nextToken());

        System.out.print(multi(a,b,c));
    }

    public static long multi(long a, long b, long c){
        if(b == 1) return a % c;
        long val = multi(a,b/2,c);
        val  = val * val % c;
        if(b%2 == 0){
            return val;
        }
        return val * a % c;
    }
}