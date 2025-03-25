import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static StringBuilder sb;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        seq(new ArrayList(),0,new HashSet());
        System.out.println(sb.toString());
    }

    public static void seq(List<Integer> tmp,int start,Set<Integer> set){
        if(tmp.size() == m){
            tmp.forEach(a->{
                sb.append(a);
                sb.append(" ");
            });
            sb.append('\n');
            return;
        }
        for(int i=0; i<n; i++){
            tmp.add(arr[i]);
            seq(tmp,i+1,set);
            tmp.remove(tmp.size()-1);
        }
    }
}