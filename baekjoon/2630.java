import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] map;
    static int[] result = new int[2];
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
            }
        }
        recursion(n,0,0);
        System.out.println(result[0]);
        System.out.println(result[1]);

    }

    public static void recursion(int n,int x, int y){
        if(check(n,x,y)){
            result[map[x][y]]++;
        }else{
            int newN = n/2;
            for(int i=0; i<2; i++){
                for(int j=0; j<2; j++){
                    recursion(newN,x+newN*i,y+newN*j);
                }
            }
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