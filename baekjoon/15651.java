import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seq(new ArrayList(),0);
        System.out.println(sb.toString());
    }

    public static void seq(List<Integer> tmp,int start){
        if(tmp.size() == m){
            tmp.forEach(a->{
                sb.append(a);
                sb.append(" ");
            });
            sb.append('\n');
            return;
        }
        for(int i=start; i<n; i++){
            Integer e = new Integer(i+1);
            tmp.add(e);
            seq(tmp,start);
            tmp.remove(tmp.size()-1);
        }
    }
}