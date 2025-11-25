import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String DNA = br.readLine();

        st = new StringTokenizer(br.readLine());

        int[] need = new int[4];

        need[0] = Integer.parseInt(st.nextToken());
        need[1] = Integer.parseInt(st.nextToken());
        need[2] = Integer.parseInt(st.nextToken());
        need[3] = Integer.parseInt(st.nextToken());

        int[] cur = new int[4];
        for(int i=0; i<P; i++){
            cur[toIndex(DNA.charAt(i))]++;
        }

        int count = 0;
        if(check(cur,need)){
            count++;
        }


        for(int i=P; i<S; i++){
            cur[toIndex(DNA.charAt(i-P))]--;

            cur[toIndex(DNA.charAt(i))]++;

            if(check(cur, need)){
                count++;
            }
        }


        System.out.println(count);



        br.close();
        bw.flush();
        bw.close();


    }

    static int toIndex(char cur){
        if(cur == 'A') return 0;
        else if(cur == 'C') return 1;
        else if(cur =='G') return 2;
        return 3;
    }


    static boolean check(int[] cur, int[] need){
        for(int i=0; i<4; i++){
            if(cur[i] < need[i]) return false;
        }

        return true;
    }


}
