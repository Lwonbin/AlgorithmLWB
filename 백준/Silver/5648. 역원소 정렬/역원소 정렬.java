import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = st.countTokens() -1;

        int N = Integer.parseInt(st.nextToken());

        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }

        while(N != i){
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                list.add(st.nextToken());
                i++;
            }
        }



        long[] arr = new long[N];
        for (int j = 0; j < N; j++) {
            arr[j] = reverseNumber(list.get(j));
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (long num : arr) {
            sb.append(num).append("\n");
        }

        System.out.print(sb);
    }

    static long reverseNumber(String num) {
        StringBuilder sb = new StringBuilder(num);
        return Long.parseLong(sb.reverse().toString());
    }
}
