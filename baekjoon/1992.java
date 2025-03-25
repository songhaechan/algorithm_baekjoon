import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        // if(check(n,0,0)){
        //     System.out.println(map[0][0]);
        // }

        recursion(n,0,0);
        System.out.println(sb.toString());
    }

    public static void recursion(int n, int x, int y){
        if(check(n,x,y)){
            sb.append(map[x][y]);
        }else{
            sb.append('(');
            int newN = n/2;
            for(int i=0; i<2; i++){
                for(int j=0; j<2; j++){
                    recursion(newN,x+i*newN,y+j*newN);
                }
            }
            sb.append(')');
        }
    }

    public static boolean check(int n, int x, int y){
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(map[x][y] != map[i][j]) return false;
            }
        }
        return true;
    }
}