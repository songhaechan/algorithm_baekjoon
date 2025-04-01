import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        List<Integer> tmp = new ArrayList();
        Set<Integer> set = new HashSet();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(!set.contains(arr[i])){
                set.add(arr[i]);
                tmp.add(arr[i]);
            }
        }

        int[] tmp2 = new int[tmp.size()];

        for(int i=0; i<tmp.size(); i++){
            tmp2[i] = tmp.get(i);
        }
        

        Arrays.sort(tmp2);

        for(int i=0; i<n; i++){
            int result = lower(tmp2,arr[i]);
            sb.append(result);
            sb.append(" ");
        }

        System.out.println(sb.toString());

    }

    public static int lower(int[] arr, int t){
        int s = 0;
        int e = arr.length;

        while(s<e){
            int mid = (s+e)/2;

            if(arr[mid]>=t){
                e = mid;
            }else if(arr[mid]<t){
                s = mid+1;
            }
        }
        return s;
    }
}