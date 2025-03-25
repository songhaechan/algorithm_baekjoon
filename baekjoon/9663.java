import java.util.*;
import java.io.*;

class Main {
    static int[][] board;
    static int result = 0;
    static int n;
    static boolean[] col, diag1, diag2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        col = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        // board = new int[n][n];

        recursion(0,new ArrayList());
        System.out.println(result);
    }

    public static void recursion(int depth, List<int[]> memo){
        if(depth == n){
            result++;
            return;
        }

        for(int i=0; i<n;i++){
            if (col[i] || diag1[depth + i] || diag2[depth - i + (n - 1)]) continue;
            col[i] = diag1[depth + i] = diag2[depth - i + (n - 1)] = true;
            recursion(depth+1,memo);
            col[i] = diag1[depth + i] = diag2[depth - i + (n - 1)] = false;
        }
    }
}