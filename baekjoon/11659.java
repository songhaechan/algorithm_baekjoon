import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[n+1];
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1]+arr[i];
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[b]-dp[a-1]);
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}