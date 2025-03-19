import java.util.*;
import java.io.*;

class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean[][] visit = new boolean[n][m];
        int[][] maze = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<m; j++){
                maze[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        bfs(new int[]{0,0},visit,maze);
        System.out.println(maze[n-1][m-1]);
    }

    public static void bfs(int[] start,boolean[][] visit,int[][] maze){
        Queue<int[]> q = new ArrayDeque<>();
        visit[start[0]][start[1]] = true;
        q.offer(start);

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int x = cur[1] + dx[i];
                int y = cur[0] + dy[i];

                if(x<0 || x>=m || y<0 || y>=n) continue;
                if(visit[y][x] || maze[y][x] == 0) continue;
                visit[y][x] = true;
                maze[y][x] = maze[cur[0]][cur[1]] + 1;
                q.offer(new int[]{y,x});
            }
        }
    }
}