import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for(int i = 0; i<N; i++){
            String string = br.readLine();
            arr[i] = string;
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }else{
                    return o1.length() - o2.length();
                }
            }
        });

        bw.write(arr[0]+"\n");
        for(int j=1; j<N; j++){
            if(!arr[j].equals(arr[j-1])){
                bw.write(arr[j]+"\n");
            }
        }




        br.close();
        bw.flush();
        bw.close();
    }
}
