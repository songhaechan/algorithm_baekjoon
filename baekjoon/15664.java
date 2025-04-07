import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr= new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backtrack(arr,1,new ArrayList(),0);

        System.out.println(sb.toString());
        
    }

    public static void backtrack(int[] arr,int depth,List<Integer> list,int start){
        if(depth > m){
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i));
                sb.append(" ");
            }
            sb.append('\n');
            return;
        }
        int pre = 0;
        for(int i=start; i<n; i++){
            if(pre == arr[i]) continue;
            list.add(arr[i]);
            pre = arr[i];
            backtrack(arr,depth+1,list,i+1);
            list.remove(list.size()-1);
        }
    }
}