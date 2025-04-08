import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long[] fib = new long[91];

        int n = Integer.parseInt(st.nextToken());

        fib[0] = 0L;
        fib[1] = 1L;

        for(int i=2; i<91; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }

        System.out.println(fib[n]);
    }
}