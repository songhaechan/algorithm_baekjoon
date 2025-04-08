import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int total = arr[0];
        int result = 0;

        while(s<n && e<n){
            if(total == m){
                result++;
            }
            if(total <= m){
                e++;
                if(e!=n){
                    total += arr[e];
                }
            }else if(total > m){
                total -= arr[s++];
            }
            if(e>=n){
                break;
            }
        }
        System.out.println(result);
    }
}