import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int k;
    static long[] lan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        lan = new long[k];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            lan[i] = Integer.parseInt(st.nextToken());
        }

        Long s = 1L;
        Long e = 2400000000L;

        while(s<e){
            Long m = (s+e+1)/2;
            if(search(m)){
                s = m;
            }else{
                e = m-1;
            }
        }
        System.out.println(s);
    }

    public static boolean search(Long m){
        int cur = 0;
        for(int i=0; i<k; i++){
            cur += lan[i]/m;
        }
        return cur>=n;
    }
}