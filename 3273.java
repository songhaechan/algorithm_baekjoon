import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());

        Arrays.sort(num);

        int l = 0;
        int r = n-1;
        int count= 0;

        while(l<r){
            if(num[l]+num[r] == target){
                count++;
                r--;
                continue;
            }

            if(num[l]+num[r] > target){
                r--;
            }else{
                l++;
            }

        }

        System.out.print(count);
    }
}