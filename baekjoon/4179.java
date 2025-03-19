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
        char[][] maze = new char[n][m];
        int[][] fDist = new int[n][m];
        int[][] jDist = new int[n][m];
        Queue<int[]> fq = new ArrayDeque();
        Queue<int[]> jq = new ArrayDeque();

        for(int i=0; i<n; i++){
            Arrays.fill(fDist[i],-1);
            Arrays.fill(jDist[i],-1);
        }

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<m; j++){
                char p = line.charAt(j);
                maze[i][j] = line.charAt(j);
                if(p == 'J') {
                    jq.offer(new int[]{i,j});
                    jDist[i][j] = 0;
                }
                if(p == 'F') {
                    fq.offer(new int[]{i,j});
                    fDist[i][j] = 0;
                }
            }
        }

        while(!fq.isEmpty()){
            int[] cur = fq.poll();
            // fire
            for(int i=0; i<4; i++){
                int x = cur[1] + dx[i];
                int y = cur[0] + dy[i];
                if(x<0 || x>=m || y<0 || y>=n) continue;
                if(fDist[y][x] >=0 ||  maze[y][x] == '#') continue;
                fDist[y][x] = fDist[cur[0]][cur[1]]+1;
                fq.offer(new int[]{y,x});
            }
        }
        int count = 0;
        while(!jq.isEmpty()){
            int[] cur = jq.poll();
            // fire
            for(int i=0; i<4; i++){
                int x = cur[1] + dx[i];
                int y = cur[0] + dy[i];
                if(x<0 || x>=m || y<0 || y>=n){
                    System.out.print(jDist[cur[0]][cur[1]]+1);
                    return;
                }
                if(jDist[y][x] >=0 || maze[y][x] == '#') continue;
                if(jDist[cur[0]][cur[1]] + 1 >= fDist[y][x] && fDist[y][x] != -1) continue;
                jDist[y][x] = jDist[cur[0]][cur[1]]+1;
                jq.offer(new int[]{y,x});
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}