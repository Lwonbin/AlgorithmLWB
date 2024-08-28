import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] arr = new int[W];

        for(int i=0; i<W; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }



        int sum = 0;
        for(int i=1; i<arr.length-1; i++){
            int left = 0;
            int right = 0;


            for(int l=0; l<i; l++){
                left = Math.max(arr[l], left);
            }
            for(int r=i+1; r<W; r++){
                right = Math.max(arr[r], right);
            }


            if(left > arr[i] && arr[i] < right){
                sum += Math.min(left, right) - arr[i];
            }

        }
        bw.write(sum+"");

        br.close();
        bw.flush();
        bw.close();

    }
}
