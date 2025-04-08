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

        int[] dp = new int[n];
        int[] pre = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = 1;
        }

        Arrays.fill(pre,-1);

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    pre[i] = j;
                }
            }
        }

        Integer result = dp[0];
        int maxIdx = 0;

        for(int i=0; i<n; i++){
            if(dp[i]>result){
                result = dp[i];
                maxIdx = i;
            }
        }
        sb.append(result);
        sb.append('\n');

        List<Integer> tmp = new ArrayList();

        while(maxIdx != -1){
            tmp.add(arr[maxIdx]);
            maxIdx = pre[maxIdx];
        }

        Collections.reverse(tmp);

        for(int i=0; i<tmp.size(); i++){
            sb.append(tmp.get(i));
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}