import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String number = br.readLine();

        int cnt = 0;

        int[] arr = new int[10];

        for(int i=0; i<number.length(); i++){
            int cur = number.charAt(i) - '0';
            arr[cur]++;
        }


        arr[6] = (arr[6] + arr[9] + 1) /2;
        arr[9] = 0;


        for(int i=0; i<10; i++){
            cnt = Math.max(cnt, arr[i]);
        }

        System.out.println(cnt);





    }


}