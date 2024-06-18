import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int result = 0;

        String first = br.readLine();

        for(int i = 1; i < N; i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder(first);
            String first2 = sb.toString();

            for(int j = 0; j < str.length(); j++) {
                for(int p = 0; p < first2.length(); p++) {
                    if(str.charAt(j) == first2.charAt(p)) {
                        count++;
                        sb.setCharAt(p, 'c');
                        first2 = sb.toString();
                        break;
                    }
                }

            }


            if((count == first.length() && first.length() == str.length())|| (count == first.length() && first.length() == str.length()-1)||(count-1 == first.length() && first.length() == str.length())) {
                result++;
            } else if(count + 1 == first.length()) {
                if(str.length() == first.length() || str.length() == count) {
                    result++;
                }
            }

            count = 0;
        }

        bw.write(result + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
