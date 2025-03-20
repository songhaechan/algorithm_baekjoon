import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        char[][] rgbMap = new char[n][n];
        char[][] rgMap = new char[n][n];
        visit = new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<n; j++){
                char color = line.charAt(j);
                rgbMap[i][j] = color;
                if(color == 'G'){
                    rgMap[i][j] = 'R';
                }else{
                    rgMap[i][j] = color;
                }
            }
        }

        int rgbCount = 0;
        int rgCount = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visit[i][j]) continue;
                bfs(new int[]{i,j},rgbMap);
                rgbCount++;
            }
        }

        visit = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visit[i][j]) continue;
                bfs(new int[]{i,j},rgMap);
                rgCount++;
            }
        }

        System.out.print(rgbCount + " " + rgCount);
    }

    public static void bfs(int[] start,char[][] map){
        Queue<int[]> q = new ArrayDeque();
        q.offer(start);
        visit[start[0]][start[1]] = true;
        char initColor = map[start[0]][start[1]];

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int x = cur[1] + dx[i];
                int y = cur[0] + dy[i];
                if(x<0 || x>=n || y<0 || y>=n) continue;
                if(map[y][x] != initColor || visit[y][x]) continue;
                visit[y][x] = true;
                q.offer(new int[]{y,x});
            }
        }
    }
}