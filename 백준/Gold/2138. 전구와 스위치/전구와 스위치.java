import java.io.*;
import java.util.*;


public class Main {
    static char[] targetArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());

        String cur = br.readLine();
        String target = br.readLine();


        char[] curA = cur.toCharArray();
        char[] curB = cur.toCharArray();

        int countA = 0;
        int countB = 0;



        targetArray = target.toCharArray();


        //0을 누르는 경우
        for(int i=0; i<N; i++){
            if(i == 0){
//                System.out.println(0);
                curA[i] = curA[i] == '0' ? '1' : '0';
                curA[i+1] = curA[i+1] == '0' ? '1' : '0';
                countA++;

            }else if(i== N-1){
//                System.out.println(2);
                if(curA[i-1] != targetArray[i-1]){
                    curA[i-1] =  curA[i-1] == '0' ? '1' : '0';
                    curA[i] = curA[i] == '0' ? '1' : '0';
                    countA++;


                }
            }else{
//                System.out.println(1);
                if(curA[i-1] != targetArray[i-1]){
                    press(curA, i);
                    countA++;
                }
            }
//            System.out.println(Arrays.toString(curA));

        }


        //0을 안누르는 경우
        for(int i=1; i<N; i++){
            if(i==N-1){
                if(curB[i-1] != targetArray[i-1]){
                    curB[i-1] =  curB[i-1] == '0' ? '1' : '0';
                    curB[i] = curB[i] == '0' ? '1' : '0';
                    countB++;
                }
            }else{
                if(curB[i-1] != targetArray[i-1]) {
                    press(curB, i);
                    countB++;
                }
            }
        }

//        System.out.println(countA + " " + countB);
//        System.out.println(boolA + " " + boolB);

        boolean boolA = Arrays.equals(curA, targetArray);
        boolean boolB = Arrays.equals(curB, targetArray);

        if(!boolA && !boolB){
            bw.write(-1+"");
        }else{
            if(boolA && !boolB){
                bw.write(countA+"");
            }else if(!boolA && boolB){
                bw.write(countB+"");
            }else{
                int result = Math.min(countA, countB);
                bw.write(result + "");
            }

        }


        br.close();
        bw.flush();
        bw.close();



    }
    static void press(char[] arr, int i){
        for(int j=i-1; j<=i+1; j++){
            arr[j] = arr[j] == '0' ? '1' : '0';
        }
    }


}
