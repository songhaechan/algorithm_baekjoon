import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        long[][] dp = new long[2][91];

        dp[0][1] = 0L;
        dp[1][1] = 1L;

        dp[0][2] = 1L;
        dp[1][2] = 0L;

        for(int i=3; i<=n; i++){
            dp[0][i] = dp[1][i-1] + dp[0][i-1];
            dp[1][i] = dp[0][i-1];
        }

        System.out.println(dp[0][n]+dp[1][n]);
    }
}