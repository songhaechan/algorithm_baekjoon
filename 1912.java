import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = arr[0];

        for(int i=1; i<n; i++){
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
        }

        Integer result = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            result = Math.max(result,dp[i]);
        }

        System.out.println(result);
    }
}