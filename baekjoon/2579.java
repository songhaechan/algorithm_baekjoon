import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] stair = new int[n+1];
        int[][] dp = new int[2][n+1];
        
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            stair[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = stair[1];
        dp[1][1] = 0;
        
        for(int i=2; i<=n; i++){
            dp[0][i] = Math.max(dp[1][i-2],dp[0][i-2])+stair[i];
            dp[1][i] = dp[0][i-1]+stair[i];
        }

        System.out.println(Math.max(dp[0][n],dp[1][n]));
    }
}