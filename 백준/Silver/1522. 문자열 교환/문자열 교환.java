import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();

        int count_Change = Integer.MAX_VALUE;
        int count_a = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == 'a'){
                count_a++;
            }
        }

        for(int i=0; i<arr.length; i++){
            int count_b=0;
            for(int j=i; j<i+count_a; j++){
                if(arr[j%arr.length]=='b'){
                    count_b++;
                }
            }

            count_Change = Math.min(count_Change, count_b);
        }

        bw.write(count_Change+"");




        br.close();
        bw.flush();
        bw.close();

    }
}
