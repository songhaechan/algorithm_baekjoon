import java.util.*;
import java.io.*;

class Main {
    static int s;
    static int n;
    static int start;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int positiveCount = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > 0) positiveCount++;
        }

        Arrays.sort(arr);

        for(int i=0; i<n; i++){
            if(arr[i] > 0){
                start = i;
                break;
            }
        }

        for(int size=0; size<=positiveCount; size++){
            subset(arr,size,0,0,start);
            // System.out.println("----");
        }

        System.out.println(count);
    }

    public static void subset(int[] arr,int size, int depth, int sum,int idx){
        if(size == depth){
            if(sum == s) count++;
            return;
        }
        for(int i=idx; i<n; i++){
            sum += arr[i];
            // System.out.println(sum);
            subset(arr,size,depth+1,sum,i+1);
            sum -= arr[i];
        }
    }
}