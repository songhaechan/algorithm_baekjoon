import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Integer n = Integer.parseInt(st.nextToken());
        Integer max = Integer.MAX_VALUE;
        Deque<Integer> stack = new ArrayDeque();
        int[] building = new int[n];
        int[] result = new int[n];

        stack.push(new B(max,0));

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            building[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=n-1; i>=0; i--){
            while(stack.peek().height < building[i]){
                stack.pop();
            }
            result[i] += 1;
            stack.push(new B(building[i],i));
        }   
    }


    static class B{
        public int height;
        public int index;

        public B(int h, int i){
            this.height = h;
            this.index = i;
        }
    }
}