import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());


            int[] AList = new int[N];
            int[] BList = new int[M];

            StringTokenizer Ast = new StringTokenizer(br.readLine());
            StringTokenizer Bst = new StringTokenizer(br.readLine());

            for(int p = 0; p<N; p++){
                AList[p] = Integer.parseInt(Ast.nextToken());
            }
            for(int q = 0; q<M; q++){
                BList[q] = Integer.parseInt(Bst.nextToken());
            }

            Arrays.sort(AList);
            Arrays.sort(BList);

            int j =0;
            long count = 0;

            for(int k=0; k<N; k++){
                while(j<M && AList[k] > BList[j]){
                    j++;
                }
                count += j;
            }


            bw.write(count+"\n");

        }

        bw.flush();
        br.close();
        bw.close();

    }
}
