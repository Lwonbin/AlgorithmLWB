import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
        }

        for(int i=0; i<w; i++){
            queue.add(0);
        }

        int cnt = 0;
        int sum = 0;
        int time = 0;
        while(cnt < n){
            time++;

            sum -= queue.poll();

            if(arr[cnt] + sum <= L){
                sum+=arr[cnt];
                queue.add(arr[cnt]);
                cnt++;
            }else{
                queue.add(0);
            }
        }

        System.out.println(time+w);

    }
}
