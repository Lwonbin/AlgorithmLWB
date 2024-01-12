import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N1 = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int[] arr1 = new int[N1];
        for(int i =0; i<N1; i++){
            arr1[i] =(Integer.parseInt(st1.nextToken()));
        }

        int N2 = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] arr2 = new int[N2];

        for(int j =0; j<N2; j++){
            arr2[j] = (Integer.parseInt(st2.nextToken()));
        }

        for(int p=0; p<N2; p++){
            int count=0;
            for(int q=0; q<N1; q++){
                if(arr2[p]==arr1[q]){
                    count++;
                    break;
                }
            }
            if(count==1){
                bw.write(1+"\n");
            }else{
                bw.write(0+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
