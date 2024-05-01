import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int range =2;
        int count =1;


        while(range<=N){
            if(N==1){
                bw.write(1+"");
            }else{
                range = range + (6*count);
                count++;
            }
        }

        bw.write(count+"");


        br.close();
        bw.flush();
        bw.close();

    }
}
