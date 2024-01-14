import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,(arr1,arr2) -> {
            if(arr1[0] == arr2[0]){
                return arr1[1] - arr2[1];
            }else{
                return arr1[0] - arr2[0];
            }
        });

        for(int q=0; q<N; q++){
            for(int p=0; p<2; p++){
                bw.write(arr[q][p]+" ");
            }
            bw.write("\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }
}
