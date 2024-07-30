import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];


        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int ans = 0;
        int start = 0;
        int end = 0;
        int[] cnt= new int[100001];

        while(end < arr.length){
            while(end < arr.length && cnt[arr[end]] +1 <= K){
                cnt[arr[end]]++;
                end++;
            }
            int len = end - start;
            ans = Math.max(ans, len);
            cnt[arr[start]]--;
            start++;
        }
        System.out.println(ans);


    }
}
