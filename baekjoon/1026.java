import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a,Collections.reverseOrder());
        Arrays.sort(b);

        int sum = 0;

        for(int i=0; i<n; i++){
            sum += a[i] * b[i];
        }

        System.out.println(sum);
    }
}