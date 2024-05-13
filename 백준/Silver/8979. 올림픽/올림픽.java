import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int country = Integer.parseInt(st.nextToken())-1;
        int[][] arr = new int[N][3];
        int rank = 1;

        for(int i=0; i<N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st2.nextToken())-1;
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            arr[index][0] = a;
            arr[index][1] = b;
            arr[index][2] = c;

        }

        for(int j=0; j<N; j++) {
            if (arr[country][0] < arr[j][0]) {
                rank++;
            }else if(arr[country][0]==arr[j][0] && arr[country][1] < arr[j][1]){
                rank++;
            }else if(arr[country][0] == arr[j][0] && arr[country][1] == arr[j][1] && arr[country][2] < arr[j][2]){
                rank++;
            }
        }

        bw.write(rank+"");





        br.close();
        bw.flush();
        bw.close();

    }
}
