import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[20];


        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int count = 0;

            int[] smallarr;

            for(int j=0; j<20; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int q=1; q<20; q++){
                int count2=0;
                smallarr = new int[q];
                for(int x=0; x<q; x++){
                    smallarr[x] = arr[x];
                }

                for(int p=q-1; p>=0; p--){
                    if(arr[q] < smallarr[p]){
                        count2 += 1;
                    }
                }
                if(count2>0){
                    count += count2;
                }
            }
            bw.write(number +" " +count+"\n");
        }



        br.close();
        bw.flush();
        bw.close();
    }
}
