import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                }
                else if (o1.length() == o2.length()) {
                    if (sum(o1) == sum(o2)) {
                        return o1.compareTo(o2);
                    } else {
                        return Integer.compare(sum(o1), sum(o2));
                    }

                } else {
                    return 1;
                }
            }
        });

        for(int j=0; j<N; j++){
            bw.write(arr[j]+"\n");
        }


        br.close();
        bw.flush();
        bw.close();

    }

    public static int sum(String str){
        int sum=0;
        for(int i=0; i<str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sum += str.charAt(i) - '0';
            }
        }
        return sum;
    }
}


