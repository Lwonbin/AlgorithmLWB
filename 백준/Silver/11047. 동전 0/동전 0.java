    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {


        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] money = new int[N];
            for(int i=N-1; i>=0; i--){
                money[i] = Integer.parseInt(br.readLine());
            }


            int count = 0;
            for(int i=0; i<N; i++){

                int cur = money[i];
                while(true){
                    if(K == 0){
                        break;
                    }

                    if(K >= cur){
                        K -= cur;
                        count++;
                    }else{
                        break;
                    }
                }
            }

            System.out.println(count);





        }

    }