    import java.io.*;
    import java.sql.SQLOutput;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


            String S = br.readLine();

            int countOne = 0;
            int countZero = 0;


            int idx = 1;

            char cur = S.charAt(0);
            if(cur == '0'){
                countZero++;
            }else{
                countOne++;
            }

            while(idx < S.length()){

                if(cur != S.charAt(idx)){
                    if(S.charAt(idx)=='0'){
                        countZero++;
                        cur = S.charAt(idx);
                    }else{
                        countOne++;
                        cur = S.charAt(idx);
                    }
                }
                idx++;

            }

            System.out.println(Math.min(countOne,countZero));

        }

    }