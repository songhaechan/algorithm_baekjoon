import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[][] tri = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = tri[1][1];

        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                if(j==1){
                    dp[i][j] = dp[i-1][j] + tri[i][j];
                }
                if(j==i){
                    dp[i][j] = dp[i-1][j-1] + tri[i][j];
                }
                dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + tri[i][j];
            }
        }

        Arrays.sort(dp[n]);
        System.out.println(dp[n][n]);


    }
}