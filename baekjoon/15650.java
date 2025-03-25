import java.util.*;
import java.io.*;

class Main {
    static int m;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seq(n,new ArrayList(),0);
        System.out.println(sb.toString());

    }

    public static void seq(int n, List<Integer> tmp,int start){
        if(tmp.size() == m){
            tmp.forEach(a->{
                sb.append(a);
                sb.append(" ");});
            sb.append('\n');
        }
        for(int i=start; i<n; i++){
            Integer e = new Integer(i+1);
            tmp.add(e);
           seq(n,tmp,i+1); 
           tmp.remove(tmp.size()-11);
        }
    }
}