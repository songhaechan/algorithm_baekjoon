import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] lope = new int[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            lope[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lope);

        Integer max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            max = Math.max((n-i)*lope[i],max);
        }

        System.out.println(max);

    }
}