import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<T> stack = new ArrayDeque();

        int n = Integer.parseInt(st.nextToken());
        int[] tower = new int[n];
        int[] result = new int[n];

        st = new StringTokenizer(br.readLine());
        stack.push(new T(100000001,0));
        for(int i=0; i<n; i++){
            int t=Integer.parseInt(st.nextToken());
            while(stack.peek().value < t){
                stack.pop();
            }
            result[i] = stack.peek().index;
            stack.push(new T(t,i+1));
        }

        // 바킹독 풀이 <정순>


        // 내 풀이 <역순>
        // for(int i=n-1; i>=0; i--){
        //     while(!stack.isEmpty() && tower[i] > tower[stack.peek()]){
        //         int index = stack.pop();
        //         result[index] = i+1;
        //     }
        //     stack.push(i);
        // }

        // while(!stack.isEmpty()){
        //     int index = stack.pop();
        //     result[index] = 0;
        // }

        for(int i=0; i<n; i++){
            System.out.print(result[i] + " ");
        }
    }

    static class T{
        public int value;
        public int index;

        public T(int v, int i){
            this.value = v;
            this.index = i;
        }
    }
}