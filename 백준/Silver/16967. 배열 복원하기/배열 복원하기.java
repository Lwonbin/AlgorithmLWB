import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());


        int[][] arr = new int[H+X][W+Y];

        for(int i=0; i<H+X; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W+Y; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int[][] arrFirst = new int[H][W];

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                arrFirst[i][j] = arr[i][j];
            }
        }



        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(i>=X && j>=Y){
                    arrFirst[i][j] = arrFirst[i][j] - arrFirst[i-X][j-Y];
                }else{
                    arrFirst[i][j] = arr[i][j];
                }
            }
        }




        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                System.out.print(arrFirst[i][j]+" ");
            }
            System.out.println();
        }




        br.close();
        bw.flush();
        bw.close();
    }
}
