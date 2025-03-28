import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[][] dp = new int[3][n+1];
        int[][] rgb = new int[3][n+1];
        st = new StringTokenizer(br.readLine());
        //R
        dp[0][1] = Integer.parseInt(st.nextToken());
        //G
        dp[1][1] = Integer.parseInt(st.nextToken());
        //B
        dp[2][1] = Integer.parseInt(st.nextToken());
        for(int i=2; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            //R
            rgb[0][i] = Integer.parseInt(st.nextToken());
            //G
            rgb[1][i] = Integer.parseInt(st.nextToken());
            //B
            rgb[2][i] = Integer.parseInt(st.nextToken());
        }

        for(int i=2; i<=n; i++){
            dp[0][i] = Math.min(dp[1][i-1],dp[2][i-1])+rgb[0][i];
            dp[1][i] = Math.min(dp[2][i-1],dp[0][i-1])+rgb[1][i];
            dp[2][i] = Math.min(dp[0][i-1],dp[1][i-1])+rgb[2][i];  
        }

        System.out.println(Math.min(dp[0][n],Math.min(dp[1][n],dp[2][n])));
    }
}