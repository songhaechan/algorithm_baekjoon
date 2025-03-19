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

        int[][] picture = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visit = new boolean[n][m];
        int count = 0;
        Integer max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visit[i][j] || picture[i][j] == 0) continue;
                count++;
                max = Math.max(bfs(new int[]{i,j},visit,picture),max);
            }
        }

        System.out.println(count);
        System.out.println(count == 0 ? 0 : max);
    }

    public static int bfs(int[] start,boolean[][] visit,int[][] picture){
        Queue<int[]> q = new ArrayDeque();
        visit[start[0]][start[1]] = true;
        q.offer(start);

        int count = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            count++;
            for(int i=0; i<4; i++){
                int x = cur[1] + dx[i];
                int y = cur[0] + dy[i];

                if(x<0 || x>=m || y<0 || y>=n) continue;
                if(visit[y][x] || picture[y][x] == 0) continue;
                visit[y][x] = true;
                q.offer(new int[]{y,x});
            }
        }
        return count;
    }
}