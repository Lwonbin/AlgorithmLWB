import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        boolean check = false;

        String HP = br.readLine();
        char[] arr = new char[N];

        for(int i=0; i<N; i++){
            arr[i] = HP.charAt(i);
        }



        for(int i=0; i<N; i++){
            if(HP.charAt(i)=='P') {
                for (int j = K; j > 0; j--) {
                    if(i-j>=0 && arr[i-j]=='H'){
                        count++;
                        arr[i-j] = 'L';
                        check = true;
                        break;
                    }
                }
                if(!check) {
                    for (int j = 1; j <= K; j++) {
                        if (i + j < N && arr[i + j] == 'H') {
                            count++;
                            arr[i + j] = 'L';
                            break;
                        }
                    }
                }
            }
            check = false;

        }
        bw.write(count+"");

        br.close();
        bw.flush();
        bw.close();

    }
}
