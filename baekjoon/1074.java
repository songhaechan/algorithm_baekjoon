import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(z(N,r,c));
    }
    public static int z(int N, int r, int c){
        if(N==0) return 0;
        int half = (int)Math.pow(2,N-1);
        if(r<half && c<half) return z(N-1,r,c);
        if(r<half && c>=half) return (half*half + z(N-1,r,c-half));
        if(r>= half && c<half) return (2*half*half + z(N-1,r-half,c));
        return (3*half*half + z(N-1,r-half,c-half));
    }
}