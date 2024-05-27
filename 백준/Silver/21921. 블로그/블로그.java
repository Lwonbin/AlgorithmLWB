import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int x = X;

        HashMap<Integer,Integer> map = new HashMap<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }


        int sum = 0;  // sum을 초기화
        for(int i=0; i<X; i++){
            sum += arr[i];
        }

        int maxSum = sum;
        int count =1;


        for(int j = X; j<N; j++) {
            sum = sum - arr[j-X] +arr[j];
            if(sum>maxSum){
                maxSum = sum;
                count =1;
            }else if(sum==maxSum){
                count++;
            }
        }

        if(maxSum==0){
            bw.write("SAD");
        }else{
            bw.write(maxSum+"\n");
            bw.write(count+"");
        }











        br.close();
        bw.flush();
        bw.close();

    }
}
