    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {


        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());

            int[] A = new int[N];
            int[] B = new int[N];

            StringTokenizer stA = new StringTokenizer(br.readLine());
            StringTokenizer stB = new StringTokenizer(br.readLine());

            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(stA.nextToken());
                B[i] = Integer.parseInt(stB.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int answer = 0;
            for(int i=0; i<N; i++){
                answer += A[i] * B[N-i-1];
            }

            System.out.println(answer);

        }

    }