import java.util.*;
import java.io.*;

class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n;
    static int m;
    static Queue<int[]> q = new ArrayDeque();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        boolean[][] visit = new boolean[n][m];
        Integer[][] box = new Integer[n][m];
        int tmp = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                int tomato = Integer.parseInt(st.nextToken());
                if(tomato == 0){
                    tmp++;
                }
                if(tomato == 1){
                    q.offer(new int[]{i,j});
                }
                box[i][j] = tomato;
            }
        }
        if(tmp == 0){
            System.out.println(0);
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(box[i][j] == 0){
                    box[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(box[i][j] == 1){
                    bfs(new int[]{i,j},visit,box);
                }
            }
        }
        Integer result = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(box[i][j] == Integer.MAX_VALUE){
                    System.out.println(-1);
                    return;
                }
                if(box[i][j] == -1) continue;
                result = Math.max(result,box[i][j]);
            }
        } 
        System.out.println(result-1);
    
    }

    public static void bfs(int[] start,boolean[][] visit,Integer[][] box){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int x = cur[1] + dx[i];
                int y = cur[0] + dy[i];

                if(x<0 || x>=m || y<0 || y>=n) continue;
                if(visit[y][x] || box[y][x] == -1 || box[y][x] == 1) continue;
                visit[y][x] = true;
                box[y][x] = Math.min(box[cur[0]][cur[1]] + 1,box[y][x]);
                q.offer(new int[]{y,x});
            }
        }
    }
}