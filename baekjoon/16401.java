import java.util.*;
import java.io.*;

class Main {
    static int m;
    static int n;
    static long[] snack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        snack = new long[n];
        for(int i=0; i<n; i++){
            snack[i] = Long.parseLong(st.nextToken());
        }

        Long s = 1L;
        Long e = 1_000_000_000L;

        while(s<e){
            Long mid = (s+e+1)/2;
            if(search(mid)){
                s= mid;
            }else{
                e = mid-1;
            }
        }

        System.out.println(s);

    }
    public static boolean search(long mid){
        int cur = 0;
        for(int i=0; i<n; i++){
            cur += snack[i]/mid;
        }
        return cur>=m;
    }
}