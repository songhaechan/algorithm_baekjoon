import java.util.*;
import java.io.*;

class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static boolean[][] visit;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visit = new boolean[m][n];

        List<Integer> result = new ArrayList();
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            for(int j=m-ry; j<=m-ly-1; j++){
                for(int z=lx; z<=rx-1; z++){
                    map[j][z] = 1;
                }
            }
        }

        for(int j=0; j<m; j++){
            for(int z=0; z<n; z++){
                if(map[j][z] == 1 || visit[j][z]) continue;
                result.add(bfs(new int[]{j,z},0));
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i));
            System.out.print(" ");
        }
    }

    public static int bfs(int[] start, int count){
        Queue<int[]> q= new ArrayDeque();
        q.offer(start);
        count++;
        visit[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(visit[ny][nx] || map[ny][nx] == 1) continue;
                visit[ny][nx] = true;
                count++;
                q.offer(new int[]{ny,nx});
            }
        }
        return count;
    }
}