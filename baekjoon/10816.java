import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] card = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);
        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int target = Integer.parseInt(st.nextToken());
            int u = upper(card,target);
            int l = lower(card,target);
            sb.append(u-l);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int lower(int[] card, int t){
        int s = 0;
        int e = card.length;
        while(s<e){
            int m = (s+e)/2;
            if(card[m] >= t){
                e = m;
            }else if(card[m] < t){
                s = m + 1;
            }
        }
        return s;
    }

    public static int upper(int[] card, int t){
        int s = 0;
        int e = card.length;
        while(s<e){
            int m = (s+e)/2;
            if(card[m] > t){
                e = m;
            }else if(card[m] <= t){
                s = m+1;
            }
        }
        return s;
    }
}