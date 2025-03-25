import java.util.*;
import java.io.*;

class Main {
    static int zero = 0;
    static int one = 0;
    static int minusOne = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursion(n,0,0,map);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);

    }

    public static void recursion(int n, int x, int y, int[][] map){
        int result = isFull(n,x,y,map);
        if(result == -2){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    recursion(n/3,x+(i*n/3),y+(j*n/3),map);
                }
            }
        }else{
            if(result == 1){
                one++;
            }
            if(result == 0){
                zero++;
            }
            if(result == -1){
                minusOne++;
            }
        }
    }

    public static int isFull(int n, int x, int y, int[][] map){
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(map[x][y] != map[i][j]){
                    return -2;
                }
            }
        }
        return map[x][y];
    }
}