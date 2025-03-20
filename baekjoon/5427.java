import java.util.*;
import java.io.*;

class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int h;
    static int w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(st.nextToken());

        for(int i=0; i<testCase; i++){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            char[][] map = new char[h][w];

            int[][] fDist = new int[h][w];
            int[][] sDist = new int[h][w];
            for(int j=0; j<h; j++){
                Arrays.fill(fDist[j],-1);
                Arrays.fill(sDist[j],-1);
            }
            Queue<int[]> fq = new ArrayDeque();
            Queue<int[]> sq = new ArrayDeque();
            for(int j=0; j<h;j++){
                st = new StringTokenizer(br.readLine());
                String line = st.nextToken();
                for(int k=0; k<w; k++){
                    char point = line.charAt(k);
                    if(point == '@'){
                        sq.offer(new int[]{j,k});
                        sDist[j][k] = 0;
                    }
                    if(point == '*'){
                        fq.offer(new int[]{j,k});
                        fDist[j][k] = 0;
                    }
                    map[j][k] = point;
                }
            }
            // 초기화 끝

            //불 bfs
            while(!fq.isEmpty()){
                int[] cur = fq.poll();
                for(int j=0; j<4; j++){
                    int x = cur[1] + dx[j];
                    int y = cur[0] + dy[j];
                    if(x<0 || x>=w || y<0 || y>=h) continue;
                    if(map[y][x] == '#' || fDist[y][x] >= 0) continue;
                    fDist[y][x] = fDist[cur[0]][cur[1]] + 1;
                    fq.offer(new int[]{y,x});
                }                
            }

            boolean possible = false;

            //상근이 bfs
            while(!sq.isEmpty()){
                int[] cur = sq.poll();
                for(int j=0; j<4; j++){
                    int x = cur[1] + dx[j];
                    int y = cur[0] + dy[j];
                    if(x<0 || x>=w || y<0 || y>=h){
                        sb.append(sDist[cur[0]][cur[1]] + 1);
                        sb.append('\n');
                        possible = true;
                        break;
                    }
                    if(map[y][x] == '#' || sDist[y][x] >= 0) continue;
                    if(sDist[cur[0]][cur[1]] + 1 >= fDist[y][x] && fDist[y][x] != -1) continue;
                    sDist[y][x] = sDist[cur[0]][cur[1]] + 1;
                    sq.offer(new int[]{y,x});
                }
                if(possible){
                    break;
                }
            }
            if(!possible){
                sb.append("IMPOSSIBLE");
                sb.append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}