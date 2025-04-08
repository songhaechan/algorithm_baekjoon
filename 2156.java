import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[10001];
        int[] arr = new int[10001];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-3]+arr[i]+arr[i-1],Math.max(dp[i-2]+arr[i],dp[i-1]));
        }

        Integer max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            max = Math.max(dp[i],max);
        }

        System.out.println(max);
    }
}