import java.io.*;
import java.util.StringTokenizer;

public class Main{
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

        int[] counter = new int[N];

        for(int p=0; p<N; p++){
            for(int q=p+1; q<N; q++){
                if(arr[p][0] > arr[q][0] && arr[p][1] > arr[q][1]){
                    counter[q]++;
                }else if(arr[p][0] < arr[q][0] && arr[p][1] < arr[q][1]){
                    counter[p]++;
                }
            }
        }

        for(int x=0; x<N; x++){
            bw.write(++counter[x]+" ");
        }



        br.close();
        bw.flush();
        bw.close();

    }
}
