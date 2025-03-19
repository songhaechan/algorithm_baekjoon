import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int subin = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());

        int[] position = new int[100001];
        Arrays.fill(position,-1);

        Queue<Integer> q = new ArrayDeque();
        q.offer(subin);
        position[subin] = 0;

        while(position[sister] == -1){
            int cur = q.poll();
            for(int i=0; i<3; i++){
                int nCur = 0;
                if(i==0){
                    nCur = cur + 1;
                }
                if(i==1){
                    nCur = cur - 1;
                }
                if(i==2){
                    nCur = cur * 2;
                }

                if(nCur < 0 || nCur > 100000) continue;
                if(position[nCur] != -1) continue;
                position[nCur] = position[cur] + 1;
                q.offer(nCur);
            }
        }

        System.out.println(position[sister]);
    }
}