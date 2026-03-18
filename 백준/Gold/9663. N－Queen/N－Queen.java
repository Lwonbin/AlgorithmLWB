    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {

        static int N;
        static int[] queen;
        static int answer = 0;
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            N = Integer.parseInt(br.readLine());

            queen = new int[N];
            dfs(0);

            System.out.println(answer);

        }



        static void dfs(int row){
            if(row == N){
                answer++;
                return;
            }


            for(int col=0; col<N; col++){
                queen[row] = col;
                if(possible(row)){
                    dfs(row+1);
                }
            }
        }

        static boolean possible(int row){
            for(int i=0; i<row; i++){
                if(queen[i] == queen[row]){
                    return false;
                }

                if(Math.abs(row-i) == Math.abs(queen[row]-queen[i])){
                    return false;
                }
            }
            return true;
        }








    }