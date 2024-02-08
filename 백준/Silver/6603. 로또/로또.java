import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int K=0;
    static boolean[] check;
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if(K==0){
                break;
            }else{
                arr = new int[K];
                check = new boolean[K];

                for(int i=0; i<K; i++){
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                f(0,0);
                System.out.println();
            }


        }
    }

    static void f(int dp, int start) throws IOException {
        if(dp==6){
            for(int i=0; i<K; i++){
                if(check[i]){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
        }
        for(int i= start; i<K; i++){
            check[i]=true;
            f(dp+1,i+1);
            check[i] = false;
        }

    }

}
