import java.io.*;

public class Main {
    static StringBuilder answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String N = "";
        while( (N = br.readLine()) != null ){
            int n = Integer.parseInt(N);
            int len = (int) Math.pow(3,n);
            answer =new StringBuilder();


            for(int i=0; i<len; i++){
                answer.append("-");
            }

            func(0, len);
            System.out.println(answer);
        }

    }
    public static void func(int start,int size) {
        if(size==1) {
            return;
        }
        int newSize=size/3;
        // 3등분한 문자열의 2번째 부분 공백처리
        for(int i=start+newSize; i<start+2*newSize; i++) {
            answer.setCharAt(i, ' ');
        }

        func(start, newSize); // 3등분한 문자열에서 첫번째 부분
        func(start+2*newSize, newSize); // 3등분한 문자열의 세번째 부분
    }
}
