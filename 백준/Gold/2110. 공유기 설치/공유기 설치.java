import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int C;
    static int result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i =0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
        }


        Arrays.sort(arr);

        int start = 1;

        int end = arr[N-1] - arr[0];


        if(N==2){
            System.out.println(end);
            return;
        }


        while(start <= end){
            int mid = (end + start) / 2;

            boolean CAN = canInstall(mid);

            if(CAN){
                result = mid;
                start = mid + 1;
            }else{
                end = mid -1;
            }

        }


        System.out.println(result);




        br.close();
        bw.flush();
        bw.close();

    }


    static boolean canInstall(int distance){
        int count = 1;
        int last = arr[0];


        for(int i=1; i<arr.length; i++){
            if(arr[i] - last >= distance){
                count++;
                last = arr[i];
            }

            if(count >= C) return true;
        }
        return false;
    }
}
