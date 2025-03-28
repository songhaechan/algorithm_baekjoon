import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n+1];
        int[] pre = new int[n+1];
        dp[1] = 0;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + 1;
            pre[i] = i-1;
            if(i%2==0){
                dp[i] = Math.min(dp[i],dp[i/2]+1);
                pre[i] = i/2;
            }
            if(i%3==0){
                dp[i] = Math.min(dp[i],dp[i/3]+1);
                pre[i] = i/3;
            }
        }
        System.out.println(dp[n]);
        int cur = n;
        while(true){
            System.out.print(cur);
            System.out.print(" ");
            if(cur==1) break;
            cur = pre[cur];
        }
    }
}