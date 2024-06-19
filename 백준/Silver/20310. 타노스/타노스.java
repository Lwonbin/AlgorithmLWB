import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        int num0=0;
        int num1=0;


        StringBuilder sb = new StringBuilder();

        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='0'){
                num0++;
                sb.append('0');

            }else{
                num1++;
                sb.append('1');
            }
        }

        num1 /= 2;
        num0 /= 2;


        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i)=='1'){
                sb.setCharAt(i,'2');
                num1--;
            }

            if(num1==0){
                break;
            }
        }

        for(int j=sb.length()-1; j>=0; j--) {
            if (sb.charAt(j) == '0') {
                sb.setCharAt(j, '2');
                num0--;
            }

            if (num0 == 0) {
                break;
            }
        }

        for(int p=0; p<sb.length(); p++){
            if(sb.charAt(p)=='0' || sb.charAt(p)=='1'){
                bw.write(sb.charAt(p)+"");
            }
        }




        br.close();
        bw.flush();
        bw.close();
    }
}
