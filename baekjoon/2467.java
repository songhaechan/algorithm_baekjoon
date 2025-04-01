
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        int[] solution = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solution);

        int l = 0;
        int r = N - 1;
        int min = Integer.MAX_VALUE;

        int resultL = l;
        int resultR = r;

        while (l < r) {
            if(min > Math.abs(solution[l]+solution[r])){
                resultL = l;
                resultR = r;
                min = Math.abs(solution[l]+solution[r]);
            }

            if(solution[l] + solution[r] > 0){
                r--;
            }else{
                l++;
            }
        }
        System.out.print(solution[resultL] + " " + solution[resultR]);
    }
}