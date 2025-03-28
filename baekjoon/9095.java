import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] dp = new int[n+1];
if (n >= 1) dp[1] = 1;
    if (n >= 2) dp[2] = 2;
    if (n >= 3) dp[3] = 4;
            if(n<=3){
                sb.append(dp[n]);
                sb.append('\n');
                continue;
            }
            for(int j=4; j<=n; j++){
                dp[j] += (dp[j-1] + dp[j-2] + dp[j-3]);
            }
            sb.append(dp[n]);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}