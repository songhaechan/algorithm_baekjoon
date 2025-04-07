import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        long[] arr = new long[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Long.parseLong(st.nextToken())+arr[i-1];
        }
        Integer result = Integer.MAX_VALUE;
        for(int i=0; i<=n; i++){
            int idx = lower(arr,s+arr[i]);
            if(idx == n) continue;
            if(Math.abs(arr[idx]-arr[i]) == s){
                result = Math.min(Math.abs(idx-i),result);
            }
        }
        if(result == Integer.MAX_VALUE) result = 0;
        System.out.println(result);
    }
    public static int lower(long[] arr,long target){
        int s = 0;
        int e = arr.length;
        while(s<e){
            int m = (s+e)/2;
            if(arr[m]>=target){
                e=m;
            }else if(arr[m]<target){
                s = m+1;
            }
        }
        return s;
    }
}