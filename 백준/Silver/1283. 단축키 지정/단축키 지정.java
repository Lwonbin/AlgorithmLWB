import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());


        HashSet<Character> set = new HashSet<>();



        for(int i = 0; i < N; i++){
            boolean check = false;
            String str = br.readLine();
            String[] strArr = str.split(" ");

            for(int j=0; j<strArr.length; j++){
                char ch = Character.toLowerCase(strArr[j].charAt(0));
                if(!set.contains(ch)){
                    set.add(ch);
                    strArr[j] = "[" + strArr[j].charAt(0) + "]" + strArr[j].substring(1);
                    check = true;
                    str = String.join(" ", strArr);
                    break;
                }
            }



            if(!check){
                for(int j=0; j<str.length(); j++){
                    char ch = Character.toLowerCase(str.charAt(j));

                    if(ch != ' ' && !set.contains(ch)){
                        set.add(ch);
                        str = str.substring(0,j) + "[" + str.charAt(j) + "]" + str.substring(j+1);
                        check = true;
                        break;
                    }

                }

            }

            System.out.println(str);


        }


        br.close();
        bw.flush();
        bw.close();

    }
}
