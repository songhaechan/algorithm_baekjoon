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

        Arrays.sort(arr);
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int target = Integer.parseInt(st.nextToken());
            sb.append(bs(arr,target));
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public static int bs(int[] arr, int t){
        int s = 0;
        int e = arr.length-1;

        while(s<=e){
            int mid = (s+e)/2;
            if(arr[mid] == t){
                return 1;
            }else if(arr[mid] > t){
                e = mid -1;
            }else{
                s = mid + 1;
            }
        }
        return 0;
    }
}