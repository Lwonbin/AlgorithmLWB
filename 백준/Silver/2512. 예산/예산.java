import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 도시의 개수

        Integer[] budget = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            budget[i] = Integer.parseInt(st.nextToken());
        }

        int MaxBudget = Integer.parseInt(br.readLine());

        int sum = 0;

        for(int j=0; j<N; j++){
            sum += budget[j];
        }

        Arrays.sort(budget);

        int left =0;
        int right = budget[N-1];
        if(sum<MaxBudget){
            bw.write((budget[N-1])+"");
        }else {

            while (left <= right) {
                int mid = (left + right) / 2;
                long budget2 = 0;
                for (int i = 0; i < N; i++) {
                    if (budget[i] > mid) {
                        budget2 += mid;
                    } else {
                        budget2 += budget[i];
                    }
                }
                if (budget2 <= MaxBudget) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
            bw.write(right + "");
        }



        br.close();
        bw.flush();
        bw.close();
    }
}
