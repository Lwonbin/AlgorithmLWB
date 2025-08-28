import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[] alpahbet;
    static int L,C;

    static StringBuilder sb = new StringBuilder();
    static char[] result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());


        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpahbet = new char[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            alpahbet[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpahbet);

        result = new char[L];

        dfs(0,0);

        System.out.print(sb);

        br.close();

    }


    static void dfs(int depth, int start){

        if(depth == L){
            if(isValid(result)){
                sb.append(new String(result)).append("\n");
            }
            return;
        }


        for(int i = start; i<C; i++){
            result[depth] = alpahbet[i];
            dfs(depth +1, i+1);
        }
    }


    static boolean isValid(char[] result){
        int wkdma = 0; int ahdma = 0;


        for(char c : result){
            if("aeiou".indexOf(c) >= 0){
                wkdma++;
            }else{
                ahdma++;
            }
        }

        if(wkdma >=1 && ahdma>=2){
            return true;
        }else{
            return false;
        }

    }




}
