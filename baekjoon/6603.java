import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        
        while(n !=0 ){
            int[] lotto = new int[n];
            for(int i=0; i<n; i++){
                lotto[i] = Integer.parseInt(st.nextToken());
            }
            backtrack(lotto,0,1,new ArrayList());
            sb.append(" ");
            sb.append('\n');
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb.toString());
    }
    public static void backtrack(int[] lotto,int start, int depth, List<Integer> list){
        if(depth > 6){
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i));
                sb.append(" ");
            }
            sb.append('\n');
            return;
        }
        for(int i=start; i<n; i++){
            list.add(lotto[i]);
            backtrack(lotto,i+1,depth+1,list);
            list.remove(list.size()-1);
        }
    }
}