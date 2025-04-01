import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        List<Long> two = new ArrayList();

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                two.add(arr[i]+arr[j]);
            }
        }

        Collections.sort(two);

        for(int i=n-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(bs(two,arr[i]-arr[j])){
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }

    public static boolean bs(List<Long> arr,Long target){
        int s = 0;
        int e = arr.size()-1;

        while(s<=e){
            int m = (s+e)/2;
            if(arr.get(m)>target){
                e = m-1;
            }else if(arr.get(m)<target){
                s = m+1;
            }else{
                return true;
            }
        }
        return false;
    }
}