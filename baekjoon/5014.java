import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] building = new int[f+1];
        Arrays.fill(building,-1);
        building[s] = 0;

        Queue<Integer> q = new ArrayDeque();
        q.offer(s);

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0; i<2; i++){
                int nc = 0;
                if(i==0) nc = cur + u;
                if(i==1) nc = cur - d;

                if(nc>f || nc<1) continue;
                if(building[nc] != -1) continue;
                // System.out.println(building[nc]);
                building[nc] = building[cur] + 1;
                // System.out.println(building[nc]);
                q.offer(nc);
            }
        }
        // for(int i=0; i<f+1; i++){
        //     System.out.print(building[i]);
        // }   

        if(building[g] == -1){
            System.out.println("use the stairs");
        }else{
            System.out.println(building[g]);
        }
    }
}