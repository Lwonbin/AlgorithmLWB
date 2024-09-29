import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());



        for(int i=0; i<N; i++){
            int min = Integer.MAX_VALUE;
            int max = 0;

            int[] arr = new int[26];

            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());


            if(K==1){
                bw.write("1 1"+"\n");
                continue;
            }

            for(int j=0; j<W.length(); j++){
                arr[W.charAt(j) - 'a']++;
            }


            for(int j=0; j<W.length(); j++){
                if(arr[W.charAt(j) - 'a']<K) continue;

                int count =1;

                for(int l = j+1; l<W.length(); l++){
                    if(W.charAt(j) == W.charAt(l)) count++;
                    if(count ==K){
                        max = Math.max(max, l-j+1);
                        min = Math.min(min , l-j+1);
                        break;
                    }
                }
            }

            if(min == Integer.MAX_VALUE || max == 0){
                bw.write(-1+"\n");
            }else{
                bw.write(min + " " + max+"\n");
            }






        }





        br.close();
        bw.flush();
        bw.close();

    }
}
