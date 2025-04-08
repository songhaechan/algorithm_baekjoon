import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());
        long[] tri = new long[101];
        tri[1] = 1;
        tri[2] = 1;
        tri[3] = 1;

        for(int i=4; i<101; i++){
            tri[i] = tri[i-2] + tri[i-3];
        }

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(tri[n]);
        }
    }
}