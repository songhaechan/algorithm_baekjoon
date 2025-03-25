import java.util.*;
import java.io.*;

class Main {
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        combination(n,m,new ArrayList());
        System.out.println(result.toString());
    }

    public static void combination(int n, int m,List<Integer> list){
        if(m == 0){
            for(int i=0; i<list.size();i++){
                result.append(list.get(i));
                result.append(" ");
            }
            result.append('\n');
            return;
        }
        for(int i=1; i<=n; i++){
            if(list.contains(i)) continue;
            list.add(i);
            combination(n,m-1,list);
            list.remove(new Integer(i));
        }
    }
}