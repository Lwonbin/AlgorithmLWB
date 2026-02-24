    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {


        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] sik = br.readLine().split("-");

            int answer = 0;
            int firstSik = 0;
            String[] curSik2 = sik[0].split("\\+");
            for(int i =0; i<curSik2.length; i++){
                firstSik += Integer.parseInt(curSik2[i]);
            }

            answer += firstSik;

            for(int i=1; i<sik.length; i++){
                String cur = sik[i];
                String[] curSik = cur.split("\\+");
                int sum = 0;

                for(int j=0; j<curSik.length; j++){
                    sum -= Integer.parseInt(curSik[j]);
                }


                answer += sum;


            }


            System.out.println(answer);

        }

    }