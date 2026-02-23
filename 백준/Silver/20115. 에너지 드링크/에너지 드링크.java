    import java.io.*;
    import java.util.*;

    public class Main {


        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            double max = 0;
            double[] arr = new double[N];
            for (int i = 0; i < N; i++) {
                double cur = Double.parseDouble(st.nextToken());
                arr[i] = cur;
                max = Math.max(max, cur);
            }
            double S = 0;

            for (int i = 0; i < N; i++) {
                S += arr[i]/ 2;
            }

            S += max - (max / 2);

            System.out.println(S);


        }

    }