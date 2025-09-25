import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = "";
        for(int i=0; i<4; i++){
            str+= st.nextToken();
        }

        int str1 = Integer.parseInt("" + str.charAt(0) + str.charAt(1) + str.charAt(2) + str.charAt(3));
        int str2=  Integer.parseInt(""+ str.charAt(1) + str.charAt(2) +  str.charAt(3) + str.charAt(0));
        int str3 = Integer.parseInt(""+ str.charAt(2) + str.charAt(3) +  str.charAt(0) + str.charAt(1));
        int str4 = Integer.parseInt(""+ str.charAt(3) + str.charAt(0) +  str.charAt(1) + str.charAt(2));


        int min = Math.min(Math.min(Math.min(str1, str2),str3),str4);
        int count = 0;


        int start = 1111;
        while (start < min){
            String cur = String.valueOf(start);
            boolean check = false;
            for(int i=0; i<4; i++){
                if(cur.charAt(i) == '0'){
                    check = true;
                }
            }

            if(!check){
                int cur1 = Integer.parseInt("" + cur.charAt(0) + cur.charAt(1) + cur.charAt(2) + cur.charAt(3));
                int cur2=  Integer.parseInt(""+ cur.charAt(1) + cur.charAt(2) +  cur.charAt(3) + cur.charAt(0));
                int cur3 = Integer.parseInt(""+ cur.charAt(2) + cur.charAt(3) +  cur.charAt(0) + cur.charAt(1));
                int cur4 = Integer.parseInt(""+ cur.charAt(3) + cur.charAt(0) +  cur.charAt(1) + cur.charAt(2));

                int curMin = Math.min(Math.min(Math.min(cur1, cur2),cur3),cur4);

                if(curMin == start){
                    count++;
                }
            }



            start++;




        }

        System.out.println(count+1);






        br.close();

    }
}
