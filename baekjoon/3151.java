import java.util.*;
import java.io.*;
class Main {
    static int[] students;
    static int n;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        students = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            students[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(students);


        long count = 0;

        for(int i=0; i<n-1; i++){
            visit = new boolean[n];
            for(int j=i+1; j<n; j++){
                long lower = lower(-(students[i]+students[j]));
                long upper = upper(-(students[i]+students[j]));
                if(upper-lower != 0 && lower != i && lower !=j){
                    count += upper-lower;
                }
            }
        }

        System.out.println(count/3);
    }

    public static long lower(int t){
        int s = 0;
        int e = n;
        while(s<e){
            int m = (s+e)/2;
            if(students[m]>=t){
                e = m;
            }else if(students[m]<t){
                s = m+1;
            }
        }
        return (long)s;
    }

    public static long upper(int t){
        int s = 0;
        int e = n;

        while(s<e){
            int m = (s+e)/2;
            if(students[m]>t){
                e = m;
            }else if(students[m]<=t){
                s = m+1;
            }
        }
        return (long)s;
    }
}