    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];

            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int X = Integer.parseInt(br.readLine());


            Arrays.sort(arr);

            //1 2 3 5 7 9 10 11 12

            int start = 0;
            int end = N-1;

            int answer = 0;

            while(start < end){

                int cur = arr[start] + arr[end];
                if(cur == X){
                    answer++;
                    start++;
                    end--;
                }else if(cur < X){
                    start++;
                }else{
                    end--;
                }
            }

            System.out.println(answer);


        }

    }