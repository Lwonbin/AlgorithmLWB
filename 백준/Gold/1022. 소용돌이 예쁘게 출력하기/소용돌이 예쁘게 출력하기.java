import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int cnt = 0;


        int[] dx = {0, -1, 0 , 1};
        int[] dy = {1, 0, -1, 0};

        int row = Math.abs(r1 - r2) +1;
        int col = Math.abs(c1 - c2) +1;

        int[][] map = new int [row][col];
        boolean[][] visited = new boolean[row][col];



        int x = 0;
        int y = 0;

        int total = row*col;
        int count = 0;
        int num = 1;
        int len = 1;
        int dir = 0;

        int Maxcnt = 0;

        boolean flag = false;

        while(count<total) {

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < len; j++) {
                    if (x >= r1 && y >= c1 && x <= r2 && y <= c2) {
                        map[x-r1][y-c1] = num;
                        Maxcnt = Math.max(Maxcnt, num);
                        count++;
                    }

                    if (count == total) {
                        flag = true;
                    }

                    x += dx[dir];
                    y += dy[dir];
                    num++;
                }
                dir = (dir + 1) % 4;
                if(flag){
                    break;
                }
            }
            len++;
        }

        while(Maxcnt > 0){
            Maxcnt /= 10;
            cnt++;

        }




        String format = "%" + cnt + "d";

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.printf(format,map[i][j]);
                if(j<col-1){
                    System.out.print(" ");
                }

            }
            System.out.println();
        }



        br.close();
        bw.flush();
        bw.close();
    }
}
