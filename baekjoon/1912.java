import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[100001];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            dp[i] = Math.max(0,dp[i-1]) + Integer.parseInt(st.nextToken());
        }
        Integer max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}