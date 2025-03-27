import java.util.*;
import java.io.*;

class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static boolean[][] visit;
    static int n;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,map[i][j]);
                min = Math.min(min,map[i][j]);
            }
        }
        int result = 1;
        for(int h=min; h<=max; h++){
            visit= new boolean[n][n];
            int count =0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(visit[i][j] || map[i][j] <= h) continue;
                    count++;
                    bfs(new int[]{i,j},h);
                }
            }
            result = Math.max(result,count);
        }
        System.out.println(result);
    }

    public static void bfs(int[] start, int height){
        Queue<int[]> q= new ArrayDeque();
        q.offer(start);
        visit[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(visit[ny][nx] || map[ny][nx] <= height) continue;
                visit[ny][nx] = true;
                q.offer(new int[]{ny,nx});
            }
        }
    }
}