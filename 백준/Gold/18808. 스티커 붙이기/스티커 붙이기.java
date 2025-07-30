import java.io.*;
import java.util.*;

public class Main {
    static int[][] notebook;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        //세로
        int N = Integer.parseInt(st.nextToken());
        //가로
        int M = Integer.parseInt(st.nextToken());
        //스티거 갯수
        int K = Integer.parseInt(st.nextToken());

        notebook = new int[N][M];


        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[y][x];

            for(int j=0; j<y; j++){
                st= new StringTokenizer(br.readLine());
                for(int p=0; p<x; p++){
                    sticker[j][p] = Integer.parseInt(st.nextToken());
                }
            }
            
                boolean attached = false;
                for (int rot = 0; rot < 4 && !attached; rot++) {
                    for (int sy = 0; sy + sticker.length <= N && !attached; sy++) {
                        for (int sx = 0; sx + sticker[0].length <= M && !attached; sx++) {
                            if (check(sticker, sx, sy)) {
                                putSticker(sticker, sx, sy);
                                attached = true;
                            }
                        }
                    }
                    if (!attached) sticker = turn(sticker);
                }
                




        }

        int result = 0;

        for(int j=0; j<N; j++){
            for(int p=0; p<M; p++){
                if(notebook[j][p]==1){
                    result++;
                }
            }

        }
        System.out.println(result);


        br.close();
        bw.flush();
        bw.close();

    }


    static int[][] turn(int[][] sticker){
        int r = sticker.length;
        int c = sticker[0].length;
        int[][] newSticker = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newSticker[j][r - 1 - i] = sticker[i][j];
            }
        }
        return newSticker;
    }

    static boolean check(int[][] sticker, int x, int y){
        int r = sticker.length;
        int c = sticker[0].length;
        if (y + r > notebook.length || x + c > notebook[0].length) return false;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j] == 1 && notebook[y + i][x + j] == 1) return false;
            }
        }
        return true;
    }

    static void putSticker(int[][] sticker, int x, int y){
        int r = sticker.length;
        int c = sticker[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j] == 1) notebook[y + i][x + j] = 1;
            }
        }
    }


}
