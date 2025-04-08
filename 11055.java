import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            dp[i] = arr[i];
            for(int j=0; j<n; j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[j]+arr[i],dp[i]);
                }
            }
        }

        Integer result = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            result = Math.max(dp[i],result);   
        }

        System.out.println(result);
    }
}