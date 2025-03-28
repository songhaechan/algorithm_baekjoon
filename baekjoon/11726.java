import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n+1];

        if(n>=1) dp[1] = 1;
        if(n>=2) dp[2] = 2;
        if(n<=2){
            System.out.println(dp[n]);
            return;
        }

        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1]+dp[i-2])%10007;
        }

        System.out.println(dp[n]);
    }
}