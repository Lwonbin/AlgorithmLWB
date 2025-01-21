import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int count;
    static int check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // step1. 빙고 로 주어진 숫자를 2차원 배열에 넣기

       arr = new int[5][5];
       count = 1;
       check = 0;

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                int num = Integer.parseInt(st.nextToken());


                for(int q=0; q<5; q++){
                    for(int p=0; p<5; p++){
                        if(arr[q][p]==num){
                            arr[q][p] = 0;

                        }
                    }
                }


                RowCheck();
                ColCheck();
                PdialogCheck();
                MdialogCheck();

                if(check>=3){
                    bw.write(count+"");
                    br.close();
                    bw.flush();
                    bw.close();
                    System.exit(0);
                }

                check = 0;
                count++;


            }

        }











    }

    private static void MdialogCheck() {
        int zerocheck = 0;
        for(int i=0; i<5; i++){
            if(arr[i][i]==0){
                zerocheck++;
            }
        }
        if(zerocheck==5){
            check++;
        }
    }

    //40 31 22 13 04으로 되어야함
    private static void PdialogCheck() {
        int zerocheck = 0;
        for(int i=0; i<5; i++){
            if(arr[i][4-i]==0){
                zerocheck++;
            }
        }
        if(zerocheck==5){
            check++;
        }
    }

    private static void ColCheck() {
        for(int i=0; i<5; i++){
            int zerocheck = 0;
            for(int j=0; j<5; j++){
                if(arr[j][i]==0){
                    zerocheck++;
                }
            }
            if(zerocheck==5){
                check++;
            }
        }
    }

    private static void RowCheck() {
        for(int i=0; i<5; i++){
            int zerocheck = 0;
            for(int j=0; j<5; j++){
                if(arr[i][j]==0){
                    zerocheck++;
                }
            }
            if(zerocheck==5){
                check++;
            }
        }
    }
}
