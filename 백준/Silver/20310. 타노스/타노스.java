import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0,0);
        hashMap.put(1,0);
        for(int i =0; i<S.length(); i++){
            if(S.charAt(i)=='0'){
                hashMap.put(0,hashMap.get(0)+1);
            }else {
                hashMap.put(1, hashMap.get(1)+1);
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int j=0; j<hashMap.get(0)/2; j++) {
            sb.append("0");
        }
        for(int i=0; i<hashMap.get(1)/2; i++) {
            sb.append("1");
        }

        bw.write(sb+"");



        br.close();
        bw.flush();
        bw.close();
    }
}
