import java.io.*;
import java.util.*;


public class Main {
    static String[] seg = {
            "1110111", // 0
            "0010010", // 1
            "1011101", // 2
            "1011011", // 3
            "0111010", // 4
            "1101011", // 5
            "1101111", // 6
            "1010010", // 7
            "1111111", // 8
            "1111011"  // 9
    };
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;


        //몇층인지 - N
        int N = Integer.parseInt(st.nextToken());

        //자릿 수
        int K = Integer.parseInt(st.nextToken());

        //몇개 반전시킬 건지
        int P = Integer.parseInt(st.nextToken());

        //실제 몇층에 멈춰 있는지
        int X = Integer.parseInt(st.nextToken());

        String formatX = String.format("%0" + K + "d", X);



        for (int i = 1; i <= N; i++) {
            int count =0;

            if (i == X) continue;


            String cur = String.format("%0" + K + "d", i);

            for(int j=0; j<K; j++){
                int a = formatX.charAt(j) - '0';
                int b = cur.charAt(j) - '0';

                count += diffCount(seg[a], seg[b]);

            }


            if(count <= P){
                result++;
            }

        }


        System.out.println(result);








        br.close();
        bw.flush();
        bw.close();

    }

    private static int diffCount(String s, String s1) {
        int count = 0;

        for(int i=0; i<7; i++){
            if(s.charAt(i) != s1.charAt(i)){
                count++;
            }
        }
        return count;

    }
}
