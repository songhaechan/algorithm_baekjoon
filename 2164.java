import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new ArrayDeque();

        int n = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++){
            q.offer(i);
        }

        while(q.size() != 1){
            q.poll();
            int tmp = q.poll();
            q.offer(tmp);
        }

        System.out.print(q.peek());
    }
}