import java.io.*;
public class Main {
    public static String T;
    public static String S;

    public static int answer;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        T = br.readLine();


        dfs(T);

        bw.write(answer+"");


        br.close();
        bw.flush();
        bw.close();
    }
    private static void dfs(String t){
        int length = t.length();

        if(length == S.length()){
            if(t.equals(S)){
                answer = 1;
            }
            return;
        }

        if(t.charAt(t.length()-1)=='A'){
            dfs(t.substring(0,t.length()-1));
        }
        if(t.charAt(0)=='B'){
            dfs(new StringBuilder(t.substring(1)).reverse().toString());
        }
    }
}
