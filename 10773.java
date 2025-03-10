import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Deque<Integer> stack = new ArrayDeque();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp == 0){
                stack.pop();
            }else{
                stack.push(tmp);
            }
        }

        int result = 0;

        while(!stack.isEmpty()){
            result += stack.pop();
        }

        System.out.print(result);

    }
}