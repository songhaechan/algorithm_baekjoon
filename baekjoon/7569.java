import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] map = new int[h][n][m];
        int[] dx = {1,-1,0,0,0,0};
        int[] dy = {0,0,1,-1,0,0};
        int[] dz = {0,0,0,0,1,-1};

        Queue<int[]> q = new ArrayDeque();

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1) {
                        q.offer(new int[]{i,j,k});
                    }
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<6; i++){
                int nz = cur[0] + dz[i];
                int ny = cur[1] + dy[i];
                int nx = cur[2] + dx[i];
                if(nz<0 || nz>=h || nx<0 || nx>=m || ny<0 || ny>=n) continue;
                if(map[nz][ny][nx] == -1 || map[nz][ny][nx] >= 1) continue;
                map[nz][ny][nx] = map[cur[0]][cur[1]][cur[2]] + 1;
                q.offer(new int[]{nz,ny,nx});
            }
        }
        Integer result = Integer.MIN_VALUE;
        boolean failed = false;
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(map[i][j][k] == -1) continue;
                    if(map[i][j][k] == 0) failed = true;
                    result = Math.max(result,map[i][j][k]);
                }
            }
        }

        if(failed){
            System.out.print(-1);
        }else{
                    System.out.println(result-1);
        }

    }
}