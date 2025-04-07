import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int s = 0;
        int e = 0;

        Long result = Long.MAX_VALUE;

        while(e<n && s<n){
            if(arr[e]-arr[s]<m){
                e++;
            }else if(arr[e]-arr[s]>=m){
                result = Math.min(result,arr[e]-arr[s]);
                s++;
            }
        }

        System.out.println(result);

    }

    public static int lower(long target,long[] arr){
        int s=0;
        int e=arr.length;

        while(s<e){
            int m = (s+e)/2;
            if(arr[m]>=target){
                e = m;
            }else if(arr[m]<target){
                s = m+1;
            }
        }
        return s;
    }
}