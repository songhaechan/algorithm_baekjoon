import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[101][10];

        for(int i=1; i<10; i++){
            dp[1][i] = 1L;
        }

        int n = Integer.parseInt(st.nextToken());
        long mod = 1_000_000_000;

        for(int i=2; i<101; i++){
            dp[i][0] += dp[i-1][1]%mod;
            dp[i][9] += dp[i-1][8]%mod;
            for(int j=1; j<9; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%mod;
            }
        }

        long result = 0;
        for(int i=0; i<10; i++){
            result = (result + dp[n][i])%mod;
        }

        System.out.print(result);
    }
}