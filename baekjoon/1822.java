import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());
        int[] a = new int[aSize];
        int[] b = new int[bSize];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<aSize; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<bSize; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        Arrays.sort(b);
        Arrays.sort(a);
        for(int i=0; i<aSize; i++){
            int result = bs(b,a[i]);
            if(result == -1){
                count++;
                sb.append(a[i]);
                sb.append(" ");
            }
        }

        System.out.println(count);
        System.out.println(sb.toString());
    }

    public static int bs(int[] arr, int t){
        int s = 0;
        int e = arr.length-1;

        while(s<=e){
            int m = (s+e)/2;
            if(arr[m] > t){
                e = m - 1;
            }else if(arr[m] < t){
                s = m+1;
            }else{
                return m;
            }
        }
        return -1;
    }
}