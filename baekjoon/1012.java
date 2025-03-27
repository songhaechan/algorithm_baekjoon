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

        int t = Integer.parseInt(st.nextToken());
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visit = new boolean[n][m];
            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            int count = 0;
            for(int a=0; a<n; a++){
                for(int b=0; b<m; b++){
                    if(map[a][b] == 1 && visit[a][b] == false){
                        bfs(new int[]{a,b});
                        count++;
                    }
                }
            }
            sb.append(count); sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void bfs(int[] start){
        Queue<int[]> q = new ArrayDeque();
        q.offer(start);
        visit[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
                if(visit[ny][nx] || map[ny][nx] == 0) continue;
                visit[ny][nx] = true;
                q.offer(new int[]{ny,nx});
            }
        }
    }
}